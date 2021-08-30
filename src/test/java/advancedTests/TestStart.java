package advancedTests;

import config.ConfigAdvanced;
import org.testng.annotations.Test;
import pagesAdvanced.DragScreen;

public class TestStart extends ConfigAdvanced {

    @Test
    public void dragDown(){
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragDown(4);
    }

    @Test
    public void dragDownWindowTest(){
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragDownWindow();
    }
}
