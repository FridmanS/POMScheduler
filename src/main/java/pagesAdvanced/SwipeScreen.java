package pagesAdvanced;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwipeScreen extends BaseScreenADV{
    public SwipeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.h6ah4i.android.example.advrecyclerview:id/button'][2]")
    MobileElement swipeBasic;

    public SwipeableBasicScreen selectSwipeBasic(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(swipeBasic));
        click(swipeBasic);
        return new SwipeableBasicScreen(driver);
    }
}
