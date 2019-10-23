package study_day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionTest {
    WebDriver webDriver;

    @BeforeTest
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    //打开百度界面
    //百度一下按钮右击
    @Test
    public void reghtclick() throws InterruptedException {
        webDriver.get("https://www.baidu.com/");
        WebElement element = webDriver.findElement(By.id("su"));
        Thread.sleep(1000);
        //定义Actions对象
        Actions actions = new Actions(webDriver);
        //右击百度一下，并且perform()执行，不执行是不起作用的
        actions.contextClick(element).perform();
        Thread.sleep(1000);
    }

    //打开百度界面
    //双击百度一下按钮
    @Test
    public void doubleclick() throws InterruptedException {
        webDriver.get("https://www.baidu.com/");
        WebElement element = webDriver.findElement(By.id("su"));
        Thread.sleep(1000);
        //定义Actions对象
        Actions actions = new Actions(webDriver);
        //双击百度一下，并且perform()执行，不执行是不起作用的
        actions.doubleClick(element).perform();
        Thread.sleep(1000);
    }

    /**
     * 打开测试代码
     * 鼠标移动到Actions
     * 展示隐藏Hello World!
     */

    @Test
    public void mousemove() throws InterruptedException {
        webDriver.get("file:///D:/%E6%88%91%E7%9A%84%E6%96%87%E4%BB%B6/%E6%B5%8B%E8%AF%95%E5%BA%94%E5%A4%87%E6%8A%80%E8%83%BD/demo/selenium_html/index.html");//老师的测试代码
        Thread.sleep(2000);
        WebElement element = webDriver.findElement(By.xpath(".//*[@id=\"action\"]/input"));
        //定义Actions对象
        Actions actions = new Actions(webDriver);
        //鼠标移动到元素上
        actions.moveToElement(element).perform();
        Thread.sleep(2000);
//        String ele = webDriver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
//
//        Assert.assertEquals(ele,"Hello World!");
    }

    /**
     * 打开测试代码
     * 定位拖拽元素
     * 拖拽元素到新的位置
     */

    @Test
    public void dragAndDropTest() throws InterruptedException {
        webDriver.get("file:///D:/%E6%88%91%E7%9A%84%E6%96%87%E4%BB%B6/%E6%B5%8B%E8%AF%95%E5%BA%94%E5%A4%87%E6%8A%80%E8%83%BD/demo/selenium_html/dragAndDrop.html");
        Thread.sleep(2000);
        WebElement element = webDriver.findElement(By.id("drag"));
        Actions actions = new Actions(webDriver);
        //元素拖拽
        actions.dragAndDropBy(element,500,500).perform();
        Thread.sleep(2000);

    }

    @AfterTest
    public void closeChrome(){
        webDriver.quit();
    }
}
