package cars.forms.pages;

import cars.entities.Car;
import cars.forms.forms.SelectionCarForm;
import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class AnotherCarSelectionPage extends BasePage {
    private Button btnDone = new Button(By.xpath("//button[contains(text(), 'Done')]"));
    private SelectionCarForm selectionCarForm = new SelectionCarForm();


    public AnotherCarSelectionPage() {
        super(By.xpath("//form[@id ='addCarFormModal']"), "Another Car Selection Page");
    }

    public void selectSecondCar(Car car2) {
       selectionCarForm.fillOutForm(car2);
       btnDone.clickAndWait();
    }
}
