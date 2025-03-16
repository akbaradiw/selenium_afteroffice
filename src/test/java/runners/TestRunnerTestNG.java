package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",    // Lokasi file feature
    glue = {"stepdefinitions","hook"},                    // Package step definitions
    plugin = {
        "pretty",                                // Output di console lebih rapi
        "html:target/cucumber-report.html",     // Laporan HTML
        "json:target/cucumber-report.json",     // Laporan JSON
        "junit:target/cucumber-report.xml"      // Laporan XML
    }
)

public class TestRunnerTestNG extends AbstractTestNGCucumberTests {

}
