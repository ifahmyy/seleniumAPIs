package finding.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementsByID {


    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");


    }

    @Test
    public void findElementID() {
        WebElement usernameTxt = driver.findElement(By.id("username"));
        WebElement passwordTxt = driver.findElement(By.id("password"));

        System.out.println("the type of username input is: "+usernameTxt.getTagName());
        System.out.println("the type of password input is: "+passwordTxt.getTagName());
       // System.out.println(usernameTxt.getLocation());



    }

    @AfterTest
    public void closeDriver() {
        driver.quit();

    }
}
