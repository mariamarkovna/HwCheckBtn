package lesson3.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        //ubeditsa, chto Sign Out button ne otobragaetsa
        if (!isSignOutButtonPresent()) {//esli nrt knopki Sign Out
            clickOnLoginLink();
            login();
            clickOnAddLink();
            addContact();
            //clickWithAction(By.cssSelector(".add_form__2rsm2 button")); sdvigaet ekran esli on ne pomeschatsa v okne
        }
    }

    @Test
    public void removeContactPositiveTest() {
        // check size of contact list
        int sizeBefor = sizeOfContacts();
        removeContact();
        //check size of contact list
        pause(1000);
        int sizeAfter = sizeOfContacts();
        //compare list before-list after
        Assert.assertEquals (sizeAfter+1, sizeBefor);//sizeAfter == sizeBefor
    }

}
