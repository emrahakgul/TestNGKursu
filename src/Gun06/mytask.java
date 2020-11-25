package Gun06;

import Utils.MetodDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class mytask extends MetodDriver {

    @Test
    @Parameters("searchkey")
    public void myTask(String searchkey)//*[@id="search"]/input
    {
        WebElement searchh=driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
        searchh.sendKeys(searchkey);

        //*[@id="search"]/span/button
        WebElement buttonsearch=driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
        buttonsearch.click();

        List<WebElement> results=driver.findElements(By.cssSelector("h4>a"));

        for (WebElement result:results) {
            System.out.println(result.getText());
            Assert.assertTrue(result.getText().toLowerCase().contains(searchkey));

        }
    }
}
//*[@id="content"]/div[3]