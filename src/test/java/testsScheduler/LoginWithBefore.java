package testsScheduler;

import config.ConfigScheduler;
import dto.Authdto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesScheduler.HomeScreen;
import pagesScheduler.SplashScreen;

public class LoginWithBefore extends ConfigScheduler {

    @BeforeMethod
    public void preCondition(){
        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillLoginWithDto(Authdto.builder().build())
                .clickLoginButtonPos()
                .skipWizard();
    }

    @Test
    public void test(){

        new HomeScreen(driver).isFabAddPresent();
    }

}
