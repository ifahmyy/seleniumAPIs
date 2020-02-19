package finding.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SpreagoLoginPage {
    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://mosherad.github.io/spreago-react/");


    }

    @Test

    public void loginScreen() {

        WebElement emailUser = driver.findElementByXPath("//*[@id=\"root\"]/div/div/div[1]/div/form/div[4]/div/input");
        //System.out.println(emailUser.getTagName());
        WebElement passwordUser = driver.findElementByXPath("//*[@id=\"outlined-adornment-password\"]");
        //System.out.println(passwordUser.getTagName());
        WebElement buttonLog= driver.findElementByXPath("//*[@id=\"root\"]/div/div/div[1]/div/form/div[7]/div[3]/button");

        emailUser.clear();
        emailUser.sendKeys("mah.fahmyy@gmail.com");
        passwordUser.clear();
        passwordUser.sendKeys("Asd200919");
        buttonLog.click();

        String actualUrl = "https://mosherad.github.io/spreago-react/#/homepage";
        String expectedUrl = driver.getCurrentUrl();

        if (actualUrl.equalsIgnoreCase(expectedUrl)) {
            System.out.println("Test failed");

        } else {
            System.out.println("Test passed");

        }

    }


    @AfterTest (enabled = false)
    public void spreagoQuit() {
        driver.quit();
    }

}
