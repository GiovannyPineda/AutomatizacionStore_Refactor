package store.page;

import com.page.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CartProducts extends Base {
    //CARRITO
    By Cartallproducts = By.xpath("//a[@class='nav-link' and text()='Cart']");
    private WebDriverWait wait;

    public CartProducts(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(4));
    }

        public void cartallproducts() {
         wait.until(ExpectedConditions.elementToBeClickable(Cartallproducts)).click();

         /*until(ExpectedConditions.elementToBeClickable(Cartallproducts));

        WebElement elementc = driver.findElement(Cartallproducts);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.visibility='visible';", elementc);
        // Forzar visibilidad
        js.executeScript("arguments[0].click();", elementc);*/


    }
}