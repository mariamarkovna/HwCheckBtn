package lesson3.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HwTestHomeBtn extends TestBase {

    public static final String A_NTH_CHILD_2 = "a:nth-child(2)";

    @Test
    public void existHomeBtn() throws InterruptedException {

    Assert.assertTrue(isElementPresent1(By.cssSelector(A_NTH_CHILD_2)));

  driver.findElement(By.cssSelector(A_NTH_CHILD_2)).click();
        Thread.sleep(1000);
        Assert.assertTrue(isElementPresent(By.cssSelector(A_NTH_CHILD_2)));

    }


}
