//package tech.jinhaoma;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import tech.jinhaoma.check.AuthorizationInterceptor;
//
///**
// * Created by mjrt on 2/22/2017.
// */
//@Configuration
//public class InterceptorConfiguration extends WebMvcConfigurerAdapter {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 注册拦截器
//        InterceptorRegistration ir = registry.addInterceptor(new AuthorizationInterceptor());
//        // 配置拦截的路径
//        ir.addPathPatterns("/**");
//        // 配置不拦截的路径
//        ir.excludePathPatterns("/login","/404","/index.html");
//    }
//}
