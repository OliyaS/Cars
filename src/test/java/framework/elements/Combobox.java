package framework.elements;

import framework.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class Combobox extends BaseElement {

    private Select selection;
    private String type;

    public Combobox(By locator) {
        super(locator);
        type = "combobox";
    }

    public String getType() {
        return this.type;
    }


    public String selectByRandomId() {
        selection = new Select(getElement(this.getLocator()));
        selection.selectByIndex(CommonFunction.getRandomIndex(selection.getOptions().size(),1));
        return  selection.getFirstSelectedOption().getText();
    }

    public void selectByValue(String text) {
        selection = new Select(getElement((this.getLocator())));
        selection.selectByVisibleText(text);
    }

}
