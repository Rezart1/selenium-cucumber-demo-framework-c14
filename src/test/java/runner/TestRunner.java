package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // do the configurations here
        // first we will need to teach out runner where are the features located
        // we will need to provide the path for feature files location
        // the path starts from src
        features = "src/test/resources/features",
        // next we will need to connect now to the step definitions that we have
        // for this we will use "glue" keyword
        // in the glue we will need to provide the package name
        // the package will start in java directory
        glue = "step_definitions",
        // dryRun will check if you have all the steps defined in your feature files
        // if set to true it will skip the test and just check if all steps are defined
        // if set to false it will simply run the scripts
        dryRun = false
)
public class TestRunner {
    // there is no code in the class itself
}
