package xf.study.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import xf.study.admin.bean.Boot;

@Mapper     //告诉mybatis这是一个mapper接口，让它扫描进去
public interface BootMapper {


    public Boot getBoot(Long id);
}
