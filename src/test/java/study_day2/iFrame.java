package study_day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class iFrame {
    WebDriver webDriver;

    @BeforeTest
    public void openchrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://127.0.0.1:8848/review1/form.html");
        webDriver.manage().window().maximize();
        Thread.sleep(1000);
    }


//   定位iFrame
//	 driver控制权交给iFrame
//	 操作iFrame里面的元素
//	 driver控制权交回原页面
    @Test
    public void iFrameTest() throws InterruptedException {
        //通过id或者name定位iframe
        webDriver.switchTo().frame("iframe1");         //控制权转交到iframe
//        //通过WebElement定位iframe
//        WebElement element = webDriver.findElement(By.tagName("iframe"));
//        webDriver.switchTo().frame(element);
        webDriver.findElement(By.linkText("baidu")).click();
        Thread.sleep(1000);
        //控制权转交给原来界面
        webDriver.switchTo().defaultContent();
        webDriver.findElement(By.linkText("百度一下")).click();
        Thread.sleep(1000);
    }

    @AfterTest
    public void closechrome() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.quit();
    }
}
