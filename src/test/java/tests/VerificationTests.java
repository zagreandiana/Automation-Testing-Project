package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import pages.*;

import static org.junit.Assert.assertTrue;

@Epic("Testarea aplicatiei libhumanitas.")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VerificationTests extends AbstractPageDriver{

    LandingPage landingPage = new LandingPage();
    CatalogSearchResultsPage catalogSearchResultsPage = new CatalogSearchResultsPage();
    ProductPage productPage = new ProductPage();
    CosulMeuPage cosulMeuPage = new CosulMeuPage();


    @Test
    @Story("Incerc sa ma loghez.")
    @Order(1)
    public void loginTest() {
        landingPage.skipCookieBanner();
        landingPage.login("zagrean_diana@yahoo.com", "password");
        landingPage.clickContulMeu();
        assertTrue("Esti logat cu alt user.", landingPage.getUserText().getText().contains("DIANA"));
    }


    @Test
    @Story("Fac un search dupa cuvantul Java")
    @Order(2)
    public void searchTest() {
        catalogSearchResultsPage = landingPage.search("Java");
        assertTrue("Cartea cautatea nu se afla in lista de carti.",
                catalogSearchResultsPage.checkIfTheSearchedBookIsInTheListOfResults("Java"));
    }


    @Test
    @Order(4)
    public void _deleteBookTest(){
        cosulMeuPage.clickButonSterge();
        String cosGolText = cosulMeuPage.getTextFromCos();
        assertTrue("Cartea nu a fost stearsa din cos.", cosGolText.contains("Nu aveți nici un articol în coșul de cumpărături") );
    }


    @Test
    @Order(3)
    public void addBookTest() throws InterruptedException {
        productPage = catalogSearchResultsPage.clickCarte("Java");
        productPage.clickAdaugaInCos();
        Thread.sleep(5000);
        productPage.clickCosulMeu();
        cosulMeuPage = productPage.clickVizualizeazaCosulMeu();
        assertTrue("Cartea nu se afla in cosul de cumparaturi.", cosulMeuPage.textulCartiiPopUp("Java"));
        int cant = cosulMeuPage.cantitateaTotalaDinCosPopUp();
        assertTrue("Cosul de cumparaturi este gol.", cant > 0);
    }


    @Test
    @Order(5)
    public void _elogoutTest(){
        landingPage.logout();
        landingPage.clickContulMeu();
        assertTrue("Esti inca logat in aplicatie.", landingPage.checkIfTheConectareButtonIsDisplayed());
    }

}
