package study_day1;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class closeBrowser {
    @Test
    public void openChrome(){  //打开浏览器
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
    }


    @Test
    public void closedChrome() throws InterruptedException {   //关闭浏览器
        //设置driver路径
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        Thread.sleep(5000);  //等待5S
//        webDriver.close();   //关闭当前窗口
        webDriver.quit();  //彻底关闭进程
    }
}
