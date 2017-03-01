package demo.controller;

import demo.domain.Department;
import demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LZMA on 2017/2/19.
 */

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @RequestMapping(value = "/id" ,method= {RequestMethod.GET, RequestMethod.POST} )
    public Department queryById(Long id) {
        return departmentService.queryById(id);
    }

    @RequestMapping(value = "/all")
    public JsTreeNode queryAll() {

        List<Department> departments = departmentService.queryAll();
        JsTreeNode root = new JsTreeNode();
        // NOTICE : support tree only, DO NOT STORE FOREST IN DATABASE!
        root.id = departments.get(0).getId().toString();
        root.text = departments.get(0).getName();
        root.children = new ArrayList<>();
        departments.remove(0);
        root.addChildren(departments);

        return root;
    }

    @RequestMapping(value = "/alloptionlabel")
    public List<JsTreeNode> queryByOptionLabel() {
        List<Department> departments = departmentService.queryAll();
        JsTreeNode root = new JsTreeNode();
        // NOTICE : support tree only, DO NOT STORE FOREST IN DATABASE!
        root.id = departments.get(0).getId().toString();
        root.text = departments.get(0).getName();
        root.children = new ArrayList<>();
        departments.remove(0);
        root.addChildren(departments);

        List<JsTreeNode> result = new ArrayList<>();
        parseOptionLabel("",root,result);
        return result;
    }

    @RequestMapping(value = "/delete")
    public int delete(Long id) {
        Department department = departmentService.queryById(id);
        //If the node to be deleted is a root node then reject
        if(department.getId() == department.getSuperiorId() ) {
            return 0;
        }else {
            return departmentService.delete(id);
        }
    }

    @RequestMapping(value = "/insert")
    public int insert(Department target) {
        //ignore id
        target.setId(null);
        return departmentService.insert(target);
    }

    @RequestMapping(value = "/update")
    public int update(Long updateId,Department target) {
        // filter , prevent editing specific property of root node
        if(updateId==null) return 0;
        if(updateId==1) {
            target.setSuperiorId(1);
        }

        return departmentService.update(updateId, target);
    }

    public void parseOptionLabel(String prefix,JsTreeNode node,List<JsTreeNode> data){
        JsTreeNode insertNode = new JsTreeNode();
        insertNode.id = node.id;
        insertNode.text = prefix+node.text;
        data.add(insertNode);
        for(JsTreeNode child : node.children) {
            parseOptionLabel(prefix+"　",child,data);
        }
    }

    public class JsTreeNode {
        String id;
        String text;
        List<JsTreeNode> children;

        public String getId() {
            return id;
        }

        public String getText() {
            return text;
        }

        public List<JsTreeNode> getChildren() {
            return children;
        }

        public void addChildren(List<Department> data) {
            for(Department d : data){
                if(d.getSuperiorId()==Integer.parseInt(this.id)) {

                    JsTreeNode childNode = new JsTreeNode();
                    childNode.id = d.getId().toString();
                    childNode.text = d.getName();
                    childNode.children = new ArrayList<>();

                    childNode.addChildren(data);

                    this.children.add(childNode);
                }
            }
        }

    }

}
