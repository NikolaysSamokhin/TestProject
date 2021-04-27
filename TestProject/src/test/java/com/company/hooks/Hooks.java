package com.company.hooks;

import com.codeborne.selenide.Selenide;
import com.company.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

@Log4j
public class Hooks extends Selenide {
    public static MutablePicoContainer pico = new DefaultPicoContainer();

    @Before
    public void before(Scenario scenario) {
        log.info(scenario.getName());
        log.info(scenario.getSourceTagNames());
    }

    @Before
    public void before() {
        Driver.initDriver();
    }

    @After
    public void tearDown() {

    }
}
