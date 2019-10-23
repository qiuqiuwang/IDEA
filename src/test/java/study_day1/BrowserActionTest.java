package study_day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActionTest {

    WebDriver webDriver;

    @BeforeMethod
    public void openBrower(){    //打开浏览器
        //设置浏览器驱动
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }



//    打开Chrome浏览器
//    打开百度首页
//    等待5S
//    关闭浏览器

    @Test
    public void actionTest() throws InterruptedException {
        webDriver.get("http://192.168.1.176:3800/#/login");   //打开界面
        //webDriver.navigate().to("http://192.168.1.176:3800/#/login");
        Thread.sleep(5000);
    }

    @Test
    public void actionBack() throws InterruptedException {
        webDriver.get("http://192.168.1.176:3800/#/login");   //打开界面
        Thread.sleep(3000);
        webDriver.navigate().back();       //浏览器后退操作
        Thread.sleep(3000);
    }


    @Test
    public void actionforward() throws InterruptedException {
        webDriver.get("http://192.168.1.176:3800/#/login");   //打开界面
        Thread.sleep(3000);
        webDriver.navigate().back();       //浏览器后退操作
        Thread.sleep(3000);
        webDriver.navigate().forward();     //浏览器前进
        Thread.sleep(3000);
    }

    @Test
    public void refreshTest() throws InterruptedException {
        webDriver.get("https://www.google.cn/");   //打开界面（一定会等界面加载完成）
        Thread.sleep(3000);
        webDriver.navigate().refresh();    //刷新浏览器
        Thread.sleep(3000);
    }


    @Test
    public void openMax() throws InterruptedException {
        webDriver.get("http://192.168.1.176:3800/#/login");
        webDriver.manage().window().maximize();    //设置浏览器窗口最大化
        Thread.sleep(3000);
        Dimension dimension = new Dimension(900,800);   //设置窗口大小
        webDriver.manage().window().setSize(dimension);
        Thread.sleep(3000);
    }

    @Test
    public void getURLtest() throws InterruptedException {
        webDriver.get("http://192.168.1.176:3800/#/login");
        String getURL = webDriver.getCurrentUrl();   //获得当前浏览网页地址
        System.out.println("获取当前地址是："+getURL);
        Assert.assertEquals(getURL,"http://192.168.1.176:3800/#/login");   //判断获取地址是否正确
        Thread.sleep(3000);
   //     webDriver.quit();
    }


    @AfterMethod
    public void close(){
        webDriver.quit();
    }
}
