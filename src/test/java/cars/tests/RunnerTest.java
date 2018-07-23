package cars.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions
        (features = "src/test/java/cars/features/",
     glue = "cars.steps")
public class RunnerTest extends AbstractTestNGCucumberTests{
}
