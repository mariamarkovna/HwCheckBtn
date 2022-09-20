package lesson3.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static lesson3.phonebook.CreateAccountTests.*;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        //ubeditsa, chto Sign Out button ne otobragaetsa
        if (isSignOutButtonPresent()) {//esli nrt knopki Sign Out
            //Login (vojti)
            clickOnLoginLink();
            type(By.cssSelector(PLACEHOLDER_EMAIL), KARL_3_GMAIL_CO);
            type(By.cssSelector(PLACEHOLDER_PASSWORD), AA_12345);
            click(By.xpath(BUTTON_CONTAINS_LOGIN));
            // nagat' na link Add
            clickOnAddLink();
        }
    }

    @Test
    public void addContactPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);//randomnoje chislo
        //Zapolnyaem formu(fill contact form)
        type(By.cssSelector("input:nth-child(1)"), "Lena" + i);//unikalnoe imja
        type(By.cssSelector("input:nth-child(2)"), "Ivanova");
        type(By.cssSelector("input:nth-child(3)"), "+1234568" + i);//unikalny telefon
        type(By.cssSelector("input:nth-child(4)"), "lena" + i + "@gmail.com");//unikalny email
        type(By.cssSelector("input:nth-child(5)"), "Berlin");
        type(By.cssSelector("input:nth-child(6)"), "nachbarn");
        //click on the button SAVE
        click(By.cssSelector(".add_form__2rsm2 button"));
        //clickWithAction(By.cssSelector(".add_form__2rsm2 button")); sdvigaet ekran esli on ne pomeschatsa v okne
        //assert contact is created
        Assert.assertTrue(isContactCreated("Lena" + i)); //проверять бкдет мктод  private boolean isContactCreated(String text)

    }

    private boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.xpath("//h2"));
        for (WebElement element1 : contacts) {
            if (element1.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }





}
