package test.score.qa.pages;

import org.openqa.selenium.By;

public class EmailSignUpPage extends BaseAction {

    By maybeLaterBtn = By.id("com.fivemobile.thescore:id/btn_secondary");

    By titleText = By.id("com.fivemobile.thescore:id/title_onboarding");

    public void dismissEmailSignUp() {
        click(maybeLaterBtn);
    }

    public String getTitleText() {
        return getText(titleText);
    }
}
