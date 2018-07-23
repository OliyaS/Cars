package framework;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseEntity {
    protected static WebDriver driver;
    protected static PropertyReader configProperties;

    public void setup() {
        initProperties();
        driver = BrowserFactory.initDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(configProperties.getProperty("timeOut")), TimeUnit.SECONDS);

        driver.get(configProperties.getProperty("url"));
    }

    public static void initProperties() {
        configProperties = new PropertyReader("config");
    }

    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

}