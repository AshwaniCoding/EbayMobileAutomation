package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.automation.steps",
        plugin = {"json:target/Android/cucumber.json", "html:CucumberReports/Android/basic_android_report.html"},
        tags = "@product-page"
)
public class TestRunner {
}
