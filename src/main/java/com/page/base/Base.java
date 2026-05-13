package com.page.base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Base {
    //Atributos y constructor
    public WebDriver driver;

      public Base(){

         }

    public Base (WebDriver driver){
        this.driver=driver;

    }

    //Metodos

    public  WebDriver chromeDriverConnection(){

        driver= new ChromeDriver();
        return  driver;
    }


    public WebElement findelement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findelements(By locator){
        return driver.findElements(locator);
    }
    public  String getText(WebElement element){
        return  element.getText();
    }

    public  String getText(By locator){
        return  driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
         driver.findElement(locator).click();
    }

    public void click(WebElement element){
        element.click();
    }

    public boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public void visit(String url){
        driver.get(url);
    }

    public String handleAlert() {
        try {
            // Usamos una espera explícita para la alerta
            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            alertWait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            return alertText;
        } catch (TimeoutException e) {
            System.out.println("No se presentó ninguna alerta.");
            return null;
        }
    }

    public static String getScreenshot(String ScreenshotName, WebDriver driver)throws IOException {

        //Se crea un nombre unico con la fecha y hora
        String dateName = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());

        //Se toma la captura
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        //Se define la ruta donde se guarda la captura
        String destination = System.getProperty("user.dir") + "/TestScreenshots/" + ScreenshotName + dateName + ".png";
        File finalDestionation = new File(destination);

        //Se copia el archivo a la carpeta
        FileUtils.copyFile(source, finalDestionation);
        return destination;
    }
    public String getProperty(String key) throws IOException{

        Properties properties = new Properties();
        //Indicamos la ruta del archivo de los datos
        FileInputStream file = new FileInputStream("src/main/resources/config.properties");

        properties.load(file);

        //Se retorna el valor de la llave
        return properties.getProperty(key);

    }
}
