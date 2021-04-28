package com.company.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"pretty"},
        glue = {"com/company/stepDefinitions", "com/company/runners", "com/company/hooks"},
        tags = "@test",
        features = "src/test/resources/features"
)
public class RunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        System.out.println("<<<<<Scenarios count:" + super.scenarios().length);
        return super.scenarios();
    }

}
