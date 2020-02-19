package working.with.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithSubmit {
    ChromeDriver driver;
    WebElement googleSearch;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.ca");


    }

    @Test
    public void submit() {
        googleSearch = driver.findElementByXPath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input");
        googleSearch.clear();
        googleSearch.sendKeys("selenium Webdriver");
        googleSearch.submit();
        googleSearch = driver.findElementByName("q");
        googleSearch.clear();
        googleSearch.sendKeys("selenium Webdriver books");
        googleSearch.submit();

    }

    @AfterTest(enabled = false)
    public void quit() {
        driver.quit();
    }
}
