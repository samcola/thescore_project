package test.score.qa.pages;

import org.openqa.selenium.By;

public class PlayerInfoSubtab extends BaseAction {

    By birthDateTitle = By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/title\" and @text=\"Birth Date\"]");

    By heightTitle = By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/title\" and @text=\"Height\"]");

    public boolean isPlayerInfoSubTab() {
        if (isElementPresent(birthDateTitle) && isElementPresent(heightTitle)) {
            return true;
        }
        return false;
    }
}
