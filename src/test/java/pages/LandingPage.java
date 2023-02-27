package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.AbstractPageDriver;

public class LandingPage extends AbstractPageDriver {

    public static final String CONTUL_MEU_CSS = ".account-trigger.cdz-top-link";
    public static final String EMAIL_INPUT_FIELD_ID = "email";
    public static final String PASSWORD_INPUT_FIELD_ID = "pass";
    public static final String BUTON_CONECTARE_ID = "send2";
    public static final String BUTON_DECONECTARE_CSS = ".md-raised.md-primary";
    public static final String SEARCH_INPUT_ID = "search";
    public static final String LOGIN_TEXT_XPATH = "//p[@class='title']";
    public static final String MESAJ_EROARE_EMAIL_ID = "email-error";
    public static final String MESAJ_EROARE_PAROLA_ID = "pass-error";

    public LandingPage skipCookieBanner(){
        if(driver.findElement(By.id("CybotCookiebotDialogBody")).isDisplayed()){
            driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonAccept")).click();
        }
        return this;
    }

    public LandingPage login(String emailValue, String passwordValue){
        WebElement contulMeu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CONTUL_MEU_CSS)));
        contulMeu.click();
        WebElement emailInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(EMAIL_INPUT_FIELD_ID)));
        WebElement passwordInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PASSWORD_INPUT_FIELD_ID)));
        WebElement butonConnectare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BUTON_CONECTARE_ID)));

        emailInputField.click();
        emailInputField.sendKeys(emailValue);
        passwordInputField.click();
        passwordInputField.sendKeys(passwordValue);

        butonConnectare.click();
        return this;
    }

    public LandingPage clickContulMeu(){
        WebElement contulMeu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CONTUL_MEU_CSS)));
        contulMeu.click();
        return this;
    }

    public WebElement getUserText(){
        WebElement userText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_TEXT_XPATH)));
        return userText;
    }

    public LandingPage logout(){
        WebElement contulMeu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CONTUL_MEU_CSS)));
        contulMeu.click();
        WebElement buttonDeconectare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(BUTON_DECONECTARE_CSS)));
        buttonDeconectare.click();
        return this;
    }

    public Boolean checkIfTheConectareButtonIsDisplayed(){
        Boolean condition = false;
        WebElement butonConnectare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BUTON_CONECTARE_ID)));
        if(butonConnectare.isDisplayed()){
            condition = true;
        }
        return condition;
    }

    public CatalogSearchResultsPage search(String searchItem){
        driver.get("https://www.libhumanitas.ro/");
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SEARCH_INPUT_ID)));
        searchInput.click();
        searchInput.sendKeys(searchItem);
        searchInput.sendKeys(Keys.ENTER);
        return new CatalogSearchResultsPage();
    }

    public String getTextFromWrongEmail(){
        return driver.findElement(By.id(MESAJ_EROARE_EMAIL_ID)).getText();

    }

    public String getTextFromWrongPassword(){
        return driver.findElement(By.id(MESAJ_EROARE_PAROLA_ID)).getText();

    }
}
