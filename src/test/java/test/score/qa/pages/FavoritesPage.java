package test.score.qa.pages;

import org.openqa.selenium.By;
import test.score.qa.managers.AppiumDriverManager;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FavoritesPage extends BaseAction {

    private static final Logger logger = Logger.getLogger(FavoritesPage.class.getName());

    By searchBar = By.id("com.fivemobile.thescore:id/search_bar_placeholder");

    By searchBarTextBox = By.id("com.fivemobile.thescore:id/search_src_text");

    By teamSubTab = By.xpath("//android.widget.TextView[@text=\"TEAMS\"]");

    By leagueSubTab = By.xpath("//android.widget.TextView[@text=\"LEAGUES\"]");

    By playerSubTab = By.xpath("//android.widget.TextView[@text=\"PLAYERS\"]");

    By listOptions = By.id("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.fivemobile.thescore:id/recyclerView\"]/");

    String listOption1 =  "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.fivemobile.thescore:id/recyclerView\"]/android.widget.LinearLayout[1]";
    String listOption0 =  "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.fivemobile.thescore:id/recyclerView\"]/android.widget.LinearLayout";

    By collapseOption = By.xpath("//android.widget.ImageButton[@content-desc=\"Collapse\"]");

    By navigateUpOption = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

    public void typeTextToSearchBar(String text) {
        click(searchBar);
        sendKeys(searchBarTextBox, text);
    }

    public void selectSubTab(String text) {
        if (text.equals("team")) {
            click(teamSubTab);
        } else if (text.equals("league")) {
            click(leagueSubTab);
        } else if (text.equals("player")) {
            click(playerSubTab);
        }
    }

    public boolean addOptionToFav() {
        if (isLoaded(driver.findElement(By.xpath(listOption0)))) {
            click(By.xpath(listOption0));
            return true;
        } else if (isLoaded(driver.findElement(By.xpath(listOption1)))) {
            click(By.xpath(listOption1));
            return true;
        }
        return false;
    }

    public void clickCollapseBtn() {
       if (isElementPresent(collapseOption)) {
           click(collapseOption);
       }
    }

    public void clickNavigateUpBtn() {
        if (isElementPresent(navigateUpOption)) {
            click(navigateUpOption);
        }
    }

}
