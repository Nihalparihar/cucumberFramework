package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    @Before
    public void setup()
    {
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.get("https://tutorialsninja.com/demo/");
    }
    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
      driver.findElement(By.xpath("//span[text()='My Account']")).click();
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

    }

    @When("User enters invalid email address {string} into the email field")
    public void user_enters_invalid_email_address_into_the_email_field(String string) {

    }

    @When("User enters invalid password {string} into password field")
    public void user_enters_invalid_password_into_password_field(String string) {

    }

    @Then("User should get proper warning message about invalid credintials")
    public void user_should_get_proper_warning_message_about_invalid_credintials() {

    }

    @When("User does not enter email into the email field")
    public void user_does_not_enter_email_into_the_email_field() {

    }

    @When("User does not enter password into password field")
    public void user_does_not_enter_password_into_password_field() {

    }
}
