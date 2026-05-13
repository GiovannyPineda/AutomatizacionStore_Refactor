package store.page;

import com.page.base.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class Delete extends Base{

    //BORRAR UN OBJETO DEL CARRITO
    By DeleteLocator = By.xpath("//a[starts-with(@onclick, 'deleteItem')]");

    private WebDriverWait wait;

    public  Delete(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public void delete() {
        try {

            wait.until(ExpectedConditions.elementToBeClickable(DeleteLocator));
            System.out.println("Elemento de eliminación encontrado y clickeable");
            click(DeleteLocator);
            System.out.println("Producto eliminado exitosamente");
        } catch (Exception e) {

        }
    }

    public void deleteAllItems() {

        wait.until(ExpectedConditions.elementToBeClickable(DeleteLocator));
        // Encontrar todos los botones de eliminar en el carrito
        List<WebElement> deleteButtons = driver.findElements(DeleteLocator);

        // Recorrer la lista de botones y hacer clic en cada uno
        for (WebElement deleteButton : deleteButtons) {
                wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
                System.out.println("Se eliminaron todos los productos exitosamente");

                // espera para  que el DOM se actualice
                wait.until(ExpectedConditions.elementToBeClickable(DeleteLocator));

        }
    }
}