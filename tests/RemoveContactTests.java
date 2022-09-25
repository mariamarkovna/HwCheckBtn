package lesson3.phonebook.tests;

import model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        //ubeditsa, chto Sign Out button ne otobragaetsa
        if (!app.getHeader().isSignOutButtonPresent()) {//esli nrt knopki Sign Out
            app.getHeader().clickOnLoginLink();
            app.getUser().login();
            app.getHeader().clickOnAddLink();
            //addContact("Lena", "Ivanova", , "Lena", "Ivanova", "+1234568", "lena@gmail.com", "Berlin");
            app.getContact().addContact(new Contact()
                    .setName("Lena")
                    .setSurName("Ivanova")
                    .setPhone("+12345678")
                    .setEmail("lena@gmail.com")
                    .setAddress("Berlin")
                    .setDescription("nachbarn"));
            //clickWithAction(By.cssSelector(".add_form__2rsm2 button")); sdvigaet ekran esli on ne pomeschatsa v okne
        }
    }

    @Test
    public void removeContactPositiveTest() {
        // check size of contact list
        int sizeBefor = app.getContact().sizeOfContacts();
        app.getContact().removeContact();
        //check size of contact list
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        //compare list before-list after
        Assert.assertEquals (sizeAfter+1, sizeBefor);//sizeAfter == sizeBefor
    }

}
