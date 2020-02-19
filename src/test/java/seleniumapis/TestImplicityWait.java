package seleniumapis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestImplicityWait {
    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");

    }
    @Test
    public void implicityWait()
    {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement((By.linkText("page 4"))).click();


        WebElement message = driver.findElement(By.linkText("page 4"));
        Assert.assertTrue(message.getText().contains("Nunc nibh tortor"));
    }
}
