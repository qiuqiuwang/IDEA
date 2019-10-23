package study_day2;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertTest {

    WebDriver webDriver;

    @BeforeTest
    public void openchrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://127.0.0.1:8848/review1/AlertTest.html");
        webDriver.manage().window().maximize();
        Thread.sleep(1000);
    }

//    点击Alert按钮
//	在alert警告框点击确定按钮

    @Test
    public void Alert() throws InterruptedException {
        webDriver.findElement(By.name("Submit1")).click();
        Thread.sleep(2000);
        Alert alert = webDriver.switchTo().alert();               //将webdriver控制权从WebDriver转成Alert
        String text = alert.getText();
        Assert.assertEquals(text,"演示一");
        alert.accept();                    //alert接受
    }

//    点击Confirm按钮
//	在Confirm警告框点击确定\取消按钮
    //再次点击确定按钮退出弹框

    @Test
    public void firmTest() throws InterruptedException {
        webDriver.findElement(By.name("Submit2")).click();
        Thread.sleep(2000);
        Alert firm = webDriver.switchTo().alert();               //将webdriver控制权从WebDriver转成Alert
        firm.dismiss();                    //alert拒绝
        Thread.sleep(1000);
        firm.accept();
    }


//    点击Prompt按钮
//	  在Prompt 弹窗中，输入“这个是Prompt”
//    点击确定\取消按钮
    //再次点击确定按钮退出弹框
    @Test
    public void promTest() throws InterruptedException {                  //Chrome浏览器在prompt弹框中输入值时候不显示输入值，换做火狐浏览器
        webDriver.findElement(By.name("Submit3")).click();
        Thread.sleep(2000);
        Alert prom = webDriver.switchTo().alert();               //将webdriver控制权从WebDriver转成Alert
        prom.sendKeys("王倩倩");
        Thread.sleep(1000);
        prom.accept();
        Thread.sleep(1000);
        prom.accept();
    }



    @AfterTest
    public void closechrome() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.quit();
    }
}
