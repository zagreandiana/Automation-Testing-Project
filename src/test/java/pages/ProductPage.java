package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.AbstractPageDriver;

public class ProductPage extends AbstractPageDriver {

    public ProductPage(){
        super();
    }

    public static final String ADAUGA_IN_COS_ID = "product-addtocart-button";
    public static final String COSUL_MEU_ID = "desk_cart-wrapper";
    public static final String VIZUALIZEAZA_COS_CSS = ".action.button.secondary";


    public ProductPage clickAdaugaInCos(){
        WebElement adaugaInCos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ADAUGA_IN_COS_ID)));
        adaugaInCos.click();
        return this;
    }

    public ProductPage clickCosulMeu(){
        driver.findElement(By.id(COSUL_MEU_ID)).click();
        return this;
    }

    public CosulMeuPage clickVizualizeazaCosulMeu(){
        WebElement cosulMeu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(VIZUALIZEAZA_COS_CSS)));
        cosulMeu.click();
        return new CosulMeuPage();
    }
}
