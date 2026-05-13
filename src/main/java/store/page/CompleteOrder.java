package store.page;

import com.page.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompleteOrder extends Base{
    private WebDriverWait wait;
    //COMPLETAR LA ORDEN
    By Placeorderlocator = By.cssSelector("button.btn.btn-success");
    By Namelocator = By.xpath("//input[@id ='name']");
    By Countrylocator = By.xpath("//input[@id=\"country\"]");
    By Citylocator = By.xpath("//input[@id=\"city\"]");
    By Cardlocator = By.xpath("//input[@id=\"card\"]");
    By Monthlocator = By.xpath("//input[@id=\"month\"]");
    By Yearlocator = By.xpath("//input[@id=\"year\"]");

    //DARLE AL BOTON PARA COMPLETAR LA ORDEN
    By Btncompletelocator = By.cssSelector("button.btn.btn-primary[onclick='purchaseOrder()']");

    //ACEPTAR EL ÚLTIMO MENSAJE
    By Messagelocator = By.cssSelector("button[class='confirm btn btn-lg btn-primary']");

    public CompleteOrder(WebDriver driver){
        super(driver);
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(4));
    }

    public void completorder(String name,String country, String city,String card,String month,String year) {

        wait.until(ExpectedConditions.elementToBeClickable(Placeorderlocator)).click();

         wait.until(ExpectedConditions.elementToBeClickable(Namelocator));
        type(name,Namelocator);
        type(country, Countrylocator);
        type(city, Citylocator);
        type(card, Cardlocator);
        type(month, Monthlocator);
        type(year, Yearlocator);

        wait.until(ExpectedConditions.elementToBeClickable(Btncompletelocator)).click();


        try { Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        wait.until(ExpectedConditions.elementToBeClickable(Messagelocator)).click();
        System.out.println("El botón se cerró correctamente.");
        }
    }

