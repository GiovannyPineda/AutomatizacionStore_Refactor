package store.page;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.page.base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;

public class SuiteListener implements ITestListener{

    //Se ejecutando automaticamente cuando falla un test
    @Override
    public void onTestFailure(ITestResult result){

        //Se obtiene el nombre del test que fallo
        String nombreTest = result.getName();
        System.out.println("Error: " + result.getThrowable());

        //Obtenemos el driver desde el test que fallo
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");

        //Se llama al metodo getScreenshot

        try{
            String patch = Base.getScreenshot(nombreTest, driver);

            ExtentManager.test.fail("Evidencia de fallo: ", MediaEntityBuilder.createScreenCaptureFromPath(patch).build());
            ExtentManager.test.fail(result.getThrowable());
        }catch (IOException e){
            System.out.println("Error al capturar pantalla: "+ e.getMessage());

        }

    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test exitoso: " + result.getName());
    }
}
