package cars.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.BaseEntity;

public class Hooks {
    private BaseEntity baseEntity;

    @Before
    public void beforeScenario() {
        baseEntity = new BaseEntity();
        baseEntity.setup();
    }

    @After
    public void clearData() {
        baseEntity.tearDown();
    }
}

