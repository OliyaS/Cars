package cars.steps;

import cars.entities.Car;
import cars.forms.menu.MainMenu;
import cars.forms.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class HooksSteps {
    private MainPage mainPage;
    private ResearchPage researchPage;
    private CarPage carPage;
    private CompareTrimsPage compareTrimsPage;
    private CompareCarsPage compareCarsPage;
    private SideBySidePage sideBySidePage;
    private AnotherCarSelectionPage anotherCarSelectionPage;
    private Car car;
    private static List<Car> cars = new ArrayList<>();

    private String expectedTitle;
    private String actualTitle;
    private List<String> actualEngines;
    private List<String> actualTransmissions;

    private SoftAssert softAssert = new SoftAssert();
    private static int attempt;


    @Given("^user is on the Main page cars\\.com$")
    public void userIsOnTheMainPageCarsCom() {
        mainPage = new MainPage();
    }

    @When("^click Research from Main menu$")
    public void clickResearchFromMainMenu() {
        mainPage.mainMenu.navigateMenu(MainMenu.Menu.RESEARCH);
    }

    @And("^select car with random parameters$")
    public void selectRandomParameters() {
        researchPage = new ResearchPage();
        researchPage.selectCar();
        car = researchPage.getCar();
    }

    @And("^click CompareTrims on just opened Car page$")
    public void clickCompareTrimsOnJustOpenedCarPage() {
        carPage = new CarPage();
        if (carPage.isElementFound()) carPage.compare();
        else {
            attempt++;
            if (attempt <= 3) {
                clickResearchFromMainMenu();
                selectRandomParameters();
                clickCompareTrimsOnJustOpenedCarPage();
            }
        }
    }

    @Then("^opened CompareTrims page contains selected make, model, year$")
    public void openedCompareTrimsPageContainsSelectedMakeModelYear() {
        compareTrimsPage = new CompareTrimsPage();
        compareTrimsPage.defineEngineAndTransmission(car);
        cars.add(car);

      softAssert.assertTrue(compareTrimsPage.getCarTitle().contains(researchPage.getCarFullName()),researchPage.getCarFullName()+" is in the title "+compareTrimsPage.getCarTitle() );

    }

    @And("^go back to the main page$")
    public void goBackToTheMainPage() {
        compareTrimsPage.goToMainPage();
    }

    @And("^go to Side-By-Side Comparisons$")
    public void goToSideBySideComparisons() {
        researchPage = new ResearchPage();
        researchPage.goToSideBySide();
    }

    @And("^select first car$")
    public void selectFirstCar() {
        compareCarsPage = new CompareCarsPage();
        compareCarsPage.selectFirstCar(cars.get(0));
    }

    @And("^add to comparison another car$")
    public void addToComparisonsSecondCar() {
        sideBySidePage = new SideBySidePage();
        sideBySidePage.addAnotherCar();
        anotherCarSelectionPage = new AnotherCarSelectionPage();
        anotherCarSelectionPage.selectSecondCar(cars.get(1));

    }

    @Then("^characteristics of the selected cars are correct$")
    public void characteristicsOfTheSelectedCarsAreCorrect() {
        for (int i = 0; i < cars.size(); i++) {
            actualTitle = sideBySidePage.getTitle(i);
            actualEngines = sideBySidePage.getEngines(i);
            actualTransmissions = sideBySidePage.getTransmissions(i);

            expectedTitle = String.format("%s %s %s", cars.get(i).getMap().get("year"), cars.get(i).getMap().get("make"), cars.get(i).getMap().get("model"));

            softAssert.assertEquals(actualTitle, expectedTitle);
            softAssert.assertTrue(actualEngines.contains(cars.get(i).getMap().get("engine")), "side-by-side comparison contains selected car engine " +cars.get(i).getMap().get("engine") );
            softAssert.assertTrue(actualTransmissions.contains(cars.get(i).getMap().get("transmission")), "side-by-side comparison contains selected car transmission "+cars.get(i).getMap().get("transmission"));
            softAssert.assertAll();

        }

    }
}
