package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.SignUpPage;
import Resources.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUp {
	
	WebDriver driver = DriverManager.getDriver();
    SignUpPage signUpPage = new SignUpPage(driver);
    
    @Given("I am on the sign-up page")
    public void i_am_on_the_sign_up_page(){
    	driver.get("https://magento.softwaretestingboard.com/");
    	driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).click();
    }
	
    @When("I enter valid details {string} {string} {string} {string} {string}")
    public void i_enter_valid_details(String firstName, String lastName, String email, String password, String confirmPassword) {
    	signUpPage.enterFirstName(firstName);
    	signUpPage.enterLastName(lastName);
    	signUpPage.enterEmail(email);
    	signUpPage.enterPassword(password);
    	signUpPage.enterConfirmPassword(confirmPassword);
     }
    
    @And("I click on Create an Account")
    public void i_click_on_create_account() {
    	signUpPage.clickCreateAccount();
    }
    
    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
    	Assert.assertEquals("Thank you for registering with Main Website Store.", signUpPage.getSuccessMessage());
    	driver.quit();
    }
    
    @When("I enter same email details {string} {string} {string} {string} {string}")
    public void i_enter_same_email_details(String firstName, String lastName, String email, String password, String confirmPassword) {
    	signUpPage.enterFirstName(firstName);
    	signUpPage.enterLastName(lastName);
    	signUpPage.enterEmail(email);
    	signUpPage.enterPassword(password);
    	signUpPage.enterConfirmPassword(confirmPassword);
    }
    
    @Then("I should see an error message for existing email")
    public void i_should_see_an_error_message_for_existing_email() {
    	Assert.assertEquals("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.", signUpPage.getSameEmailErrorMessage());
    	driver.quit();
    }
    
	
}
