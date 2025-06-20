package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    static WebDriver driver;
    static String browserName = System.getProperty("Browser", "Chrome");
    public static void initializeDriver()
    {
        System.out.println("browserName   = "+browserName);
        ChromeOptions options=new ChromeOptions();

        options.addArguments("--headless");
        if(browserName.equalsIgnoreCase("Chrome"))
        {
            driver=new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            driver=new EdgeDriver();
        }
    }
    public static WebDriver getDriver()
    {
        return driver;
    }
}
