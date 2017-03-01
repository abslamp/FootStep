package edu.heu.soft.controller;


import edu.heu.soft.domain.Prp;
import edu.heu.soft.service.PrpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by LZMA on 2017/2/19.
 */

@RestController
@RequestMapping("/prp")
public class PrpController {

    @Autowired
    PrpService prpService;

    @RequestMapping(value="/id" ,method= RequestMethod.GET)
    public Prp queryById(Long id) {
        return prpService.queryById(id);
    }

    @RequestMapping(value="/all")
    public List<Prp> queryAll(Prp cond, int page) {
        return prpService.query(cond,page);
    }

    @RequestMapping(value="rowscount")
    public int rowsCount(Prp cond) {
        return prpService.getCount(cond);
    }

    @RequestMapping(value="delete")
    public int delete(Long id) {
        if(id == null) {
            return 0;
        }
        return prpService.delete(id);
    }

    @RequestMapping(value = "/update")
    public int update(Prp replace) {
        return prpService.update(replace.getId(),replace);
    }

    @RequestMapping(value = "/insert")
    public int insert(Prp target){
        target.setId(null); // flush it away
        return prpService.insert(target);
    }


}
