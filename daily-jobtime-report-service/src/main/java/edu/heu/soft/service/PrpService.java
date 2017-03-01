package edu.heu.soft.service;


import edu.heu.soft.domain.Prp;

import java.util.List;

/**
 * Created by LZMA on 2017/2/18.
 */
public interface PrpService {
    List<Prp> query(Prp cond, int page);
    int getCount(Prp cond);
    Prp queryById(Long id);
    int update(Long id, Prp replace);
    int delete(Long id);
    int insert(Prp target);
}
