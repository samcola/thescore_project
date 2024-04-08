package test.score.qa.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.junit.Assert;
import test.score.qa.pages.*;
import test.score.qa.utils.JsonParserUtil;

import java.util.Map;
import java.util.logging.Logger;

public class TestScenarioAutomationStepDef {

    private static final Logger logger = Logger.getLogger(TestScenarioAutomationStepDef.class.getName());

    @Given("User is at Start page")
    public void makeSureUserIsAtStartPage() {
        StartPage sp = new StartPage();
        Assert.assertTrue(sp.isHomeScreenPage());
    }

    @When("User clicks get started button")
    public void clicksGetStarted() {
        StartPage sp = new StartPage();
        sp.getStartedButton();
    }

    @Then("User should see Leagues page")
    public void getsLeaguesPage() {
        LeaguesPage lp = new LeaguesPage();
        Assert.assertEquals("Choose your favorite leagues", lp.getScreenTitle());
    }

    @When("User selects League {string}")
    public void selectLeague(String leagues) {
        LeaguesPage lp = new LeaguesPage();
        String[] leaguesArr = leagues.split(",");
        for (String eachleague : leaguesArr) {
            lp.selectLeague((String) JsonParserUtil.getLeagues(eachleague).get("name"));

        }

    }

    @Then("User sees selected Leagues {string}")
    public void verifyLeagueSelected(String leagues) {
        LeaguesPage lp = new LeaguesPage();
        String[] leaguesArr = leagues.split(",");
        for (String eachLeague : leaguesArr) {
            Assert.assertTrue(lp.isleagueselected(eachLeague));
        }
    }

    @When("User clicks Continue button")
    public void pressContinueButton() {
        LeaguesPage lp = new LeaguesPage();
        lp.continueButtton();
        lp.handleTailoredContentPopUp();
    }

    @Then("User sees the Teams page")
    public void getsTeamPage() {
        TeamPage tp = new TeamPage();
        Assert.assertEquals("Choose your favorite teams", tp.getScreenTitle());
    }

    @When("User selects the teams in the leagues tab")
    public void selectsTeamsTab(DataTable table) {
        TeamPage tp = new TeamPage();
        Map<String, String> tableData = table.asMap();
        for (Map.Entry<String, String> eachLeague : tableData.entrySet()) {
            String league = eachLeague.getKey();
            String teams = eachLeague.getValue();
            tp.selectLeaguesInTeams(league);
            for (String teamCode : teams.split(",")) {
                tp.selectTeam((String) ((JSONObject) JsonParserUtil.getLeagues(league).get("teams")).get(teamCode));
            }
        }
    }
    @Then("User sees selected teams in the leagues tab")
    public void verifyTeamSelected(DataTable table){
        TeamPage tp = new TeamPage();
        Map<String,String> tableData = table.asMap();
        for(Map.Entry<String,String> eachLeague : tableData.entrySet()){
            String League = eachLeague.getKey();
            String teams = eachLeague.getValue();
            for(String teamCode : teams.split(",")){
                Assert.assertTrue(tp.isTeamSelected(teamCode));
            }
        }

    }
    @And("User clicks Done Button")
    public void pressDoneButton(){
        UpdatesPage up = new UpdatesPage();
        up.doneButton();
    }

    @Then("User sees the email sign up page")
    public void verifyEmailSignUpPage() {
        EmailSignUpPage es = new EmailSignUpPage();
        Assert.assertEquals(es.getTitleText(), "Introducing theScore Messaging!");
    }

    @When("User clicks the maybe later button")
    public void clickMaybeLaterBtn() {
        EmailSignUpPage es = new EmailSignUpPage();
        es.dismissEmailSignUp();
    }

    @And("User clicks Don't Allow notifications")
    public void clickDontAllowNotifBtn() {
        HomePage hp = new HomePage();
        hp.clickDontAllowButton();
    }

    @And("User closes the pop up")
    public void closePopUp() {
        HomePage hp = new HomePage();
        hp.clickCancelPopUp();
    }

    @Then("User sees the home page search bar")
    public void verifyHomePageSearchBar() {
        HomePage hp = new HomePage();
        Assert.assertEquals(hp.getMainPageSearchBarText(), "Teams, Players, and News");
    }

    @Given("User sees the Home Page")
    public void verifyHomePage() {
        HomePage hp = new HomePage();
        Assert.assertTrue(hp.isHomeScreenPage());
    }

    @When("User clicks add button in the home page")
    public void clickAddBtnHomePage() {
        HomePage hp = new HomePage();
        hp.clickAddBtn();
    }

    @Then("User sees the title {string}")
    public void verifyTitle(String title) {
        HomePage hp = new HomePage();
        Assert.assertEquals(title, hp.getTitleAfterAddBtnClick());
    }

}


