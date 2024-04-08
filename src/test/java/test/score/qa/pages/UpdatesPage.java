package test.score.qa.pages;

import org.openqa.selenium.By;

public class UpdatesPage extends BaseAction{

    By titleText = By.id("com.fivemobile.thescore:id/title_onboarding");

    By btnDone = By.xpath("//*[@text='Done']");

    By dismissButton = By.id("com.fivemobile.thescore:id/dismiss_modal");

    public String getScreenTitle() {
        return getText(titleText);
    }

    public void doneButton(){
        click(btnDone);
        popup();
    }
    public void popup(){
        if(isElementPresent(dismissButton)) {
            click(dismissButton);
        }
    }

}
