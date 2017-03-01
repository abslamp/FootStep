package demo.service.impl;

import demo.domain.Department;
import demo.domain.DepartmentMapper;
import demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LZMA on 17-2-21.
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Department queryById(Long id) {
        return departmentMapper.findById(id);
    }

    @Override
    public List<Department> queryAll() {
        return departmentMapper.findAll();
    }

    @Override
    public int update(Long id, Department replace) {
        replace.setRank(getDeptRank(replace));
        return departmentMapper.update(id, replace);
    }

    @Override
    public int delete(Long id) {
        return departmentMapper.delete(id);
    }

    @Override
    public int insert(Department target) {
        target.setRank(getDeptRank(target));
        return departmentMapper.insert(target);
    }

    /**
     * 获取Department的rank域的应有值
     * @param d 目标
     * @return 目标的rank域
     */
    private int getDeptRank(Department d){
        Department father = departmentMapper.findById(new Long(d.getSuperiorId()));
        return father.getRank()+1;
    }
}
