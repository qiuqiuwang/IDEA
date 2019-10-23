package study_day2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class select {
    WebDriver webDriver;

    @BeforeTest
    public void openchrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://127.0.0.1:8848/review1/form.html");
        webDriver.manage().window().maximize();
        Thread.sleep(1000);
    }

//    打开页面之后，定位下拉框元素
//    定义select对象
//    然后首先选择花溪区
//    再选择烟台市
//    最后选择威海市
    @Test
    public void selectTest() throws InterruptedException {
        WebElement seelctEle = webDriver.findElement(By.id("select_Province"));   //定位元素
        Select select = new Select(seelctEle);
        select.selectByIndex(3);   //根据索引选择
        Thread.sleep(2000);
        select.selectByValue("Yantai");    //根据value值选择
        Thread.sleep(2000);
        select.selectByVisibleText("威海市");   //根据文本值选择
        Thread.sleep(2000);

    }

    //
    //定位元素打开新窗口
    //再新窗口中点击百度
    @Test
    public void winTest() throws InterruptedException {
        webDriver.findElement(By.linkText("新窗口")).click();
        //获得当前界面的句柄
        String handle = webDriver.getWindowHandle();
        //获取所有界面的句柄，并判断是否和第一个界面句柄相同
        for(String handles : webDriver.getWindowHandles()){
            if(handles.equals(handle))
                continue;
            webDriver.switchTo().window(handles);        //控制权交给新界面
        }
        webDriver.findElement(By.linkText("百度一下")).click();    //在新界面点击“百度一下”
        Thread.sleep(2000);
        webDriver.close();             //关闭新窗口
        Thread.sleep(2000);
        webDriver.switchTo().window(handle);    //界面控制权转交给第一个界面
        webDriver.findElement(By.linkText("百度一下")).click();   //在第一个界面点击“百度一下”
        Thread.sleep(2000);
    }


    @AfterTest
    public void closechrome() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.quit();
    }
}
