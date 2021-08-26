package testsScheduler;

import config.ConfigScheduler;
import dto.Authdto;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesScheduler.SplashScreen;

public class LoginTest extends ConfigScheduler {
    @Test
    public void loginTestPositive(){
        boolean isFabButtonPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("abc@gmail.com")
                .fillPassword("aA1234567$")
                .clickLoginButtonPos()
                .skipWizard()
                .isFabAddPresent();

        Assert.assertTrue(isFabButtonPresent);

    }

    @Test
    public void loginTestNegativeWithInvalidPassword(){
        Authdto dto = Authdto.builder()
                .email("abc@gmail.com")
                .password("aA1234567")
                .build();
        boolean errIsPres = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillLoginWithDto(dto)
                .clickLoginButtonNeg()
                .isErrPres();

        Assert.assertTrue(errIsPres);
    }

    @Test
    public void negativeLoginTest(){
        Authdto dto = Authdto.builder()
                .email("abc@gmail.com")
                .password("aA1234567")
                .build();
        String err = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillLoginWithDto(dto)
                .clickLoginButtonNeg()
                .getErrorText();
        Assert.assertEquals(err, "Wrong email or password");
    }
}
