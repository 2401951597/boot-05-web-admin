package xf.study.admin;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 断言：如果是断言的情况下，如果前面的断言失败，则后面的代码就不会执行了。
 */
@DisplayName("这是测试断言的测试类")
public class TestDuanYan {

    int cal(int a, int b){
        int c = a + b;
        return c;
    }

    @Test
    void testcal(){
        int cal = cal(2, 3);
        //assertEquals
        Assertions.assertEquals(6,cal, "业务逻辑计算失败。");     //第一个参数是我们预期的值，第二个参数是真实得出的值。  如果预期的值和真实的值不等，则报错并提示。
                                                                                   //第三个参数是出错的时候的提示信息。
    }

    @Test
    void test(){
        Object o1= new Object();
        Object o2 = new Object();
        //assertSame：判断两个对象是否是同一个对象。
        Assertions.assertSame(o1, o2, "两个对象不一样。");      //第三个参数是出错的时候的提示信息。
    }

    @Test
    void test1(){
        int[] a = {1,3};
        int[] b = {1,2};
        //assertArrayEquals
        Assertions.assertArrayEquals(a, b ,"两个数组不相同");
    }


    @Test
    @DisplayName("组合断言")
    void test2(){

        //所有断言需要成功。
        Assertions.assertAll("test",
                ()->Assertions.assertTrue(true && true, "断言1不成功，结果不为true"),
                ()->Assertions.assertEquals(1,2, "断言2不成功，结果不是1"));
    }


    @Test
    @DisplayName("异常断言")
    void test3(){
        //断言异常要求测试必须要出一个异常，否侧断言成功。
        Assertions.assertThrows(ArithmeticException.class,
                ()->{int i = 10 / 2;},
                "业务逻辑居然正常运行了！");
    }

    @DisplayName("快熟失败")
    @Test
    void test4(){
        if (true){
            Assertions.fail("测试失败。");
        }
    }

}
