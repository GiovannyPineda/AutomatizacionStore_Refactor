package store.page;

import com.page.base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v132.runtime.Runtime;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Laptops extends Base {

    private final WebDriverWait wait;
    //DIRECCIONAMIENTO A LAS LAPTOPS
    By Laptopslocator = By.xpath("//a[text()='Laptops']");
    //PRODUCTOS AGREGADOS AL CARRRITO
    By Laptop1locator = By.xpath("//a[@href='prod.html?idp_=15']");
    By Laptop2locator = By.xpath("//a[@href='prod.html?idp_=12']");

    //REDIRECCIONAMIENTO AL HOME
    By Homelocator = By.xpath("//a[text()='Home ' and @class='nav-link']");
    //CARRITO
    By Carritolocator = By.xpath("//a[text()='Add to cart']");

    public Laptops(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public void Laptop(By laptosLocator) {

        if (isDisplayed(Laptopslocator)) {
            click(Laptopslocator);

            wait.until(ExpectedConditions.elementToBeClickable(laptosLocator)).click();

            //CLICK AL CARRITO
            wait.until(ExpectedConditions.elementToBeClickable(Carritolocator));
            click(Carritolocator);

            //QUITAR LA ALERTA
            String mensaje = handleAlert();
            if (mensaje != null) {
                System.out.println("Mensaje : " + mensaje);
            }
                //REGRESAR AL HOME
                wait.until(ExpectedConditions.elementToBeClickable(Homelocator)).click();
                //click(Homelocator);

        }
    }
        public void BuyLaptops() {
            Laptop(Laptop1locator);
            Laptop(Laptop2locator);

        }

    }

