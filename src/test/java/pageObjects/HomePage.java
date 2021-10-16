package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	

	public WebDriver ldriver;

	public HomePage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By homeIcon = By.xpath("//*[@id='box-navigation']/section/ul/li[1]/a");
	By registerLink = By.xpath("//*[@id='box-session']/a[2]");
	
	
	By saleItemsLink = By.xpath("//a[@title='Sale Items']");

	public String getPageTitle() {

		return ldriver.getTitle();
	}
	
      public void clickOnHomeIcon() {
		
		
    	  ldriver.findElement(homeIcon).click();
	}
	
	
	public void clickOnRegisterLink() {
		
		 ldriver.findElement(registerLink).click();
		
	}
	
	public void clickOnSaleItems() {
		
		
		WebDriverWait wait = new WebDriverWait(ldriver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(saleItemsLink)).click();
		
	}

}
