package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
In this class we will be able to create "pre" and "post" conditions for ALL the SCENARIOS and even STEPS
 */
public class Hooks {

    //import the @Before coming from io.cucumber.java
    @Before
    public void setupMethod() {
        System.out.println("---> @Before: RUNNING BEFORE EACH SCENARIO");
    }

    @After
    public void teardownMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        System.out.println("---> @After: RUNNING AFTER EACH SCENARIO");

        BrowserUtils.sleep(2);
        Driver.closeDriver();

    }

    //@BeforeStep
    public void setUpStep() {
        System.out.println("------> @BeforeStep: RUNNING BEFORE EACH STEP!");
    }

    //@AfterStep
    public void teardownStep() {
        System.out.println("-----> @AfterStep: RUNNING AFTER EACH STEP!");
    }


}
