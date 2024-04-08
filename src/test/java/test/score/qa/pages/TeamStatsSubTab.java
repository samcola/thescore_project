package test.score.qa.pages;

import org.openqa.selenium.By;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TeamStatsSubTab extends BaseAction{

    private static final Logger logger = Logger.getLogger(TeamStatsSubTab.class.getName());

    By statsHeader = By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/header_text\"]");

    By rankHeader = By.xpath("//android.widget.TextView[@resource-id=\"com.fivemobile.thescore:id/header_secondary_text\"]");

    public boolean isTeamStatsSubTab() {
        String statsHeaderText1 = getText(statsHeader);
        logger.log(Level.INFO, "stats header text: " + statsHeaderText1);

        String rankHeaderText1 = getText(rankHeader);
        logger.log(Level.INFO, "rank header text: " + rankHeaderText1);

        if (statsHeaderText1.equals("STATS") && rankHeaderText1.equals("(RANK)")) {
            return true;
        }
        return false;
    }
}
