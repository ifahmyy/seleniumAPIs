package finding.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByLinkText {
    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");


    }
    @Test
    public void testLinkText()
    {
        WebElement seleniumTXT = driver.findElementByLinkText("Elemental Selenium");
        System.out.println(seleniumTXT.getAttribute("href"));
    }
      @AfterTest
    public void closeDriver()
      {
          driver.quit();
      }
}
