package lesson3.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        //ubeditsa, chto Sign Out button ne otobragaetsa
        if (app.getHeader().isSignOutButtonPresent()) {//esli nrt knopki Sign Out
            //Login (vojti)
            app.getHeader().clickOnLoginLink();
            app.getUser().login();
            // nagat' na link Add
            app.getHeader().clickOnAddLink();
        }
    }

    @Test
    public void addContactPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);//randomnoje chislo
        //Zapolnyaem formu(fill contact form)
        app.getContact().addRandomContact(i, "Lena", "Ivanova", "+1234568", "lena@gmail.com", "Berlin", "nachbarn");
        //clickWithAction(By.cssSelector(".add_form__2rsm2 button")); sdvigaet ekran esli on ne pomeschatsa v okne
        //assert contact is created
        Assert.assertTrue(app.getContact().isContactCreated("Lena" + i)); //проверять бкдет мктод  private boolean isContactCreated(String text)

    }


}
