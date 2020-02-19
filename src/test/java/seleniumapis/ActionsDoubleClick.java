package seleniumapis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionsDoubleClick {
    ChromeDriver driver;
     Actions bulider;
    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");


    }
    @Test
    public void doubleClick() throws InterruptedException {
        WebElement message = driver.findElement(By.id("message"));
        System.out.println(message.getCssValue("background-color"));

        Assert.assertEquals("rgba(0, 0, 255, 1)",message.getCssValue("background-color"));
        //blue rgba(0, 0, 255, 1)
         bulider = new Actions(driver);
        bulider.doubleClick(message).perform();
        System.out.println(message.getCssValue("background-color"));

        Thread.sleep(2000);
    }


}
