package cars.forms.pages;


import cars.entities.Car;
import framework.BasePage;
import framework.elements.Button;
import framework.elements.Combobox;
import framework.elements.Label;
import org.openqa.selenium.By;

public class ResearchPage extends BasePage {

    private Button btnSubmit = new Button(By.xpath("//div[contains(@class, 'submit')]"));
    private Label lblSideBySide = new Label(By.xpath("//a[contains(@href,'research/compare')]"));
    private static String cmbLocator = "//select[contains(@ng-model, 'selections.%s')]";
    private static String[] list = {"make", "model", "year"};

    private Combobox cmbTemplate;
    private String selectedValue;
    private Car car;

    public ResearchPage() {
        super(By.xpath("//section[@id='research-search-widget']"), "Research Page");
    }

    public void selectCar() {
        car = new Car();
        for (String str : list) {
            cmbTemplate = new Combobox(By.xpath(String.format(cmbLocator, str)));
            selectedValue = cmbTemplate.selectByRandomId();
            car.getMap().put(str, selectedValue);
        }
        btnSubmit.click();
    }

    public String getCarFullName() {
       return String.format("%s %s %s", car.getMap().get("year"), car.getMap().get("make"), car.getMap().get("model"));
    }

    public Car getCar() {
        return this.car;
    }

    public void goToSideBySide() {
        lblSideBySide.click();
    }

}
