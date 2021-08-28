package testsScheduler;

import config.ConfigScheduler;
import dto.Authdto;
import dto.EventDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesScheduler.SplashScreen;

import java.util.Random;

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

    @Test
    public void eventCreationWithDtoTest(){
        EventDto dto = EventDto.builder()
                .title("title" + (System.currentTimeMillis()/1000)%3600)
                .type("type")
                .breaks(new Random().nextInt(5))
                .wage(32)
                .build();
        boolean isEventCreated = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillLoginWithDto(Authdto.builder()
                        .email("abc@gmail.com")
                        .password("aA1234567$")
                        .build())
                .clickLoginButtonPos()
                .skipWizard()
                .createEventScreen()
                .fillCreationEditForm(dto)
                .confirmCreationEvent()
                .isFabAddPresent();
        Assert.assertTrue(isEventCreated);
    }

}
