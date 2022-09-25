package lesson3.phonebook.tests;

import org.testng.annotations.Test;


public class HomePageTests extends TestBase {


    @Test
    public void openHomePage() {

        System.out.println("Home Companent: "+ app.getHomePage().isHomeComponentPresent1());
        app.getHomePage().isHomeComponentPresent();

    }


}
