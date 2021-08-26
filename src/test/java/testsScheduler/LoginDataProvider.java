package testsScheduler;

import config.ConfigScheduler;
import config.MyDataProvider;
import dto.Authdto;
import org.testng.annotations.Test;
import pagesScheduler.LoginScreen;
import pagesScheduler.SplashScreen;

public class LoginDataProvider extends ConfigScheduler {

    @Test(dataProvider = "validLoginData", dataProviderClass = MyDataProvider.class)
    public void loginWithDto(String email, String password){

        Authdto dto = Authdto.builder()
                .email(email)
                .password(password)
                .build();
        //new SplashScreen(driver).checkVersion("0.0.3")
        new LoginScreen(driver).fillLoginWithDto(dto)
                .clickLoginButtonPos()
                .skipWizard()
                .openBurgerMenu()
                .logOut();
    }
}
