package study_day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {
    @Test
    public void openFirefox(){//启动火狐浏览器（默认地址）
        //指定driver路径
        System.setProperty("webdriver.gecko.driver","D:\\Selenium\\drivers\\geckodriver.exe");
//        System.setProperty("webdriver.firefox.bin","E:\\instal_program\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();   //浏览器默认安装时这样写
    }

    @Test
    public void openFirefox2(){
        //指定火狐安装路径
        System.setProperty("webdriver.firefox.bin","E:\\instal_program\\firefox.exe");
        //启动火狐
        WebDriver webDriver = new FirefoxDriver();
    }

    @Test
    public void opfenChrome(){//启动谷歌浏览器
        //指定driver路径
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
    }

    @Test
    public void openIE(){   //启动IE浏览器
        System.setProperty("webdriver.ie.driver","D:\\Selenium\\drivers\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();
    }

    @Test
    public void openEdge(){  //启动win10Edge浏览器
        System.setProperty("webdriver.edge.driver","D:\\Selenium\\drivers\\MicrosoftWebDriver.exe");
        WebDriver webDriver = new EdgeDriver();
    }


}
