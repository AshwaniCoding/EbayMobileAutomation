package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.CucumberReportManager;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import io.cucumber.java.*;


public class Hooks {
    @Before
    public void setUp(Scenario scenario) {
        CucumberReportManager.initReporter(scenario);
        ExtentReportManager.createTest(scenario.getName());
        DriverManager.createDriver();
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            CucumberReportManager.attachScreenshot();
            ExtentReportManager.attachScreenshot();
            ExtentReportManager.getTest().fail("Test Failed : " + scenario.getName());
        } else {
            ExtentReportManager.getTest().pass("Test Passed : " + scenario.getName());
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        DriverManager.getDriver().quit();
    }

    @BeforeAll
    public static void setUpAll() {
        ConfigReader.intiConfig();
        ExtentReportManager.initReporter();
    }

    @AfterAll
    public static void cleanUpAll() {
        ExtentReportManager.flush();
    }

}
