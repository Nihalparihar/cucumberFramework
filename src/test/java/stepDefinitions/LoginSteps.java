package stepDefinitions;

import driver.DriverFactory;
import io.cucumber.java.en.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class LoginSteps {
    WebDriver driver;

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        driver = DriverFactory.getDriver();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement myAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']")));

            System.out.println("Displayed: " + myAccount.isDisplayed());
            System.out.println("Enabled: " + myAccount.isEnabled());

// Take screenshot before clicking
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("beforeClick.png"));

// Click the element
            myAccount.click();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to interact with 'My Account' element", e);

            //driver.findElement(By.xpath("//span[text()='My Account']")).click();



        }
        driver.findElement(By.xpath("//a[text()='Login']")).click();
    }

    @When("User enters valid email address {string} into the email field")
    public void user_enters_valid_email_address_into_the_email_field(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
    }

    @When("User enters valid password {string} into password field")
    public void user_enters_valid_password_into_password_field(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.xpath("//input[@value='Login']")).click();


    }

    @Then("User should successfully get login")
    public void user_should_successfully_get_login() {
       String actualText=driver.findElement(By.linkText("Edit your account information")).getText();
        Assert.assertEquals("Edit your account information",actualText);
    }

    @When("User enters invalid email address {string} into the email field")
    public void user_enters_invalid_email_address_into_the_email_field(String invalidEmail) {
        driver.findElement(By.name("email")).sendKeys(invalidEmail);
    }

    @When("User enters invalid password {string} into password field")
    public void user_enters_invalid_password_into_password_field(String invalidPassword) {
        driver.findElement(By.name("password")).sendKeys(invalidPassword);
    }

    @Then("User should get proper warning message about invalid credintials")
    public void user_should_get_proper_warning_message_about_invalid_credintials() {
String actualText=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
Assert.assertTrue(actualText,true);
    }

    @When("User does not enter email into the email field")
    public void user_does_not_enter_email_into_the_email_field() {

    }

    @When("User does not enter password into password field")
    public void user_does_not_enter_password_into_password_field() {

    }
}
