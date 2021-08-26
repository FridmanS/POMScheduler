package testsScheduler;

import config.ConfigScheduler;
import dto.Authdto;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesScheduler.SplashScreen;

public class EventCreateTest extends ConfigScheduler {

    @Test
    public void eventCreationTest(){
        boolean isEventCreated = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillLoginWithDto(Authdto.builder()
                        .email("abc@gmail.com")
                        .password("aA1234567$")
                        .build())
                .clickLoginButtonPos()
                .skipWizard()
                .createEventScreen()
                .fillCreationEditForm("Even", "DV", 3, 30)
                .confirmCreationEvent()
                .isFabAddPresent();
        Assert.assertTrue(isEventCreated);
    }
}
