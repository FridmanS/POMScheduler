package advancedTests;

import config.ConfigAdvanced;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAdvanced.DragScreen;

public class SwipeTests extends ConfigAdvanced {

    @Test
    public void swipeLeftTest(){
        boolean isElementPinned = new DragScreen(driver)
                .selectSwipe()
                .selectSwipeBasic()
                .swipeLeft(1)
                .isElementPinned();
        Assert.assertTrue(isElementPinned);
    }

    @Test
    public void swipeRightTest(){
        boolean isItemRemowed = new DragScreen(driver)
                .selectSwipe()
                .selectSwipeBasic()
                .swipRight(5)
                .isItemRemoved();
        Assert.assertTrue(isItemRemowed);
    }
}
