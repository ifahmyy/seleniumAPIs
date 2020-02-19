package seleniumapis;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TestCookies {
    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://magento-demo.lexiconn.com/");

    }

    @Test
    public void testCookies() {
        WebElement langSelect = driver.findElement(By.id("select-language"));
        Select select = new Select(langSelect);
        //System.out.println();


        Assert.assertEquals("English", select.getFirstSelectedOption().getText());


        //store cookies should be null
        Cookie storeCookie = driver.manage().getCookieNamed("store");
        //select german
        Assert.assertEquals(null, storeCookie);
        select.selectByVisibleText("French");
        //store cookie should be populated selected country
        storeCookie = driver.manage().getCookieNamed("store");

        Assert.assertEquals("french", storeCookie.getValue());
        System.out.println(storeCookie.getValue());
        Set<Cookie> cookies=driver.manage().getCookies();

        Iterator<Cookie> itr = cookies.iterator();
        while (itr.hasNext())
        {
            Cookie cookie = itr.next();
            System.out.println(cookie.getDomain());
            System.out.println(cookie.getName());
            System.out.println(cookie.getExpiry());
            System.out.println(cookie.getPath());
        }
    }

    @AfterTest(enabled = true)
    public void quit() {
        driver.quit();
    }
}
