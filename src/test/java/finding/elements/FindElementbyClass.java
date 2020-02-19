package finding.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementbyClass {
    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");


    }

    @Test
    public void findElementName() {
        try {

            WebElement usernameTxt = driver.findElement(By.name("username"));
            WebElement passwordTxt = driver.findElement(By.name("password"));
            WebElement buttonBtn = driver.findElement(By.className("radius"));

            System.out.println("the type of username input is: " + usernameTxt.getTagName());
            System.out.println("the type of password input is: " + passwordTxt.getTagName());
            System.out.println("the type of button input is: " + buttonBtn.getTagName());
            System.out.println("the type of button input is: " + buttonBtn.getText());

        } catch (NoSuchElementException e) {

            System.out.println("element not found please use another attibute");
        }


    }

    @AfterTest
    public void closeDriver() {
        driver.quit();

    }
}
