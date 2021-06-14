package xf.study.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user")          //指定对应的数据库表名，当表名和对象名相同的时候可以不加这个注解mybatisplus会自动去匹配数据库对应的表名
public class User {

    //以下是登录的字段
    //@TableField(exist = false)    表示该属性在表中不存在，只是我们临时的一个字段。
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String passWord;


    //以下是数据库的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
