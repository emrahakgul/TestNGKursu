package Gun08;

import Utils.MetodDriver;
import Utils.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class myTask_dataprovider extends MetodDriver {


    @Test(dataProvider = "getData")
    public void searchfunctionality(String searchText) {

    WebElement searchInput=driver.findElement(By.cssSelector("input[name='search']"));
        searchInput.clear();
        searchInput.sendKeys(searchText);

    WebElement searchButton=driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();

    List<WebElement> itemNameList = driver.findElements(By.cssSelector("h4>a"));

        for(WebElement itemName : itemNameList)
    {
        System.out.println(itemName.getText());
        Assert.assertTrue(itemName.getText().toLowerCase().contains(searchText));
    }
    }

    @DataProvider
    public Iterator<Object> getData() {
        List<Object> data = new ArrayList<>();
        data.add("mac");
        data.add("samsung");
        data.add("canon");



        return data.iterator();
    }
}