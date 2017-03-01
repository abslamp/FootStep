package edu.heu.soft.service.impl;

import edu.heu.soft.domain.Prp;
import edu.heu.soft.domain.PrpMapper;
import edu.heu.soft.service.PrpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LZMA on 2017/2/19.
 */

@Service
public class PrpServiceImpl implements PrpService {
    private static int pageSize=5;

    @Autowired
    private PrpMapper prpMapper;

    @Override
    public List<Prp> query(Prp cond, int page) {
        int offset = (page-1)*pageSize;
        //System.out.println("from:"+from+" total:"+to);
        return prpMapper.find(cond, offset, pageSize);
    }

    @Override
    public int getCount(Prp cond) {
        return prpMapper.getCount(cond);
    }

    @Override
    public Prp queryById(Long id) {
        Prp prp= prpMapper.findById(id);
        return prpMapper.findById(id);
    }


    @Override
    public int update(Long id, Prp replace) {
        return prpMapper.update(id,replace);
    }

    @Override
    public int delete(Long id) {
        return prpMapper.delete(id);
    }

    @Override
    public int insert(Prp target) {
        return prpMapper.insert(target);
    }
}
