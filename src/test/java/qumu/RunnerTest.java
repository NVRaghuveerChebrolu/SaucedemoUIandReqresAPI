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

//	private TestNGCucumberRunner testNGCucumberRunner;
//
//    @BeforeClass(alwaysRun = true)
//    public void setUpClass() {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
//
//    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
//    public void feature(CucumberFeatureWrapper cucumberFeature) {
//        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//    }
//
//    @DataProvider
//    public Object[][] features() {
//        return TestNGCucumberRunner.provideFeatures();
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() {
//        testNGCucumberRunner.finish();
//    }


}
