package store.page;

import com.page.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout extends Base {
    private WebDriverWait wait;

    //CERRAR LA SESION
    By LogutLocator = By.xpath("//*[@id=\"logout2\"]");


    public Logout(WebDriver driver){
        super(driver);
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(LogutLocator));
        click(LogutLocator);
        System.out.println("Se cerro session correctamente");
    }
}
