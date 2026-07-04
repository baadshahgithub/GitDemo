package Cucumber.Option;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",glue = {"Stepdefination", "resources"},tags = "@Deleteplace")
public class TestRunner {
	// tags = "@Deleteplace"
}
