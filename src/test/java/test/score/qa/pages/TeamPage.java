package test.score.qa.pages;

import org.openqa.selenium.By;

public class TeamPage extends BaseAction {

    By titleText = By.id("com.fivemobile.thescore:id/title_onboarding");

    public String getScreenTitle() {
        return getText(titleText);
    }

    public void selectLeaguesInTeams(String leaguecode){
        click(By.xpath("//android.widget.LinearLayout[@content-desc='"+leaguecode+"']"));
    }

    public void selectTeam(String teamName){
        click(By.xpath("//android.widget.TextView[contains(@text,'"+teamName+"')]"));

    }

    public boolean isTeamSelected(String teamName){
        return isElementPresent(By.xpath("//*[@resource-id='com.fivemobile.thescore:id/chips_container']//android.widget.TextView[contains(@text,'"+teamName+"')]"));
    }
}
