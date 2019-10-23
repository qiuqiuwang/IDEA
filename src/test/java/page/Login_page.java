package page;

import org.openqa.selenium.By;

public class Login_page {
    public static By username = By.name("usr");
    public static By password = By.name("password");
    public static By loginbut = By.xpath("//*[@id=\"ng-app\"]/body/div[1]/div[2]/ui-view/div[1]/form/div[5]/button");
}
