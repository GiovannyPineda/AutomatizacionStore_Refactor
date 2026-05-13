package store.page;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.page.base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;

import static store.page.ExtentManager.test;

@Listeners(SuiteListener.class)
public class StoreTest extends Base {

    private WebDriver driver;

    ExtentReports extent;
    ExtentSparkReporter spark;
    PageObjectManager manager;

    @BeforeClass
    public void SetU() throws Exception {

        spark = new ExtentSparkReporter("Reporte_Demoblaze.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        Base base = new Base();
        driver = base.chromeDriverConnection();
        driver.manage().window().maximize();

        ITestContext context = Reporter.getCurrentTestResult().getTestContext();
        context.setAttribute("WebDriver", driver);

        manager = new PageObjectManager(driver);

    }

    @AfterMethod
    public void tearDown() throws Exception {
        extent.flush();

    }

    @Test(priority = 1)
    public void test() throws Exception {

        test = extent.createTest("Ingreso a la página de prueba");
        //Pedimos los datos a la Base
        String url = getProperty("url");

        String user = getProperty("usuario");
        String pass = getProperty("password");

        //Se usan las variables
        driver.get(url);
        manager.getLoginPage().Login(user,pass);
        test.pass("El login fue exitoso");
    }

    @Test(priority = 2)
    public void PhonesPage()throws Exception{
        test = extent.createTest("Compra de Celulares");
        manager.getPonesPage().BuyPhones();
        test.pass("Compra de celulares finalizada");
    }
    @Test(priority = 3)
    public void BuyLaptops()throws Exception{
        test = extent.createTest("Compra de Laptos");
        manager.getLaptopsPage().BuyLaptops();
        test.pass("Compra de Laptos finalizada");


    }
    @Test(priority = 4)

    public void catallproducts()throws Exception{
        test = extent.createTest("Se ingreso a completar la orden");
        manager.getCartPage().cartallproducts();
        test.pass("Ingreso éxitoso al carrito de productos");

    }
    @Test(priority = 5)
    public void completeorder()throws Exception{
        test = extent.createTest("Se ingreso a completar la orden");
        String name = getProperty("name");
        String country = getProperty("country");
        String city = getProperty("city");
        String card = getProperty("card");
        String month = getProperty("month");
        String year = getProperty("year");
        manager.getCompletePage().completorder(name,country,city,card,month,year);
        test.pass("Se realizo la orden correctamente");

    }
    /*@Test(priority = 6)
    public void deleteproduct() {
        test = extent.createTest("Ingresando a la eliminación de un producto");
        manager.getDeletePage().delete();
        test.pass("Se elimino un producto exitosamente");
    }
    @Test(priority = 7)
    public void deleteallproducts() {
        test = extent.createTest("Ingresando a eliminar todos los prodcutos");
        manager.getDeletePage().deleteAllItems();
        test.pass("Se eliminaron todos los productos exitosamente");

    }*/
    @Test(priority = 8)
    public void contact()throws Exception {
        test = extent.createTest("Se ingereso a la funcionalidad de contacto");
        String email = getProperty("email");
        String user = getProperty("user");
        String desc= getProperty("desc");
        manager.getContactPage().contac(email,user, desc);
        test.pass("Se envió la información de contacto exitosamente");

    }
    @Test(priority = 9)
    public void logout()throws Exception{
        test = extent.createTest("Cierre de sesion");

            manager.getLogoutPage().logout();
            test.pass("Se realizo el cierre de sesion exitosamente");

    }
}
