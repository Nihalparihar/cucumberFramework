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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(50000);
        driver.get("https://tutorialsninja.com/demo/");
    }
    @After
    public  void tearDown()
    {
        driver.quit();
    }
}
