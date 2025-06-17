package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "C:\\Users\\10821737\\practice\\cucmberAutoProject\\src\\test\\java\\feature\\login.feature",
        glue = {"stepDefinitions","hooks"},
        monochrome = true
)

public class TestRunner {
}
