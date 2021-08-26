package pagesScheduler;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.extern.java.Log;

public class HomeScreen extends BaseScreen{
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;
    @AndroidFindBy (xpath = "//*[@content-desc = 'Open']")
    MobileElement burgerMenu;
    @AndroidFindBy (xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/nav_fr_logout_container']")
    MobileElement logOutBtn;
    @AndroidFindBy (xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/fab_add_event']")
    MobileElement addEvent;

    public boolean isFabAddPresent(){
        should(fabAdd, 10);
        return true;
    }

    public HomeScreen openBurgerMenu(){
        click(burgerMenu);
        return this;
    }
    public LoginScreen logOut(){
        click(logOutBtn);
        return new LoginScreen(driver);
    }

    public EditeCreateEventScreen  createEventScreen(){
        click(fabAdd);
        click(addEvent);
        return new EditeCreateEventScreen(driver);
    }
}
