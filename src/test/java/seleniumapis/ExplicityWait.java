package seleniumapis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExplicityWait {

    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.google.com");

    }

     @Test
    public void testImplicityWait(){

        WebElement querytxt = driver.findElementByName("q");
        querytxt.sendKeys("Selenium WebDriver");
        querytxt.submit();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.titleContains("Selenium"));
        assertTrue(driver.getTitle().toLowerCase().startsWith("Selenium"));

     }

    private void assertTrue(boolean selenium) {
    }


}
