package com.company.hooks;

import com.company.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void before(Scenario scenario) {
        System.out.println(scenario.getName());
        System.out.println(scenario.getSourceTagNames());
    }

    @Before
    public void before() {
        Driver.initDriver();
    }

    @After
    public void tearDown() {

    }
}
