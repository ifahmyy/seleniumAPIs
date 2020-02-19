package finding.elements;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.JsonOutput;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBrowserCommands {
    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        //System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();



    }

    @Test
    public void browserCom() {

        driver.navigate().to("https://the-internet.herokuapp.com/login");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());
    }

    @AfterTest(enabled = false)
    public void quit() {
        driver.quit();
    }
}
