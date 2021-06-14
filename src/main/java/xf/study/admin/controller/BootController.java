package xf.study.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xf.study.admin.bean.Boot;
import xf.study.admin.service.BootService;

@Slf4j
@Controller
public class BootController {


    @Autowired
    BootService bootService;

    @ResponseBody
    @GetMapping("/boot")
    public Boot getById(@RequestParam("id") Long id){

        return bootService.getBootById(id);

    }
}
