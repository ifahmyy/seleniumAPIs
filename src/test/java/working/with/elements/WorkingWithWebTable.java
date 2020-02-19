package working.with.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WorkingWithWebTable {
    ChromeDriver driver;

    @BeforeTest
    public void openURL() {


        String chromePath = System.getProperty("user.dir") + "//resources//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/tables");


    }

    @Test

    public void testWithTable() {
        WebElement webTable = driver.findElement(By.id("table1"));
        //get all rows
        List<WebElement> rows = webTable.findElements(By.tagName("tr"));
        Assert.assertEquals(rows, rows.size());
        for (WebElement row : rows)
        {
           List<WebElement> cols = row.findElements(By.tagName("td"));
//            for (WebElement col: cols) {
//                System.out.println(col.getText());
//            }
        }

    }
}
