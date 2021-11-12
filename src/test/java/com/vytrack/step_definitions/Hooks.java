package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp() {

        System.out.println("\tThis is coming from BEFORE");

    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){

            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "screenshot");
        }
        Driver.closeDriver();
        //System.out.println("\tThis is coming from AFTER");


    }

    @Before("@db") //db is not keyword,any name can be ok
    public void setUpdb() {

        System.out.println("\tconnecting to detabase...");

    }

    @After("@db")  //we don't need to put db to CukesRunner, because db is not for the scenario to run, db is
    //gonna determine where your customhooks get trigger(not clear )
    public void closeDownDb() {
        System.out.println("\tdisconnecting to database...");
    }
}