package tech.jinhaoma.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import tech.jinhaoma.common.RSAUtils;

/**
 * Created by mjrt on 2/20/2017.
 */

/*
    iss：Issuer，发行者
    sub：Subject，主题
    aud：Audience，观众
    exp：Expiration time，过期时间
    nbf：Not before
    iat：Issued at，发行时间
    jti：JWT ID
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class TokenPayload {

    private String iss;
    private int sub;
    private String aud;
    private Long iat ;  //= System.currentTimeMillis();
    private Long exp ;

}
