package xf.study.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xf.study.admin.bean.User;

/**
 * BaseMapper接口：该接口内定义了一些CRUD方法，继承该接口后，无需编写mapper.xml文件，即可获得CRUD功能。
 * 提示：这个Mapper支持id泛型
 */
//@Mapper
public interface UserMapper extends BaseMapper<User> {

}
