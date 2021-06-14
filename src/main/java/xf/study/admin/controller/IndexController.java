package xf.study.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;
import xf.study.admin.bean.User;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    /**
     * 跳转到登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }


    /**
     * 登录成功
     * @param
     * @param
     * @return
     */
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if (!StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getPassWord())){
            //登录成功，把登录成功的用户保存起来
            session.setAttribute("loginUser",user);

            //登录成功，重定向到 main.html       ==>>重定向，防止表单重复提交。
            return "redirect:/main.html";
        }else {
            //登录失败，回到登录页面。
            model.addAttribute("msg","账号密码错误！");
            return "login";
        }


    }


    /**
     * 去主页面
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model){

        //判断是否登录。       拦截器/过滤器
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null){
            //登录进来的
            return "main";
        }else {
            //回到登录页面
            model.addAttribute("msg","请先登录！");
            return "login";
        }

    }

}
