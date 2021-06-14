package xf.study.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xf.study.admin.bean.User;
import xf.study.admin.mapper.UserMapper;
import xf.study.admin.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
