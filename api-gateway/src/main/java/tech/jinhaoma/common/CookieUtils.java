package tech.jinhaoma.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by mjrt on 2/23/2017.
 */
public class CookieUtils {

    public static Cookie findCookieByName(String name , HttpServletRequest request){

        Cookie[] array = request.getCookies();
        for (Cookie cookie : array){
            if(name.equals(cookie.getName()))
                return cookie;
        }
        return null;
    }
}
