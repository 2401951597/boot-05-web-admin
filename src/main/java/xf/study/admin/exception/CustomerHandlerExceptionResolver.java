package xf.study.admin.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 自定义异常解析器
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE)      //设置该解析器为最高优先级的解析器（即遍历的时候先用它）  也可以设置数字，数字越小优先级越高
@Component
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {

        try {
            httpServletResponse.sendError(511,"我喜欢的错误。");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new ModelAndView();
    }
}
