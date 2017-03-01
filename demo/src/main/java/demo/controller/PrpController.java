package demo.controller;

import demo.domain.Prp;
import demo.service.PrpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public int delete(int id) {
        System.out.println("Wanna delete "+id);
        return 0;
    }

}
