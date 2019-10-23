package Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.Login_page;

public class Action_function {

    public static void login(WebDriver webDriver,String username ,String password){
        webDriver.findElement(Login_page.username).sendKeys(username);
        webDriver.findElement(Login_page.password).sendKeys(password);
        webDriver.findElement(Login_page.loginbut).click();
    }
}
