package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",    // Lokasi file feature
    glue = "stepdefinitions",                    // Package step definitions
    monochrome = true,                           // Output lebih bersih
    plugin = {
        "pretty",                                // Output di console lebih rapi
        "html:target/cucumber-report.html",     // Laporan HTML
        "json:target/cucumber-report.json",     // Laporan JSON
        "junit:target/cucumber-report.xml"      // Laporan XML
    },
    tags = "@smoke"   // Hanya menjalankan skenario dengan tag @smoke (opsional)
)

public class TestRunner {
}
