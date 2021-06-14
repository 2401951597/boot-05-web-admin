package xf.study.admin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@DisplayName("Junit5功能测试类")
@SpringBootTest         //整合了Springboot的功能
public class Junit5Test {


    @DisplayName("测试Dsiplayname注解")
    @Test
    void testDisplayName(){
        System.out.println("111");
    }


    @Disabled       //该测试方法被禁用
    @Test
    void test2(){
        System.out.println("222");
    }


    /**
     * 规定方法的超时时间，超出时间测试出异常。
     * @throws InterruptedException
     */
    @Test
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }

    @RepeatedTest(5)        //重复测试...次
    @Test
    void test3(){
        System.out.println(5);
    }




    /**
     * 这不是一个测试方法，它只是在每个测试方法运行之前都要先运行它
     */
    @BeforeEach
    void testBeforEach(){
        System.out.println("测试就要开始了！");
    }

    /**
     * 这不是一个测试方法，它只是在每个测试方法运行之后都要先运行它
     */
    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了了！");
    }


    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试就要开始了...");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试结束了了...");
    }
}
