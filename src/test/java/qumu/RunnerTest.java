package qumu;


import org.junit.runner.RunWith;
import org.testng.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class) 
@CucumberOptions(
        features = "src/test/java/features/UI-Test.feature",
        glue = {"qumu"},
        tags = "@UI",
        plugin = {
        		"pretty", "html:target/cucumber-reports.html"
        })
public class RunnerTest extends AbstractTestNGCucumberTests {


}
