package cars.forms.pages;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;


public class CarPage extends BasePage {

    private Button btnCompareTrims= new Button(By.xpath("//a[contains(text(),'Compare Trims')]"));

    public CarPage() {
        super(By.xpath("//h1[@class='cui-page-section__title']"), "Car Page");
    }

    public boolean isElementFound() {
        return btnCompareTrims.isElementVisible();
    }

    public void compare() {
        btnCompareTrims.click();
    }
}


