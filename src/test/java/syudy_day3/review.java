package syudy_day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class review {
    @DataProvider(name ="open")
    public Object[][] URL(){
        return new Object[][]{
                {"webdriver.gecko.driver","D:\\Selenium\\drivers\\geckodriver.exe"},
                {"webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe"}
        };
    }
    @Test(dataProvider = "open")
    public void openBrowser(String driver,String path) throws InterruptedException {
        System.setProperty(driver,path);
        WebDriver webDriver;
        if(driver.equals("webdriver.gecko.driver")){
            webDriver = new FirefoxDriver();
            webDriver.get("http://www/baidu.com");
            Thread.sleep(2000);
            webDriver.quit();
        }
        else{
            webDriver = new ChromeDriver();
            webDriver.get("http://www/baidu.com");
            Thread.sleep(2000);
            webDriver.quit();
        }



    }
}
