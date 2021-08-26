package pagesScheduler;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EditeCreateEventScreen extends BaseScreen{
    public EditeCreateEventScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/info_title_input']")
    MobileElement title;
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/info_type_input']")
    MobileElement type;
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/info_break_plus_btn']")
    MobileElement breakPlusButton;
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/info_wage_edit']")
    MobileElement wageEdit;
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/info_wage_input']")
    MobileElement wageInput;
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/info_save_btn']")
    MobileElement confirmCreationEvent;
    @AndroidFindBy(xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/info_wage_save']")
    MobileElement wageSave;

    public EditeCreateEventScreen fillCreationEditForm(String titleS, String typeS, int breaksS, int wageS){
        type(title, titleS);
        type(type, typeS);
        hideKeyboard();
        if(breaksS > 0){
            for(int i = 0; i <= breaksS; i++){
                click(breakPlusButton);
            }
        }
        click(wageEdit);
        type(wageInput, Integer.toString(wageS));
        hideKeyboard();
        click(wageSave);
        return this;
    }
    public HomeScreen confirmCreationEvent(){
        click(confirmCreationEvent);
        return new HomeScreen(driver);
    }
}
