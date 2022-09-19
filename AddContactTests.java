package lesson3.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static lesson3.phonebook.CreateAccountTests.*;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        //ubeditsa, chto Sign Out button ne otobragaetsa
        if (!isElementPresent(By.xpath(BUTTON_CONTAINS_SIGN_OUT))) {//esli nrt knopki Sign Out
            //Login (vojti)
            click(By.xpath(A_CONTAINS_LOGIN));
            type(By.cssSelector(PLACEHOLDER_EMAIL), KARL_3_GMAIL_CO);
            type(By.cssSelector(PLACEHOLDER_PASSWORD), AA_12345);
            click(By.xpath(BUTTON_CONTAINS_LOGIN));
            // nagat' na link Add
            click(By.cssSelector("a:nth-child(5)"));
        }
    }
    @Test
    public void addContactPositiveTest(){

        //Zapolnyaem formu(fill contact form)
        type(By.cssSelector("input:nth-child(1)"),"Lena");
        type(By.cssSelector("input:nth-child(2)"),"Ivanova");
        type(By.cssSelector("input:nth-child(3)"),"+1234568");
        type(By.cssSelector("input:nth-child(4)"),"lena@gmail.com");
        type(By.cssSelector("input:nth-child(5)"),"Berlin");
        type(By.cssSelector("input:nth-child(6)"),"nachbarn");
        //click on the button SAVE
        click(By.cssSelector(".add_form__2rsm2 button"));
        //click(By.cssSelector(".add_form__2rsm2 button"));
        //assert contact is created

    }
    public void clickWithAction(By locator){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();//idet k nugnomy elementu
        element.click();
    }


}
