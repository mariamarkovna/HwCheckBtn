package lesson3.phonebook.tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static lesson3.phonebook.tests.CreateAccountTests.*;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isLoginLinkPresent()) {//esli net knopki "LOGIN"
            app.getHeader().clickOnSignOutButton();//gmi na "Sing Out"
        }else {
            app.getHeader().clickOnLoginLink();//Inache gmi "LOGIN"
        }
    }


    @Test
    public void LoginPositiveTest() {
        //zapolnim Login form
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //zapolnjaem polja LOGIN
        app.getUser().fillLoginRegistrationForm(new User().setEmail(KARL_3_GMAIL_CO).setPassword(AA_12345));
        //podtvergdaem, chto polzovatel zaloginen
        app.getUser().pause(1000);
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());


    }


}
