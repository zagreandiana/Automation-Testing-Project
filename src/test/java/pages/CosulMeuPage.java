package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static tests.AbstractPageDriver.driver;
import static tests.AbstractPageDriver.wait;

public class CosulMeuPage extends AbstractMethodError{
    public CosulMeuPage(){
        super();
    }

    public static final String TEXT_CARTE_XPATH = "//div[@class='product-item-details']";
    public static final String CANTITATE_XPATH = "//input[@class='input-text qty']";

    public static final String BUTON_STERGERE_DIN_COS_CSS = ".action.action-delete";

    public static final String COS_CUMPARATURI_GOL_CSS = ".cart-empty";


    public Boolean textulCartiiPopUp(String numeCarte){
        boolean condition = false;
        WebElement textulCartii = driver.findElement(By.xpath(TEXT_CARTE_XPATH));
        if(textulCartii.getText().contains(numeCarte)){
            condition = true;
        }
        return condition;
    }

    public int cantitateaTotalaDinCosPopUp(){
        Integer cantitate = Integer.parseInt(driver.findElement(By.xpath(CANTITATE_XPATH)).getAttribute("value"));
        return cantitate;
    }

    public CosulMeuPage clickButonSterge(){
        WebElement butonSterge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(BUTON_STERGERE_DIN_COS_CSS)));
        butonSterge.click();
        return this;
    }

    public String getTextFromCos(){
        String cosText = "";
        WebElement cosCumparturiGolText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(COS_CUMPARATURI_GOL_CSS)));
        cosText = cosCumparturiGolText.getText();
        return cosText;
    }

}
