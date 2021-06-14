package xf.study.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xf.study.admin.bean.City;
import xf.study.admin.mapper.CityMapper;

@Controller
public class CityController {

    @Autowired
    CityMapper cityMapper;


    @ResponseBody
    @GetMapping("/city")
    public City getCityById(Long id){
        return cityMapper.getCityById(id);
    }


    @ResponseBody
    @PostMapping("/city")
    public City insertCity(City city){

        cityMapper.insertCity(city);
        return  city;
    }
}
