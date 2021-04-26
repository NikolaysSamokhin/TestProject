package com.company.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"pretty"},
        glue = {"com/company/stepDefinitions", "com/company/runners", "com/company/hooks"},
        tags = "@test",
        features = "src/test/resources/features"
)
@Log4j
public class RunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        log.info("<<<<<Scenarios count:" + super.scenarios().length);
        return super.scenarios();
    }

}
