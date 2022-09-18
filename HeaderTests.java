package lesson3.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HeaderTests extends TestBase {

    public static final String A_NTH_CHILD_2 = "a:nth-child(2)";
    public static final String A_ACTIVE = "a.active";

    @Test
    public void existHomeBtn() throws InterruptedException {

    Assert.assertTrue(isElementPresent1(By.cssSelector(A_NTH_CHILD_2)));
    driver.findElement(By.cssSelector(A_NTH_CHILD_2)).click();
    Thread.sleep(1000);
    Assert.assertTrue(isElementPresent(By.cssSelector(A_NTH_CHILD_2)));

    }

    @Test

    public void existAboutBtm(){

        Assert.assertTrue(isElementPresent(By.cssSelector(A_ACTIVE)));
        WebElement webElement = driver.findElement(By.cssSelector(A_ACTIVE));
        webElement.click();
        Assert.assertTrue(isElementPresent(By.cssSelector(A_ACTIVE)));

    }


    private void execLogin(){
        driver.findElement(By.xpath(CreateAccountTests.A_CONTAINS_LOGIN1)).click();
        driver.findElement(By.cssSelector(CreateAccountTests.PLACEHOLDER_EMAIL)).click();
        driver.findElement(By.cssSelector(CreateAccountTests.PLACEHOLDER_EMAIL)).clear();
        driver.findElement(By.cssSelector(CreateAccountTests.PLACEHOLDER_EMAIL)).sendKeys(CreateAccountTests.KARL_3_GMAIL_CO);
        driver.findElement(By.cssSelector(CreateAccountTests.PLACEHOLDER_PASSWORD)).click();
        driver.findElement(By.cssSelector(CreateAccountTests.PLACEHOLDER_PASSWORD)).clear();
        driver.findElement(By.cssSelector(CreateAccountTests.PLACEHOLDER_PASSWORD)).sendKeys(CreateAccountTests.AA_12345);
        //click on Registration button
        driver.findElement(By.xpath(CreateAccountTests.BUTTON_CONTAINS_LOGIN)).click();

    }

    @Test
//
    public void existHomeBtnLogInUser() throws InterruptedException {
        execLogin();
        Assert.assertTrue(isElementPresent(By.cssSelector("a:nth-child(2)")));
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("a:nth-child(2)")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("a:nth-child(2)")));
        System.out.println("Click is done" + isElementPresent(By.cssSelector("a:nth-child(2)")));
    }

    @Test
    public void existAboutBtnLogInUser() throws InterruptedException {
        execLogin();
        Assert.assertTrue(isElementPresent(By.cssSelector("a:nth-child(3)")));
        TimeUnit.SECONDS.sleep(1);
        WebElement webElement = driver.findElement(By.cssSelector("a:nth-child(3)"));
        webElement.click();
        Assert.assertTrue(isElementPresent(By.cssSelector("a:nth-child(3)")));
        System.out.println("Click is done" + isElementPresent(By.cssSelector("a:nth-child(3)")));
    }
    @Test
    public void existContactsBtnLogInUser() throws InterruptedException {
        execLogin();
        Assert.assertTrue(isElementPresent(By.cssSelector("a:nth-child(4)")));
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("a:nth-child(4)")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("a:nth-child(4)")));
        System.out.println("Click is done" + isElementPresent(By.cssSelector("a:nth-child(4)")));
    }
    @Test
    public void existAddBtnLogInUser() throws InterruptedException {
        execLogin();
        Assert.assertTrue(isElementPresent(By.cssSelector("a:nth-child(5)")));
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("a:nth-child(5)")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("a:nth-child(5)")));
        System.out.println("Click is done" + isElementPresent(By.cssSelector("a:nth-child(5)")));
    }

    @Test
    public void existSingOutBtnLogInUser() throws InterruptedException {
        execLogin();
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(text(),'Sign Out')]")));
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//button[contains(text(),'Sign Out')]")).click();
        TimeUnit.SECONDS.sleep(1);
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(text(),'Sign Out')]")));
        System.out.println("Click is done" + isElementPresent(By.xpath("//button[contains(text(),'Sign Out')]")));
    }

// last line comment
}
