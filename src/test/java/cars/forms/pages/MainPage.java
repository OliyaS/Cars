package cars.forms.pages;

import cars.forms.menu.MainMenu;
import framework.BasePage;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    public MainMenu mainMenu = new MainMenu();

    public MainPage() {
        super(By.xpath("//form[@autocomplete='off']"), "Main Page");
    }
}
