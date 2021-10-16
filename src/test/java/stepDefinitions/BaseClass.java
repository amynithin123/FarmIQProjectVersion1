package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import pageObjects.SaleItemsPage;

public class BaseClass {

	public WebDriver driver;
	public HomePage hp;
	public RegistrationPage rp;
	public SaleItemsPage sp;
	public CheckOutPage cop;
	public static Logger logger;
	public Properties configProp;

	// Created for generating random string for unique email and password
	public static String randomString() {

		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

}
