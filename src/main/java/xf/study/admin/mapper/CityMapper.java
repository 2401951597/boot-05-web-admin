package xf.study.admin.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import xf.study.admin.bean.City;

@Mapper
public interface CityMapper {


    /**
     * 纯注解方式
     * @param id
     * @return
     */
    @Select("select * from city where id=#{id}")
    public City getCityById(Long id);

    @Insert("insert into city(`name`, `state`, `country`) values(#{name}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")          //这个是insert注解的设置项，要设置什么在这里写  这里设置自增的字段是id
    public void insertCity(City city);
}
