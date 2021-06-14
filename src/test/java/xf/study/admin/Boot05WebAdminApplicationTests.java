package xf.study.admin;

import com.alibaba.druid.support.http.StatViewServlet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import xf.study.admin.bean.User;
import xf.study.admin.mapper.UserMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    /**
     * required = true
     * 这个表示：注入bean的时候该bean必须存在，不然就会注入失败！
     *
     * required = false
     * 这个表示：注入bean的时候如果bean存在，就注入成功，如果没有就忽略跳过，启动不会报错！但是不能直接使用
     */
    @Autowired(required = false)
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Test
    void contextLoads() {

        Long count = jdbcTemplate.queryForObject("select count(*) from boot", Long.class);
        log.info("总条数:{}",count);
        System.out.println(count);

        log.info("数据源类型：{}",dataSource.getClass());

    }


    @Test
    void TestUserMapper(){

        User user = userMapper.selectById(1);
        System.out.println(user.toString());
    }


    @Test
    void testRedis(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello","world");

        String hello = operations.get("hello");
        System.out.println(hello);

        Class<? extends RedisConnectionFactory> connectionFactoryClass = redisConnectionFactory.getClass();
        System.out.println(connectionFactoryClass);
    }









}
