package framework.elements;

import framework.BaseEntity;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class BaseElement extends BaseEntity {

    private By locator;
    private WebElement element;
    private List<String> listOfContent = new ArrayList<>();


    public BaseElement(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return this.locator;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public List<String> getListOfContent() {
        for (WebElement element : getElements(this.getLocator())) {
            listOfContent.add(element.getText());
        }
        return listOfContent;
    }

    public String getText() {
        element = getElement(this.getLocator());
        if (element.isDisplayed())
            return element.getText();
        else return "could not return text";
    }

    public void click() {
        element = getElement(this.getLocator());
        if (element.isEnabled())
            element.click();
    }


    public void clickAndWait() {
        element = getElement(this.getLocator());
        if (element.isEnabled())
            element.click();
        waitForJSandJQueryToLoad();
    }

    public boolean assertIsVisible() {
        element = getElement(this.getLocator());
        return element.isDisplayed();
    }

    public boolean isElementVisible() {
        try {
            element = getElement(this.getLocator());
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(configProperties.getProperty("timeOut")));

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}
