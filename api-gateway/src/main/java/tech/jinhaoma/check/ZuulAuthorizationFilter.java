package tech.jinhaoma.check;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.context.annotation.Configuration;
import tech.jinhaoma.common.TokenUtils;
import tech.jinhaoma.domain.TokenPayload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mjrt on 2/23/2017.
 */
@Configuration
public class ZuulAuthorizationFilter extends ZuulFilter {

    private String token;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {

//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        token = TokenUtils.getCookieValueFormRequest("token",request);
//        System.out.println(token);
//        return token==null && !TokenUtils.checkToken(token);
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        token = TokenUtils.getCookieValueFormRequest("token", request);
        TokenPayload payload = TokenUtils.parseToken(token);

        System.out.println(payload.getSub());
        System.out.println(getAuthorizationNumber(request));

        if (payload == null){
            System.out.println("没有权限");
            try {
                response.sendRedirect("http://localhost:9001/common/login.html");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if(payload.getSub() > getAuthorizationNumber(request))  {
            System.out.println("权限不符");
            try {
                response.sendRedirect("http://localhost:9001/common/Permission.html");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("权限符合");
        }

        System.out.println(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }

    private int getAuthorizationNumber(HttpServletRequest request) {

        String url = request.getRequestURL().toString();
        String[] split = url.split("/");
        String rankUrl = split.length > 2 ? split[split.length-2] : null;
        System.out.println(rankUrl);
        int rank = -1;
        switch (rankUrl) {
            case "boss" :
                rank = 1;
                break;
            case "leader" :
                rank = 2;
                break;
            case "employee" :
                rank = 3;
                break;
            case "admin" :
                rank = 0;
                break;
            case "common" :
                rank = Integer.MAX_VALUE;
                break;
        }

        return rank;
    }

}
