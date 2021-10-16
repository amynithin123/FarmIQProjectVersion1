package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class RegistrationPage {
	
	public WebDriver ldriver;

	public RegistrationPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By firstNameField = By.xpath("//input[@id='first_name']");
	By lastNameField = By.xpath("//input[@id='last_name']");
	By emailField = By.xpath("//input[@id='email']");
	By phoneField = By.xpath("//input[@id='phone']");
	By pwdField = By.xpath("//input[@id='password']");
	By confirmPwdField = By.xpath("//input[@id='passconf']");
	By agreeTermsCheckBox = By.xpath("//input[@id='terms']");
	By registerButton = By.xpath("//input[@id='register_submit']");
	
	By firstNameErrorMessage = By.xpath("//small[@id='first_name-error']");
	By lastNameErrorMessage = By.xpath("//small[@id='last_name-error']");
	By emailErrorMessage = By.xpath("//small[@id='email-error']");
	By phoneErrorMessage = By.xpath("//small[@id='phone-error']");
	By pwdErrorMessage = By.xpath("//small[@id='password-error']");
	By confirmPwdErrorMessage = By.xpath("//small[@id='passconf-error']");
	By agreeToTermsErrorMessage = By.xpath("//input[@id='terms_agree-error']");
	
	
	
	public String getPageTitle() {

		return ldriver.getTitle();
	}
	
	public void setFirstName(String f_name) {

		ldriver.findElement(firstNameField).sendKeys(f_name);
	}

	public void setLastName(String l_name) {

		ldriver.findElement(lastNameField).sendKeys(l_name);
	}
	
	public void setEmail(String email) {

		ldriver.findElement(emailField).sendKeys(email);
	}
	
	public void setPhone(String phone) {

		ldriver.findElement(phoneField).sendKeys(phone);
	}
	
	public void setPassword(String pwd) {

		ldriver.findElement(pwdField).sendKeys(pwd);
	}
	
	public void setConfirmPassword(String confirm_pwd) {

		ldriver.findElement(confirmPwdField).sendKeys(confirm_pwd);
	}
	
	public void setAgreeToTerms() {

		ldriver.findElement(agreeTermsCheckBox).click();
	}
	
	public void clickRegister() {

		try {
			ldriver.findElement(registerButton).click();
			
		} catch (Exception e) {
			
			System.out.println("CATPCHA Identified. Not feasible for automation");
		}
	}
	
	
	

}
