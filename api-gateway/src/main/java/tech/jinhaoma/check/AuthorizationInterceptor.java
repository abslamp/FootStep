package tech.jinhaoma.check;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import tech.jinhaoma.common.TokenUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mjrt on 2/22/2017.
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(">>>MyInterceptor>>>>>>>在请求处理之前进行调用");

        String token = TokenUtils.getCookieValueFormRequest("token",request);

        boolean flag = token!=null && TokenUtils.checkToken(token);
        if(!flag){
            request.getRequestDispatcher("/error404.html").forward(request, response);
        }

        System.out.println(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
