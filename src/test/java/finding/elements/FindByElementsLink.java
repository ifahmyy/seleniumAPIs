package finding.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.ArrayList;
import java.util.List;

public class FindByElementsLink {
    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");


    }

    @Test
    public void findListElements() {        //get all the links displayed on page

        try {
            List<WebElement> links = driver.findElements(By.tagName("a"));
            // System.out.println(links.size());
           // Assert.assertEquals(45, links.size());
            for (WebElement link : links
            ) {
                System.out.println(link.getAttribute("href"));
              }
        } catch (AssertionError e) {
            System.out.println("not equal failed");
        }
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
