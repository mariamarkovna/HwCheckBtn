package lesson3.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HwTestAboutBtn extends TestBase {

    @Test

    public void existAboutBtm(){

        //Assert.assertTrue(isElementPresent(By.cssSelector("a.active")));
        WebElement webElement = driver.findElement(By.cssSelector("a.active"));
        webElement.click();

    }

}
