package lesson3.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static lesson3.phonebook.CreateAccountTests.*;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {//esli net knopki "LOGIN"
            driver.findElement(By.xpath("//a[contains(.,'Sing Out')]")).click();//gmi na "Sing Out"
        }else {
            driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();//Inache gmi "LOGIN"
        }
    }

    @Test
    public void LoginPositiveTest() {
        //zapolnim Login form
        Assert.assertTrue(isElementPresent1(By.cssSelector(LOGIN_LOGIN_3_EHKB)));
        //zapolnjaem polja LOGIN
        type(By.cssSelector(PLACEHOLDER_EMAIL), KARL_3_GMAIL_CO);
        type(locator(), AA_12345);
        click(By.xpath(BUTTON_CONTAINS_LOGIN));
        //podtvergdaem, chto polzovatel zaloginen
        pause(1000);
        Assert.assertTrue(isElementPresent(By.xpath(BUTTON_CONTAINS_SIGN_OUT)));


    }


}
