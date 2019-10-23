package study_day2;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EX176 {
    WebDriver webDriver;

    //登录进入功能界面
    @BeforeTest
    public void openChorme() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://192.168.1.176:3800/#/login");
        webDriver.manage().window().maximize();
        Thread.sleep(1000);
        webDriver.findElement(By.name("usr")).sendKeys("qiuqiu");    //输入用户名     //通过name找到菜单
        webDriver.findElement(By.name("password")).sendKeys("Aa000000");    //输入密码
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/div[1]/div[2]/ui-view/div[1]/form/div[5]/button")).click();   //登录
        Thread.sleep(2000);
//        String link = webDriver.getCurrentUrl();
//        System.out.println(link);
    }

    //点击商户管理菜单，打开商户分账管理页面
    @BeforeMethod
    public void openmenu() throws InterruptedException {
        webDriver.findElement(By.xpath("//*[text()='商户管理']")).click();    //通过linktext找到菜单
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("商户分账管理")).click();    //通过linktext找到菜单
        Thread.sleep(2000);
    }

    //点击添加分账人，输入信息添加分账人信息
    @Test
    public void addAccountholder() throws InterruptedException {
        int flag=1;
        webDriver.findElement(By.xpath("//*[text()='+ 添加入账人']")).click();   //点击添加分账人
        Thread.sleep(2000);                     //输入商户号
        webDriver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-scope ng-empty ng-invalid ng-invalid-required ng-valid-pattern ng-valid-maxlength']")).sendKeys("013361641120010");
        Thread.sleep(1000);                     //点击入账类型
        webDriver.findElement(By.xpath("//*[@id=\"ins\"]/div[1]/span")).click();
        Thread.sleep(1000);
        //入账类型选择
        switch (flag){
            case 1 :
                webDriver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-1-0\"]/span")).click();
                Thread.sleep(1000);
                webDriver.findElement(By.xpath("//*[@placeholder=\"微信二级商户号或个人微信号\"]")).sendKeys("1480416612");
                Thread.sleep(1000);
                webDriver.findElement(By.xpath("//*[@placeholder=\"商户名称或个人真实姓名\"]")).sendKeys("上海才汇信息技术有限公司");
                Thread.sleep(1000);
                break;
            case 2:
                webDriver.findElement(By.xpath("//*[@id=\"ui-select-choices-row-1-1\"]/span")).click();
                Thread.sleep(1000);
                webDriver.findElement(By.xpath("//*[@placeholder=\"微信二级商户号或个人微信号\"]")).sendKeys("aini13296300381");
                Thread.sleep(1000);
                webDriver.findElement(By.xpath("//*[@placeholder=\"商户名称或个人真实姓名\"]")).sendKeys("王倩倩");
                Thread.sleep(1000);
        }
        webDriver.findElement(By.xpath("//*[@id=\"relation\"]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[text()='分销商']")).click();   //点击分销商
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//div/div/div/div[3]/button[1]")).click();     //提交按钮
        Thread.sleep(2000);
//        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(file,new File("D:\\我的文件\\测试应备技能\\软件测试\\截图\\result.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    //输入商户号，删除分账人信息
    @Test
    public  void deleteAccountholder() throws InterruptedException {
        webDriver.findElement(By.xpath("//*[@placeholder=\"请输入商户号或者商户名称\"]")).sendKeys("013361641120010");   //输入搜索商户号
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@type=\"submit\"]")).click();     //点击查询
        Thread.sleep(5000);
        List<WebElement> elements = webDriver.findElements(By.xpath("//*/table/tbody/tr"));  //获取查询结果有几行
        String account;
        int key = 0;
        for(int i=1; i<=elements.size(); i++){
            account = webDriver.findElement(By.xpath("//*/table/tbody/tr["+i+"]/td[3]")).getText();
            //System.out.println("分账账号"+account);
            if(account.equals("aini13296300381")){                  //判断是否和预期值一样
                webDriver.findElement(By.xpath("//*/table/tbody/tr["+i+"]/td[7]/p/button")).click();
                Thread.sleep(1000);
                //webDriver.findElement(By.xpath("//*/button[1]"));     //确认删除
                webDriver.findElement(By.xpath("//*/button[2]"));     //取消不删除
                Thread.sleep(1000);
                key=1;
            }
        }
        if(key ==0){
            System.out.println("未找到匹配的值");
        }

    }

    @AfterMethod
    public void screenshot(){    //截取执行结果
        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\我的文件\\测试应备技能\\软件测试\\截图\\result.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void closechrome(){
        webDriver.quit();
    }
}
