package xf.study.admin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();
        return  new ServletRegistrationBean(myServlet,"/my","/my02");   //后面的是servlet的路径
    }


    @Bean
    public FilterRegistrationBean myFileter(){
        MyFilter myFilter = new MyFilter();

        //设置拦截路径的方法：
        //方法1.拦截myServlet的路径
//        return new FilterRegistrationBean(myFilter,myServlet());        //拦截myServlet的路径

        //方法2.调用方法设置拦截的路径
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener myListener = new MyServletContextListener();
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(myListener);
        return servletListenerRegistrationBean;
    }
}
