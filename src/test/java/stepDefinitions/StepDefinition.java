package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import pageObjects.SaleItemsPage;

public class StepDefinition extends BaseClass {

	@Before
	public void setup() throws IOException {

		logger = logger.getLogger("FarmIQProjectVersion1");
		PropertyConfigurator.configure("log4j.properties");

		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);

		String br = configProp.getProperty("browser");

		if (br.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
		} else if (br.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
		} else if (br.equals("ie")) {

			WebDriverManager.iedriver().setup();
		}

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		logger.info("***Launching Browser***");

	}

	// userRegistration.feature step definitions

	@Given("user launches Chrome browser")
	public void user_launches_chrome_browser() {

		hp = new HomePage(driver);

	}

	@When("User navigates to {string} the Home page")
	public void user_navigates_to_the_home_page(String url) {

		logger.info("***Opening URL***");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@And("User clicks on Register link in the home page")
	public void user_clicks_on_register_link_in_the_home_page() {

		logger.info("***Clicking on Regsiter link in the Home page***");
		hp.clickOnRegisterLink();
		driver.manage().window().maximize();
	}

	@And("Clicks on Register button")
	public void clicks_on_register_button() {

		logger.info("***Clicking on on Regsiter button on Registration Page***");
		rp = new RegistrationPage(driver);
		rp.clickRegister();

	}

	@Then("Validate errors :{string}{string}{string}{string}{string}{string}{string}")
	public void validate_errors(String f_name_error, String l_name_error, String email_error, String phone_error,
			String pwd_error, String c_pwd_error, String agree_term_error) throws InterruptedException {

		Thread.sleep(2000);
		logger.info("***Validating invalid login leaving mandatory fields blank***");
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(f_name_error));
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(l_name_error));
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(email_error));
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(phone_error));
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(pwd_error));
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(c_pwd_error));
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(agree_term_error));
	}

	@When("User enters {string} in the First Name field")
	public void user_enters_in_the_first_name_field(String f_name) {

		logger.info("***Entering First Name***");
		rp.setFirstName(f_name);

	}

	@And("User enters {string} in the Last Name field")
	public void user_enters_in_the_last_name_field(String l_name) {

		logger.info("***Entering Last Name***");
		rp.setLastName(l_name);

	}

	@And("User enters email in the Email Field")
	public void user_enters_email_in_the_email_field() {

		logger.info("***Entering random email***");
		String email = randomString() + "@gmail.com";

		rp.setEmail(email);
	}

	@And("User enters {string} in the Phone Field")
	public void user_enters_in_the_phone_field(String phone) {

		logger.info("***Entering phone number***");
		rp.setPhone(phone);
	}

	@And("User enters password in the Password field and confirm password in the Confirm Password field")
	public void user_enters_password_in_the_password_field_and_confirm_password_in_the_confirm_password_field() {

		logger.info("***Entering random password and confirming the passsword entered***");
		String pwd = randomString() + "Abc123!";
		rp.setPassword(pwd);
		rp.setConfirmPassword(pwd);
	}

	@And("User agrees to the terms and conditions")
	public void user_agrees_to_the_terms_and_conditions() {

		logger.info("***Checking the agree to terms check box***");
		rp.setAgreeToTerms();

	}

	@And("User clicks on Register button")
	public void user_clicks_on_register_button() {

		logger.info("***Clicking on Regsiter link***");
		rp.clickRegister();

	}

	@Then("Validate errors are gone: {string}{string}{string}{string}{string}{string}{string}")
	public void validate_errors_are_gone(String f_name_error, String l_name_error, String email_error,
			String phone_error, String pwd_error, String c_pwd_error, String agree_term_error) {

		logger.info("***Validating successful Registartion***");
		Assert.assertFalse(driver.findElement(By.tagName("body")).getText().contains(f_name_error));
		Assert.assertFalse(driver.findElement(By.tagName("body")).getText().contains(l_name_error));
		Assert.assertFalse(driver.findElement(By.tagName("body")).getText().contains(email_error));
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(phone_error));
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(pwd_error));
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(c_pwd_error));
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(agree_term_error));

	}

	// addItemsToBasket.feature step definitions

	@And("User clicks on Sale Items in the home page")
	public void user_clicks_on_sale_items_in_the_home_page() throws InterruptedException {

		logger.info("***Clicking on Sale Icon***");
		driver.manage().window().maximize();

		hp.clickOnSaleItems();

	}

	@And("Clicks on Add to Basket for the first Item")
	public void clicks_on_add_to_basket_for_the_first_item() {

		logger.info("***Clicking on Add To Basket Button***");
		sp = new SaleItemsPage(driver);

		sp.addToBasketBasedonIndex(1);

	}

	@Then("Validate errors :{string}")
	public void validate_errors(String add_to_basket_error) throws InterruptedException {

		logger.info("***Validating add to basket error on leaving selection drop down blank***");
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(add_to_basket_error));

	}

	@When("User selects {string} from the drop down")
	public void user_selects_from_the_drop_down(String installation_service) {

		logger.info("***Selecting installation service from the drop down***");
		sp.selectInstallationService(installation_service);

	}

	@And("clicks Add to Basket")
	public void clicks_add_to_basket() {

		sp.clickAddToBasket();

	}

	@And("clicks on cartIcon")
	public void clicks_on_cart_icon() {

		logger.info("***Clicking on Cart Icon***");

		sp.clickOnCartIcon();

	}

	@And("clicks on View Basket in the Cart menu")
	public void clicks_on_view_basket_in_the_cart_menu() throws InterruptedException {

		logger.info("***Clicking on View Basket Button***");
		sp.clickOnViewBasketButton();

	}

	@Then("validate the no of items added to the basket")
	public void validate_the_no_of_items_added_to_the_basket() {

		logger.info("***Clicking on Add to Basket Button***");
		cop = new CheckOutPage(driver);
		cop.verifyItemsInBasket();
	}

	@When("User clicks on Continue Shopping button")
	public void user_clicks_on_continue_shopping_button() {

		logger.info("***Clicking on Continue Shopping Button***");
		cop.clickContinueShoppingButton();
	}

	@When("User selects {string} colour from the drop down")
	public void user_selects_colour_from_the_drop_down(String colour) {

		logger.info("***Selecting Colour of the Item from the drop down***");

		sp.selectColur(colour);

	}

	@And("Clicks on Add to Basket for the second Item")
	public void clicks_on_add_to_basket_for_the_second_item() {

		logger.info("***Clicking on Asdd to Basket for the second Item***");

		sp = new SaleItemsPage(driver);
		sp.addToBasketBasedonIndex(2);
	}

	@Then("validate grant total of items in the basket")
	public void validate_grant_total_of_items_in_the_basket() {

		logger.info("***Validating Grant Total of the Items in the Basket after GST***");
		cop.verifyGrantTotalInBasket();
	}

}
