package xf.study.admin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestAssumptions {

    @DisplayName("测试前置条件")
    @Test
    void testAssumptions(){
        Assumptions.assumeTrue(false, "结果不是true");  //第一个参数ture/false,第二个参数是错误时的提示信息。
        System.out.println("111");
    }
}
