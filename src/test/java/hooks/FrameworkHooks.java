package hooks;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

public class FrameworkHooks {
    WebDriver driver;
    @Before
    public void setup() throws InterruptedException {
        DriverFactory.initializeDriver();
        driver=DriverFactory.getDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        driver.get("https://tutorialsninja.com/demo/");
        Thread.sleep(5000);
    }
    @After
    public  void tearDown()
    {
        driver.quit();
    }
}
