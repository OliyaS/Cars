package cars.forms.menu;

import org.openqa.selenium.By;
import framework.elements.Label;
import framework.BaseEntity;


public class MainMenu extends BaseEntity  {
    public enum Menu {
        CARS_FOR_SALE("Cars for Sale"),
        SELL_YOUR_CAR("Sell Your Car"),
        SERVICE_REPAIR("Service & Repair"),
        RESEARCH("Research"),
        VIDEOS_REVIEWS("Videos & Reviews");

        private String section;

        Menu(String section) {
            this.section = section;
        }
    }

    private static String menuItemLocator = "//header/nav/ul/li[a[contains(text(), '%s')]]";
    private Label lblLogo = new Label(By.xpath("//a[@data-linkname='header-home']"));
    private Label lblSection;

    public void navigateMenu(Menu category) {
        lblSection = new Label(By.xpath(String.format(menuItemLocator, category.section)));
        lblSection.clickAndWait();
    }

   public void goToMainPage(){
        lblLogo.click();
   }
}





