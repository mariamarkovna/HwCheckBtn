package lesson3.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;


public class HomePageTests extends TestBase {


    @Test
    public void openHomePage() {

        System.out.println("Home Companent: "+ isHomeComponentPresent1());
        isHomeComponentPresent();

    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));//metod s javnym locatorom
    }


    public boolean isHomeComponentPresent1() {
        try {
            isElementPresent1(By.xpath("//div[@id='root']/div[2]/div/div"));//metod s javnym locatorom
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }


}
