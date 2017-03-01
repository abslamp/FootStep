package tech.jinhaoma.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by mjrt on 2/22/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

/*
    typ:类型
    alg:加密算法
 */
public class TokenHeader {

    private String typ;
    private String alg;
}
