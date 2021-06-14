package xf.study.admin.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web的controller异常
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})   //处理异常
    public String handlerArithException(Exception e){

        log.error("异常是：{}",e);
        return "login";      //视图地址
    }
}
