package stepDefs;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"runners","stepDefs"},
        monochrome = true,
        plugin={"pretty", "html:target/HtmlReports/report.html",
                          "json:target/JsonReports/jsonReport.json"},
        tags = "@smoke"
        )
public class testRunner {

}
