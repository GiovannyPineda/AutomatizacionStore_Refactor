package store.page;

import com.page.base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Contact extends Base {
    private WebDriverWait wait;
    //CONTACTANOS
    By ContacLocator = By.xpath("//a[text()='Contact']");
    By ContacEmailLocator = By.cssSelector("input[id='recipient-email']");
    By ContacNameLocator = By.cssSelector("input[id='recipient-name']");
    By ContacMessageLocator = By.cssSelector("textarea[id='message-text']");
    By SendmessageLocator = By.cssSelector("button.btn.btn-primary[onclick='send()']");

    public Contact(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }
    public void contac(String email, String user, String desc) {

        wait.until(ExpectedConditions.elementToBeClickable(ContacLocator)).click();

        wait.until(ExpectedConditions.elementToBeClickable(ContacEmailLocator));
        type(email,ContacEmailLocator);
        type(user, ContacNameLocator);
        type(desc, ContacMessageLocator);

        click(SendmessageLocator);
        //QUITAR UNA ALERTA
       String mensaje = handleAlert();
        if (mensaje !=null){
            System.out.println("Mensaje : "+ mensaje);
        }
    }

}
