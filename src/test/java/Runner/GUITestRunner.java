package Runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue={"StepDefinition"},monochrome=true,
plugin={"pretty","html:target/GuiHtmlReports/htmlReport.html"},
tags="@GuiTests",
publish = true)
public class GUITestRunner {
}