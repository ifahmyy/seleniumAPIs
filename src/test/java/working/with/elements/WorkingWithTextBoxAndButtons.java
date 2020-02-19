package working.with.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class WorkingWithTextBoxAndButtons {

    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");


    }

    @Test

    public void loginScreen() {

        WebElement usernameTxt = driver.findElement(By.id("username"));
        WebElement passwordTxt = driver.findElement(By.id("password"));
        WebElement buttonBTN = driver.findElementByClassName("radius");
        //using CssSelector for button
        // WebElement buttonBTN = driver.findElementByCssSelector("button.radius");


        usernameTxt.clear();
        usernameTxt.sendKeys("tomsmith");
        passwordTxt.clear();
        passwordTxt.sendKeys("SuperSecretPassword!");
        buttonBTN.click();
//        String actualUrl = "https://the-internet.herokuapp.com/secure";
//        String expectedUrl = driver.getCurrentUrl();
//
//        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
//            System.out.println("Test passed");
//
//        } else {
//            System.out.println("Test failed");
//
//        }
        WebElement successNotfi = driver.findElement(By.id("flash"));
        //System.out.println(successNotfi.getText());
        Assert.assertTrue(successNotfi.getText().contains("You logged into a secure area!"));
    }

    @AfterTest(enabled = false)
    public void exits() {
        driver.quit();
    }
}
