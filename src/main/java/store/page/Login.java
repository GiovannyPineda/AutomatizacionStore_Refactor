package store.page;

import com.page.base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends Base {
    private WebDriverWait wait;
    //Localizadores
    //LOGIN DE USUARIO
    By loginloctor = By.id("login2");
    //By loginloctor = By.id("login1");
    By loginusernamelocator = By.id("loginusername");
    By loginpasswordlocator = By.id("loginpassword");
    By Btnloginlocator = By.cssSelector("button[type='button'][onclick='logIn()'].btn.btn-primary");

    public Login(WebDriver driver){
        super(driver);
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(4));
    }

        public void Login(String name,String pass) {

            //CLICK AL BOTÓN DE LOGIN
            wait.until(ExpectedConditions.elementToBeClickable(loginloctor)).click();

            //COLOCAR EL NOMBRE DE USUARIO Y EL PASSWORD
            wait.until(ExpectedConditions.elementToBeClickable(loginusernamelocator)).sendKeys(name);
            type(pass, loginpasswordlocator);

            //DARLE CLICK EN LOGIN CUANDO EL BOTON ESTA OCULTO
            WebElement Btnlogin = driver.findElement(Btnloginlocator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.visibility='visible';", Btnlogin);
            // Forzar visibilidad
            js.executeScript("arguments[0].click();", Btnlogin);

            //QUITAR UNA ALERTA
            String mensaje = handleAlert();
            if (mensaje != null) {
                System.out.println("Mensaje: " + mensaje);
            }
        }
}