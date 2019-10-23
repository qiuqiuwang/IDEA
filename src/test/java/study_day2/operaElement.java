package study_day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class operaElement {

    WebDriver webDriver;

    @BeforeTest
    public void openBaidu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    //判断百度一下按钮value是否是“百度一下”
    @Test
    public void getAtt() throws InterruptedException {      //getAttribute()
        webDriver.get("https://www.baidu.com/");   //http://127.0.0.1:8848/review1/form.html
        webDriver.manage().window().maximize();
        Thread.sleep(1000);
        String value = webDriver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(value,"百度一下");
        Thread.sleep(2000);
    }


    //判断百度一下按钮是否存在
    @Test
    public  void isdisplayedTest() throws InterruptedException {                           //isDisplayed()
        webDriver.get("https://www.baidu.com/");   //http://127.0.0.1:8848/review1/form.html
        webDriver.manage().window().maximize();
        Thread.sleep(1000);
        Boolean value = webDriver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(value);
    }

    //判断单选、多选框是否被选中,可以先操作元素选中，然后再判断
    @Test
    public void isSelectedTest() throws InterruptedException {
        webDriver.get("http://127.0.0.1:8848/review1/form.html");   //自己写的项目
        webDriver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement element = webDriver.findElement(By.id("nan"));
        element.click();
        Boolean b = element.isSelected();
        Assert.assertTrue(b);
    }

    //判断按钮是否可用
    @Test
    public void isEnabledTest() throws InterruptedException {
        webDriver.get("http://127.0.0.1:8848/review1/form.html");   //自己写的项目
        webDriver.manage().window().maximize();
        Thread.sleep(1000);
//        Boolean b = webDriver.findElement(By.xpath("//input[@type=\"reset\"]")).isEnabled();
//        Assert.assertFalse(b);
        Boolean b = webDriver.findElement(By.xpath("//input[@type=\"submit\"]")).isEnabled();
        Assert.assertTrue(b);                                     //按钮可用再点击按钮
        webDriver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
    }

    //截图百度首页当前页面
    @Test
    public void  screenshotTest(){
        webDriver.get("https://www.baidu.com/");
        File file =((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\我的文件\\测试应备技能\\软件测试\\截图\\test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @AfterTest
    public void closechrome(){
        webDriver.quit();
    }
}
