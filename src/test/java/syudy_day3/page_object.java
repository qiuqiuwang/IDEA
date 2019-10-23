package syudy_day3;

import Action.Action_function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import page.Login_page;

public class page_object {
    WebDriver webDriver ;
    @Test
    public void login176() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://192.168.1.176:3800/#/login");
        webDriver.manage().window().maximize();
        Action_function.login(webDriver,"qiuqiu","Aa000000");
        Thread.sleep(2000);
        webDriver.quit();
    }

}



