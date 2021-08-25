package testsScheduler;

import config.ConfigScheduler;
import dto.AuthTest;
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
                .isFabAddPresenr();

        Assert.assertTrue(isFabButtonPresent);

    }

    @Test
    public void loginWithDto(){
        AuthTest testA = new AuthTest()
                .withEmail("abc@gmail.com")
                .withPassword("aA1234567$");
        AuthTest testB = new AuthTest()
                .withEmail("abc@gmail.com");
        Authdto dto = Authdto.builder()
                .email("abc@gmail.com")
                .password("aA1234567$")
                .build();
        boolean isFabPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .loginWithDto(dto)
                .clickLoginButtonPos()
                .skipWizard()
                .isFabAddPresenr();

        Assert.assertTrue(isFabPresent);
    }

    @Test
    public void loginTestNegativeWithInvalidPassword(){
        Authdto dto = Authdto.builder()
                .email("abc@gmail.com")
                .password("aA1234567")
                .build();
        boolean errIsPres = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .loginWithDto(dto)
                .clickLoginButtonNeg()
                .isErrPres();

        Assert.assertTrue(errIsPres);
    }
}
