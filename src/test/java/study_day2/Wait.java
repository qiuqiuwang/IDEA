package study_day2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Wait {
    WebDriver webDriver;

    //登录进入功能界面
    //输入完成账号密码，点击登录
    @BeforeTest
    public void openChorme() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    //全局等待
        webDriver.get("http://192.168.1.176:3800/#/login");
        webDriver.manage().window().maximize();
        webDriver.findElement(By.name("usr")).sendKeys("qiuqiu");    //输入用户名     //通过name找到菜单
        webDriver.findElement(By.name("password")).sendKeys("hTool299");    //输入密码



//        String link = webDriver.getCurrentUrl();
//        System.out.println(link);
    }

    //获取界面元素
    @Test
    public void loginwait() throws InterruptedException {

        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/div[1]/div[2]/ui-view/div[1]/form/div[5]/button")).click();   //登录

        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='商户管理']")));
        String Element = webDriver.findElement(By.xpath("//*[text()='商户管理']")).getText();    //通过linktext找到菜单
        Assert.assertEquals(Element,"商户管理");
    }

    @AfterTest
    public void closechrome(){
        webDriver.quit();
    }
}
