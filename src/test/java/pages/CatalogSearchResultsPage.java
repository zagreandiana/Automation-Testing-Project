package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.AbstractPageDriver;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CatalogSearchResultsPage extends AbstractPageDriver {

    public static final String LIST_OF_ITEMS_CSS = ".item.product.product-item";

    public CatalogSearchResultsPage(){
        super();
    }

    public Boolean checkIfTheSearchedBookIsInTheListOfResults(String item){
        AtomicReference<Boolean> condition = new AtomicReference<>(false);
        List<WebElement> listOfItems = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(LIST_OF_ITEMS_CSS)));
        listOfItems.forEach((WebElement elementFromList) -> {
            WebElement currentItemText = elementFromList.findElement(By.cssSelector(".product.name.product-item-name"));
            if(currentItemText.getText().contains(item)){
                condition.set(true);
            }
        });
        return condition.get();
    }

    public ProductPage clickCarte(String numeCarte) throws NullPointerException{
        List<WebElement> listaCarti = driver.findElements(By.cssSelector(LIST_OF_ITEMS_CSS));
        for (WebElement carte : listaCarti) {
            WebElement currentItemText = carte.findElement(By.xpath("//a[@class='product-item-link']"));
            if (currentItemText.getText().contains(numeCarte)) {
                currentItemText.click();
                break;
            }
        }

        return new ProductPage();
    }

}
