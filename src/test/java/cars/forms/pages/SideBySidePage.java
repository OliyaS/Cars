package cars.forms.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SideBySidePage extends BasePage {
    private static String titleTemplate = "//cars-compare-compare-info//span[@index='%s']//h4";
    private static String enginesTemplate = "//cars-compare-compare-info [@header='Engine']//span[@index='%s']//p";
    private static String transTemplate = "//cars-compare-compare-info[@header='Transmission']//span[@index='%s']//p";
    private static String addButtonLocator = "//cui-icon[contains(@name, 'plus-line')]";
    private Button btnAddAnotherCar;
    private Label lblEngine;
    private Label lblTransmission;
    private Label lblTitle;
    private List<String> engines;
    private List<String> transmissions;
    private String title;


    public SideBySidePage() {
        super(By.xpath("//div[@class='research']//span[@id='compare']"), "Side-By-Side Page");
    }

    public void addAnotherCar() {
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(configProperties.getProperty("timeOut")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addButtonLocator)));

        btnAddAnotherCar = new Button(By.xpath(addButtonLocator));
        btnAddAnotherCar.clickAndWait();
    }

    public String getTitle(int num) {
        lblTitle = new Label(By.xpath(String.format(titleTemplate,num)));
        title=lblTitle.getText();
        return title;
    }

    public List<String> getEngines(int num) {
        lblEngine = new Label(By.xpath(String.format(enginesTemplate, num)));
        engines = trimValues(lblEngine.getListOfContent());
        return engines;
    }

    public List<String> getTransmissions(int num) {
        lblTransmission = new Label(By.xpath(String.format(transTemplate, num)));
        transmissions = trimValues(lblTransmission.getListOfContent());
        return transmissions;
    }

    private List<String> trimValues(List<String> list) {
        for (String line : list) {
            if (line.endsWith(",")) {
                line = (line.substring(0, line.length() - 1)).trim();
            }
        }
        return list;
    }

}
