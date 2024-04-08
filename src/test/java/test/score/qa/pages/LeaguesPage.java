package test.score.qa.pages;

import org.openqa.selenium.By;

public class LeaguesPage extends BaseAction {

    By titleText = By.id("com.fivemobile.thescore:id/title_onboarding");

    By btnContinue = By.id("com.fivemobile.thescore:id/btn_primary");

    By btndisallow = By.id("com.fivemobile.thescore:id/btn_disallow");


    By btnpermissionallow = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");


    public String getScreenTitle() {
        return getText(titleText);
    }


    public void selectLeague(String leagueCode){
        click(By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"" + leagueCode + "\"]"));
    }
    public boolean isleagueselected(String leaguecode) {
        return isElementPresent(By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/label\" and @text=\"NFL\"]"));

    }
    public void continueButtton(){
        click(btnContinue);
    }

    public void handleTailoredContentPopUp(){
        if(isElementPresent(btndisallow)) {
            click(btndisallow);
        }
        else {
            return;
        }
    }
    }

