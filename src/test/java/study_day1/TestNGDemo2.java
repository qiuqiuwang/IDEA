package study_day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo2 {

    @Test
    public void AssertEqualtest(){   //校验字段相等
        String a = "asjdsdj";
        String b = "asjdsdj";
        System.out.println("登录");
        Assert.assertEquals(a,b,"校验登录成功");
        System.out.println("操作打开页面删除");
//        这么多不要写在一个方法里面
        String c="12333";
        Assert.assertEquals(a,c,"用户名是否成功");
        System.out.println("操作打开页面删除");
        Assert.assertEquals(a,b,"删除成功");
    }

    @Test
    public void assertNotequalTest(){   //检验字段不相等
        int a = 1;
        int b = 1;
        Assert.assertNotEquals(a,b);
    }

    @Test
    public void assertNulltest(){//校验为空
        String  a = "";
        String b = null ;
        Assert.assertNull(b);
    }

    @Test
    public void assertNotNulltest(){//校验不为空
        String  a = "";
        String b = null ;
        Assert.assertNotNull(a);
    }

}
