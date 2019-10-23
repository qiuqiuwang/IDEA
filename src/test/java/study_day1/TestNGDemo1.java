package study_day1;

import org.testng.annotations.*;

public class TestNGDemo1 {

    @BeforeTest
    public void beforeCase(){
        System.out.print("这是@BeforeTest的注解");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.print("这是@beforeMethod的注解");
    }

    @AfterTest
    public void afterTestCase(){
        System.out.print("这是@AfterTest的注解");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.print("这是@AfterMethod的注解");
    }
    @Test
    public void testCase2(){
        System.out.print("这是@Test注解,case2");
    }
    @Test
    public void testCase1(){
        System.out.print("这是@Test的注解，case1");
    }





}
