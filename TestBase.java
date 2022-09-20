package lesson3.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static lesson3.phonebook.CreateAccountTests.*;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://contacts-app.tobbymarshall815.vercel.app/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;// universalny metod, kot. vozvraschaen
        // luboy element
    }

    public boolean isElementPresent1(By by) {// universalny metod, kot. vozvraschaen
        // true or false depending on element presence by handling exception from the driver function
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }


    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickWithAction(By locator){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();//idet k nugnomy elementu
        element.click();
    }

    @AfterMethod(enabled = false)
    public void tearDawn() {
        driver.quit();
    }

    public void addContact() {
        type(By.cssSelector("input:nth-child(1)"),"Lena");//unikalnoe imja
        type(By.cssSelector("input:nth-child(2)"),"Ivanova");
        type(By.cssSelector("input:nth-child(3)"),"+1234568");//unikalny telefon
        type(By.cssSelector("input:nth-child(4)"),"lena@gmail.com");//unikalny email
        type(By.cssSelector("input:nth-child(5)"),"Berlin");
        type(By.cssSelector("input:nth-child(6)"),"nachbarn");
        //click on the button SAVE
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void clickOnAddLink() {
        click(By.cssSelector("a:nth-child(5)"));
    }

    public void login() {
        fillLoginRegistrationForm(KARL_3_GMAIL_CO, AA_12345);
        click(By.xpath(BUTTON_CONTAINS_LOGIN));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.cssSelector(PLACEHOLDER_EMAIL), email);
        type(By.cssSelector(PLACEHOLDER_PASSWORD), password);
    }

    By locator() {
        return By.cssSelector(PLACEHOLDER_PASSWORD);
    }

    public void clickOnLoginLink() {
        click(By.xpath(A_CONTAINS_LOGIN));
    }

    public boolean isSignOutButtonPresent() {
        return !isElementPresent(By.xpath(BUTTON_CONTAINS_SIGN_OUT));
    }

    public void removeContact() {
        if (!isContactListEmpty()) {
            //click on the contact cart
            click(By.cssSelector(".contact-item_card__2SOIM"));
            //click on the Remove button
            click(By.xpath("//button[text()='Remove']"));
        }
    }

    public int sizeOfContacts() {
        if (driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() > 0){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        } else {
            return 0;
        }
    }

    public boolean isContactListEmpty() {
        return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }
}
