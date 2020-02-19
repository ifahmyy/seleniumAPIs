package finding.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByCssSelectors {

    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");


    }
    @Test
    public void findByCssSelector()
    {

        WebElement headerLG = driver.findElement(By.cssSelector("h2"));
        WebElement usernameTXT = driver.findElement(By.cssSelector("input#username"));
        WebElement passwordTXT = driver.findElement(By.cssSelector("input#password"));
        WebElement loginBTN = driver.findElement(By.cssSelector("button.radius"));
        System.out.println(loginBTN.getText());
        System.out.println(usernameTXT.getTagName());
        System.out.println(passwordTXT.getTagName());
        System.out.println(headerLG.getText());
    }
    @AfterTest
    public void closeDriver() {
      driver.quit();

    }

}
