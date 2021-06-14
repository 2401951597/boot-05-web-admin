package xf.study.admin.interceptor;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录检查（拦截器）
 * 1、配置好拦截器要拦截哪些请求
 * 2、把这些配置放在容器中
 *
 *
 * 拦截器执行流程：
 *  1、先执行preHandle方法实行拦截 ==》2、执行目标方法 ==》3、执行postHandle  ==》4、最后执行afterCompletion
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    /**
     * 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("拦截的请求路径是："+requestURI);

        //检查登录
        HttpSession session = request.getSession();

        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null){
            //放行
            return true;
        }
        //拦截住了。 即未登录，跳转到登录页面去。
//        session.setAttribute("msg","请先登录！");
//        response.sendRedirect("/");
        request.setAttribute("msg", "请先登录！");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }


    /**
     * 目标方法完成以后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    /**
     * 页面渲染以后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
