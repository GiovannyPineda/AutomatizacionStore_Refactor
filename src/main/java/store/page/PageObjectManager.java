package store.page;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private Login loginPage;
    private Phones phonesPage;
    private Laptops laptopsPage;
    private CartProducts cartPage;
    private CompleteOrder completePage;
    private Delete deletePage;
    private Logout logoutPage;
    private Contact contactPage;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;

    }

    public Login getLoginPage(){
        if (loginPage == null){
            loginPage = new Login(driver);

        }
        return loginPage;
    }
    public Phones getPonesPage(){
        if (phonesPage == null){
            phonesPage = new Phones(driver);

        }
        return phonesPage;
    }

    public Laptops getLaptopsPage(){
        if (laptopsPage == null){
            laptopsPage = new Laptops(driver);
        }
        return laptopsPage;
    }
    public CartProducts getCartPage(){
        if (cartPage == null){
            cartPage = new CartProducts(driver);
        }
        return cartPage;
    }

    public CompleteOrder getCompletePage() {
        if (completePage == null){
            completePage = new CompleteOrder(driver);
        }
        return completePage;
    }

    public Delete getDeletePage(){
        if (deletePage == null){
            deletePage = new Delete(driver);
        }
        return deletePage;
    }

    public Logout getLogoutPage(){
        if (logoutPage == null){
            logoutPage = new Logout(driver);
        }
        return logoutPage;
    }

    public Contact getContactPage() {
        if (contactPage == null){
            contactPage = new Contact(driver);
        }
        return contactPage;
    }
}
