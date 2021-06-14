package xf.study.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xf.study.admin.bean.Boot;
import xf.study.admin.mapper.BootMapper;

@Service
public class BootService {

    @Autowired
    BootMapper bootMapper;

    public Boot getBootById(Long id){

        return bootMapper.getBoot(id);
    }
}
