package finding.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class findElementByXpath {
    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");


    }

    @Test (enabled = false)
    public void findByXpath() {
   WebElement usernameTXT = driver.findElementByXPath("//*[@id=\"username\"]");
   WebElement passwordTXT = driver.findElementByXPath("//*[@id=\"password\"]");
   WebElement buttonBTN = driver.findElementByXPath("//*[@id=\"login\"]/button");
        System.out.println(usernameTXT.getTagName());
        System.out.println(passwordTXT.getTagName());
        System.out.println(buttonBTN.getText());
    }
    @Test
    public void findByXpathRelative() {
       // WebElement usernameTXT = driver.findElementByXPath("//input");
        WebElement passwordTXT = driver.findElementByXPath("//input[1]");
        //WebElement buttonBTN = driver.findElementByXPath("//button");
        //System.out.println(usernameTXT.getTagName());
        System.out.println(passwordTXT.getTagName());
        //System.out.println(buttonBTN.getText());
    }


    @AfterTest
    public void exits()
    {
        driver.quit();
    }
}
