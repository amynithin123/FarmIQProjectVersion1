package pageObjects;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {

	public WebDriver ldriver;

	public CheckOutPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By checkOutQuantity = By.xpath("//input[@class='quantity checkout'][@value='1']");
	By continueShoppingButton = By.xpath("//a[contains(text(),'Continue Shopping')]");
	By priceItem1 = By.xpath("//*[@id='content_checkout_medium_up']/table/tbody/tr[1]/td[6]");
	By priceItem2 = By.xpath("//*[@id='content_checkout_medium_up']/table/tbody/tr[2]/td[6]");
	By grantTotalItem = By.xpath("//*[@id='content_checkout_medium_up']/table/tfoot/tr[4]/td[3]");
	By actualSubTotal = By.xpath("//*[@id='content_checkout_medium_up']/table/tfoot/tr[1]/td[3]");

	public String getPageTitle() {

		return ldriver.getTitle();
	}

	public void verifyItemsInBasket() {

		String quantity = ldriver.findElement(checkOutQuantity).getAttribute("value").toString();
		System.out.println("The Quantity of single Sale Item added to the basket: " + quantity);

	}

	public void clickContinueShoppingButton() {

		ldriver.findElement(continueShoppingButton).click();

	}

	public void verifyGrantTotalInBasket() {

		
		
		WebDriverWait wait = new WebDriverWait(ldriver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(priceItem1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(priceItem2));
		
		DecimalFormat df = new DecimalFormat("#.##");
		String itemPrice1 = ldriver.findElement(priceItem1).getText().substring(1).toString();

		System.out.println("The price of first Item before GST is: " + itemPrice1);

		String itemPrice2 = ldriver.findElement(priceItem2).getText().substring(1);
		System.out.println("The price of second Item before GST is: " + itemPrice2);

		double p1 = Double.parseDouble(itemPrice1);
		double p2 = Double.parseDouble(itemPrice2);
		double expected_subtotal = p1 + p2;

		System.out.println("Expected Sub total for the items in the basket before GST : " + expected_subtotal);

		String a_subtotal = ldriver.findElement(actualSubTotal).getText().substring(1);
		double actual_subtotal = Double.parseDouble(a_subtotal);

		System.out.println("Actual Sub total for the items in the basket before GST : " + actual_subtotal);

		if (expected_subtotal == actual_subtotal) {

			System.out.println("The expected and actual subtotal before GST matches");
		} else {

			System.out.println("The expected and actual subtotal before GST mismatch");
		}

		double p4 = 0.2;

		double p5 = p1 * p4;
		double p6 = p2 * p4;
		double gst = p5 + p6;

		String expected_gst = df.format(gst);

		System.out.println("GST for the items in the basket: " + expected_gst);
		String expectedgrantTotal = df.format(expected_subtotal + gst);
		System.out.println("Grant total for the items in the basket after GST is: " + expectedgrantTotal);

		String actualgrantTotal = df.format(actual_subtotal + gst);
		System.out.println("Grant total for the items in the basket after GST is: " + actualgrantTotal);

		if (actualgrantTotal == expectedgrantTotal) {

			System.out.println("Expected and Actual grant total matches after GST");
		} else {

			System.out.println("Expected and Actual grant total mismatch after GST");

		}

	}

}
