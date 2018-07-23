package cars.forms.pages;

import cars.entities.Car;
import cars.forms.menu.MainMenu;
import framework.BasePage;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CompareTrimsPage extends BasePage {
    private Label lblTitle = new Label(By.xpath("//h1[@class='cui-heading-1']"));
    private Label lblEngine = new Label(By.xpath("//div[contains(@class, 'cell cell-bg grow-2')]"));
    private Label lblTransmission = new Label(By.xpath("//div[contains(@class, 'cell cell-bg grow-2')]//following-sibling::div[@class='cell grow-2']"));
    private MainMenu mainMenu = new MainMenu();


    public CompareTrimsPage() {
        super(By.xpath("//h1[contains(text(), 'Compare Trims')]"), "CompareTrim Page");
    }

    public void defineEngineAndTransmission(Car car) {
        car.getMap().put("engine", lblEngine.getText());
        car.getMap().put("transmission", lblTransmission.getText());
    }

    public String getCarTitle() {
        return lblTitle.getText();
    }

    public void goToMainPage() {
        mainMenu.goToMainPage();
    }

}
