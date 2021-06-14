package xf.study.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xf.study.admin.interceptor.LoginInterceptor;

/**
 * 1、编写一个拦截器实现HandlerIntercptor接口
 * 2、将拦截器注册到容器中（实现WebMvcConfigurer接口的addInterceptors方法）
 * 3、指定拦截规则（注意：如果是拦截所有，静态资源也会被拦截。）
 */

/**
 * @EnableWebMvc:全面接管springmvc
 *  1、静态资源、视图解析器......全部失效
 *  2、该注解慎用！！！
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())     //将创建好的Interceptor放进去
                .addPathPatterns("/**")                     //添加拦截的请求...所有请求都被拦截，包括静态资源。
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/sql/**","/city/**");         //添加要放行的请求...
    }


    /**
     * 定义静态资源行为
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //访问/aa/*路径下的所有请求，都去classpath:/static/路径下进行匹配
        registry.addResourceHandler("/aa/**")
                .addResourceLocations("classpath:/static/");
    }
}
