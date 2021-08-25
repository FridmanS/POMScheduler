package pagesScheduler;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends BaseScreen{
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;

    public boolean isFabAddPresenr(){
        should(fabAdd, 10);
        return true;
    }
}
