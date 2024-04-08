package test.score.qa.pages;

import org.openqa.selenium.By;

public class LeaguesSubTab extends BaseAction{

    By eastTextStandings = By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"EAST\"]");
    By westTextStandings = By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/txt_name\" and @text=\"WEST\"]");
    public boolean isSubTabExists(String subTabName) {
        return (isElementPresent(By.xpath("//android.widget.TextView[@text=\"" + subTabName + "\"]")));
    }

    public void clickSubTab(String subTabName) {
        if (isElementPresent(By.xpath("//android.widget.TextView[@text=\"" + subTabName + "\"]"))); {
            click(By.xpath("//android.widget.TextView[@text=\"" + subTabName + "\"]"));
        }
    }

    public boolean isStandingSubTabData() {
        if (isElementPresent(eastTextStandings)
            && isElementPresent(westTextStandings)) {
            return true;
        }
        return false;
    }
}
