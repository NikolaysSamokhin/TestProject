package com.company.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

@Log4j
public class Hooks  {
    public static MutablePicoContainer pico = new DefaultPicoContainer();

    @Before
    public void before(Scenario scenario) {
        log.info(scenario.getName());
        log.info(scenario.getSourceTagNames());
    }

    @After
    public void tearDown() {

    }
}
