package store.page;

import com.page.base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Phones extends Base {

    private final WebDriverWait wait;
    //DIRECCIONAMIENTO A LOS PHONES
    By Phonelocator = By.xpath("//a[text()='Phones']");

    //PRODUCTOS AGREGADOS AL CARRITO
    By Phone1locator = By.xpath("//a[text()='Samsung galaxy s7']");
    By Phone2locator = By.xpath("//a[@href='prod.html?idp_=6']");
    By Carritolocator = By.xpath("//a[text()='Add to cart']");

    //REDIRECCIONAMIENTO AL HOME
    By Homelocator = By.xpath("//a[text()='Home ' and @class='nav-link']");

    public Phones(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public void phones(By locatorProduct) {
        if (isDisplayed(Phonelocator)) {
            click(Phonelocator);
            wait.until(ExpectedConditions.elementToBeClickable(locatorProduct)).click();

            //CLICK EN EL CARRITO
            wait.until(ExpectedConditions.elementToBeClickable(Carritolocator));
            click(Carritolocator);

            //QUITAR UNA ALERTA
            String mensaje = handleAlert();
            if (mensaje != null) {
                System.out.println("Mensaje: " + mensaje);
            }

            //REGRESO AL HOME
            wait.until(ExpectedConditions.elementToBeClickable(Homelocator));
            click(Homelocator);
        }
    }
            public void BuyPhones() {

                phones(Phone1locator);

                phones(Phone2locator);
            }
        }



