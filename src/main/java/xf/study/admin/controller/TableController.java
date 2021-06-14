package xf.study.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import xf.study.admin.bean.User;
import xf.study.admin.exception.UserToManyException;
import xf.study.admin.service.UserService;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;


    /**
     *
     * @param a 不带请求参数或者参数类型不对，==》报错400：Bad Request ==》一般都是浏览器参数没有传递正确
     * @return
     */
    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){

        int i = 10 / 0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){

        //表格内容的遍历
       /* List<User> users = Arrays.asList(new User("zhangsan", "123"),
                new User("lisi", "111"),
                new User("zz", "zz"),
                new User("aa", "331"),
                new User("xinf", "zzz"));

        model.addAttribute("users",users);

        if (users.size() > 3){
            throw new UserToManyException();
        }*/


       //从数据库中查出user表中的用户进行展示
        //自动查询表中所有记录
       /* List<User> list = userService.list();
        model.addAttribute("users", list);*/

        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);        //第一个是当前页码，第二个是每页显示多少条数据。
        //page:分页查询的结果
        Page<User> page = userService.page(userPage, null);//第一个参数是分页对象，第二个参数是查询条件

        long pages = page.getPages();   //总页数
        long current = page.getCurrent();//当前页码
        List<User> records = page.getRecords();//查询出的所有的数据
        long total = page.getTotal();       //总记录数

        model.addAttribute("page", page);

        return "table/dynamic_table";
    }


    @GetMapping("/user/del/{id}")
    public String delUser(@PathVariable("id") Long id,
                          @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                          RedirectAttributes redirectAttributes){

        userService.removeById(id);

        redirectAttributes.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }



    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }
}
