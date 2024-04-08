package test.score.qa.pages;

import org.openqa.selenium.By;

public class HomePage extends BaseAction {

    By alertDontAllowBtn = By.id("com.android.permissioncontroller:id/permission_deny_button");

    By popUpCancelButton = By.id("com.fivemobile.thescore:id/dismiss_modal");

    By mainPageSearchBar = By.id("com.fivemobile.thescore:id/search_bar_text_view");

    By addBtn = By.xpath("(//android.widget.ImageView[@resource-id=\"com.fivemobile.thescore:id/icon\"])[1]");

    By addBtntitleText = By.id("com.fivemobile.thescore:id/titleTextView");

    public void clickDontAllowButton() {
        dismissAlert(alertDontAllowBtn);
    }

    public void clickCancelPopUp() {
        click(popUpCancelButton);
    }

    public void clickAddBtn() {
        click(addBtn);
    }

    public String getTitleAfterAddBtnClick() {
        if (isElementPresent(addBtntitleText)) {
            return getText(addBtntitleText);
        }
        else {
            return null;
        }
    }

    public String getMainPageSearchBarText() {
        if (isElementPresent(mainPageSearchBar)) {
            return getText(mainPageSearchBar);
        }
        else {
            return null;
        }
    }

    public boolean isHomeScreenPage() {
        return isElementPresent(mainPageSearchBar);
    }

}
