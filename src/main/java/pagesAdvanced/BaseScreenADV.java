package pagesAdvanced;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreenADV {
    AppiumDriver<MobileElement> driver;

    public BaseScreenADV(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void click(MobileElement element) {
        element.click();
    }

    public void should(MobileElement element, long timeOut){
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
    }
}
