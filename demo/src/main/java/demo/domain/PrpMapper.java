package demo.domain;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LZMA on 2017/2/18.
 */
public interface PrpMapper {

    Prp findById(Long id);
    List<Prp> find(@Param("cond") Prp cond, @Param("offset") int offset, @Param("total") int total);
    int getCount(Prp cond);
    int insert(Prp prp);
    int update(@Param("id") Long id, @Param("prp") Prp prp);
    int delete(Long id);

}
