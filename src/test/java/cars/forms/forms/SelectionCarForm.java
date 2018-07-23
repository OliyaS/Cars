package cars.forms.forms;

import cars.entities.Car;
import framework.BaseEntity;
import framework.elements.Combobox;
import org.openqa.selenium.By;


public class SelectionCarForm extends BaseEntity  {
    private static String cmbLocator ="//select[@id='%s-dropdown']";
    private static String[] list = {"make", "model", "year"};
    private Combobox cmbSelection;


    public void fillOutForm(Car car) {
            for (String str : list) {
                cmbSelection = new Combobox(By.xpath(String.format(cmbLocator, str)));
                cmbSelection.selectByValue(car.getMap().get(str));
            }
    }



}





