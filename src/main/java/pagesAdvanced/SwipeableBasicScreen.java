package pagesAdvanced;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SwipeableBasicScreen extends BaseScreenADV{
    public SwipeableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (xpath = "//*[@resource-id = 'android:id/text1']")
    List<MobileElement> list;
    @AndroidFindBy (xpath = "//*[@resource-id = 'android:id/message']")
    MobileElement pinnedMessage;
    @AndroidFindBy (xpath = "//*[@resource-id = 'com.h6ah4i.android.example.advrecyclerview:id/snackbar_text']")
    MobileElement removedMessage;

    public SwipeableBasicScreen swipeLeft(int i){
        MobileElement element = list.get(i);

        Rectangle rect = element.getRect();
        int xFrom = rect.getX() + rect.getWidth() / 2;
        int yFrom = rect.getY() + rect.getHeight() / 2;

        int xTo = xFrom - rect.getWidth() / 2;
        int yTo = yFrom;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom, yFrom))
                .moveTo(PointOption.point(xTo, yTo))
                .release()
                .perform();
        return this;
    }

    public boolean isElementPinned(){
        return pinnedMessage.getText().contains("Item pinned!");
    }


    public SwipeableBasicScreen swipRight(int i) {
        MobileElement element = list.get(i + 1);

        Rectangle rect = element.getRect();
        int xFrom = rect.getX() + rect.getWidth() / 2;
        int yFrom = rect.getY() + rect.getHeight() / 2;

        int xTo = xFrom + rect.getWidth() / 2;
        int yTo = yFrom;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom, yFrom))
                .moveTo(PointOption.point(xTo, yTo))
                .release()
                .perform();
        return this;
    }

    public boolean isItemRemoved() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(removedMessage));
        return removedMessage.getText().contains("1 item removed");
    }
}
