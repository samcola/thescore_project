package test.score.qa.pages;

import org.openqa.selenium.By;

public class StartPage extends BaseAction {
    By continueButton = By.id("com.fivemobile.thescore:id/action_button_text");

    By btngetStarted = By.id("com.fivemobile.thescore:id/btn_primary");

    public void getStartedButton() {
        click(btngetStarted);
    }

    public void goToLeagueSelectionPage() {
        click(continueButton);
    }

    public boolean isHomeScreen() {
        return isElementPresent(continueButton);
    }

    public boolean isHomeScreenPage() {
        return isElementPresent(btngetStarted);
    }
}
