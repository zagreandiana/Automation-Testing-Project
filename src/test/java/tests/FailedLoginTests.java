package tests;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import pages.LandingPage;

import static org.junit.Assert.assertTrue;

public class FailedLoginTests extends AbstractPageDriver{
    LandingPage landingPage = new LandingPage();

    @Test
    @Order(1)
    public void loginWithInvalidNoUserName(){
        navigateToLandingPage();
        landingPage.login("", "asdasdad");
        assertTrue("Email invalid.", landingPage.getTextFromWrongEmail().contains("Acesta este un câmp obligatoriu."));
    }

    @Test
    @Order(2)
    public void loginWithInvalidPass(){
        navigateToLandingPage();
        landingPage.login("zagrean_diana@yahoo.com", "");
        assertTrue("Email invalid.", landingPage.getTextFromWrongPassword().contains("Acesta este un câmp obligatoriu."));
    }

    @Test
    @Order(3)
    public void loginWithNoEmailAndPass(){
        navigateToLandingPage();
        landingPage.login("", "");
        assertTrue("Email invalid.", landingPage.getTextFromWrongEmail().contains("Acesta este un câmp obligatoriu."));
        assertTrue("Pass invalid.", landingPage.getTextFromWrongPassword().contains("Acesta este un câmp obligatoriu."));
    }

    @Test
    @Order(4)
    public void loginWithMisspelledEmailAndGoodPass(){
        navigateToLandingPage();
        landingPage.login("zagrean_diana@ya", "password");
        assertTrue("Email incomplet.", landingPage.getTextFromWrongEmail().contains("Introduceți o adresă email validă (Ex: johndoe@domain.com)."));
    }

    @Test
    @Order(5)
    public void loginWithEmailAndWrongPass() throws InterruptedException {
        navigateToLandingPage();
        landingPage.login("zagrean_diana@yahoo.com", "parolaGresita");
        Thread.sleep(5000);
        assertTrue("", driver.findElement(By.xpath("//div[@class='messages']")).getText().contains("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."));
    }
}
