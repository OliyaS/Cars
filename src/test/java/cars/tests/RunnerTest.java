package cars.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions
        (features = "src/test/java/cars/features/",format = {"pretty", "html:target/cucumber","json:target/cucumber.json" },
     glue = "cars.steps")
public class RunnerTest extends AbstractTestNGCucumberTests{
}
