package lesson3.phonebook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    public static final String A_CONTAINS_LOGIN = "//a[contains(.,'LOGIN')]";
    public static final String BUTTON_CONTAINS_SIGN_OUT = "//button[contains(.,'Sign Out')]";
    public static final String A_CONTAINS_LOGIN1 = "//a[contains(.,'LOGIN')]";
    public static final String LOGIN_LOGIN_3_EHKB = ".login_login__3EHKB";
    public static final String PLACEHOLDER_EMAIL = "[placeholder='Email']";
    public static final String PLACEHOLDER_PASSWORD = "[placeholder='Password']";
    public static final String BUTTON_CONTAINS_LOGIN = "//button[contains(.,'Login')]";
    public static final String BUTTON_CONTAINS_REGISTRATION = "//button[contains(.,'Registration')]";
    public static final String DIV_CONTAINS_REGISTRATION_FAILED_WITH_CODE_400 = "//div[contains(.,'Registration failed with code 400')]";
    public static final String KARL_3_GMAIL_CO = "karl12321@gmail.com";
    public static final String AA_12345 = "Aa12345~";
    public static final int TIME_OUT_IN_SECONDS = 20;

    @BeforeMethod
    public void ensurePreconditions() {
        //precondition: user should be logged out
        if (!isElementPresent(By.xpath(A_CONTAINS_LOGIN))){
            click(By.xpath(BUTTON_CONTAINS_SIGN_OUT));
        } else {
            //click on LOGIN link
            click(By.xpath(A_CONTAINS_LOGIN1));
        }
    }

    //test
    @Test
    public void createAccountPositiveTest(){
        int i = (int) ((System.currentTimeMillis()/1000) % 3600);
        //assert is registration form displayed
        Assert.assertTrue(isElementPresent1(By.cssSelector(LOGIN_LOGIN_3_EHKB)));
        //fill registration form
        fillLoginRegistrationForm("email"+ i +"@gmail.com", "Aa12345~");
        //String newuser = "a" + System.currentTimeMillis() +"@gmail.co";
        //click on Registration button
        click(By.xpath(BUTTON_CONTAINS_REGISTRATION));
        //verify Sign Out button displayed
        pause(1000);
        Assert.assertTrue(isElementPresent(By.xpath(BUTTON_CONTAINS_SIGN_OUT)));
    }



    @Test
    public void createAccountNegativeTest() {
        //assert is registration form displayed
        Assert.assertTrue(isElementPresent1(By.cssSelector(LOGIN_LOGIN_3_EHKB)));
        //fill registration form
        fillLoginRegistrationForm(KARL_3_GMAIL_CO, AA_12345);
        //click on Registration button
        click(By.xpath(BUTTON_CONTAINS_REGISTRATION));
        //verify Sign Out button displayed -otobragaetsa
        Assert.assertTrue(isAlertPresent());
        Assert.assertFalse(isElementPresent(By.xpath(DIV_CONTAINS_REGISTRATION_FAILED_WITH_CODE_400)));
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, TIME_OUT_IN_SECONDS).until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }

}