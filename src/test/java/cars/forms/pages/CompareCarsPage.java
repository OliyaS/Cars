package cars.forms.pages;

import cars.entities.Car;
import cars.forms.forms.SelectionCarForm;
import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class CompareCarsPage extends BasePage {

    private Button btnStartComparing = new Button(By.xpath("//button[@class='done-button']"));
    private SelectionCarForm selectionCarForm = new SelectionCarForm();

    public CompareCarsPage() {
        super(By.xpath("//h2[contains(@class, 'compare-sub-head')]"), "Compare Cars Page");
    }

    public void selectFirstCar(Car car1) {
        selectionCarForm.fillOutForm(car1);
        btnStartComparing.clickAndWait();
    }
}
