package working.with.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithDropDown {
    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");


    }

    @Test
    public void dropdownList() {
        WebElement optionList = driver.findElement(By.id("dropdown"));
        Select select = new Select(optionList);
        Assert.assertFalse(select.isMultiple());
        Assert.assertEquals(3, select.getOptions().size());
        //Assert.assertEquals("Option 1", select.getFirstSelectedOption().getText());
       select.selectByVisibleText("Option 2");
    }
}
