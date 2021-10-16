package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaleItemsPage {

	public WebDriver ldriver;

	public SaleItemsPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By installationServiceDropDown = By.xpath("//select[@id='option_1']");
	By colourDropDown = By.xpath("//select[@id='option_2']");
	By saleItemsList = By.xpath("//ul[@class='small-block-grid-1 product_list']");
	By addToBasketButton = By.xpath("//*[contains(text(),'Add to Basket')]");
	By cartIcon = By.xpath("//a[@id='basket-summary']");
	By viewBasketButton = By.xpath("//*[@id='basket-detail']/div[2]/div/div[2]/a");

	public String getPageTitle() {

		return ldriver.getTitle();
	}

	public void clickAddToBasket() {

		ldriver.findElement(addToBasketButton).click();
	}

	public void selectInstallationService(String install_service) {

		Select select = new Select(ldriver.findElement(installationServiceDropDown));
		select.selectByVisibleText(install_service);

	}

	public void selectColur(String colour) {

		Select select = new Select(ldriver.findElement(colourDropDown));
		select.selectByVisibleText(colour);

	}

	public void clickOnCartIcon() {

		ldriver.findElement(cartIcon).click();
	}

	public void clickOnViewBasketButton() {

		WebDriverWait wait = new WebDriverWait(ldriver, 20);

		wait.until(ExpectedConditions.presenceOfElementLocated(viewBasketButton)).click();

	}

	public void addToBasketBasedonIndex(int index) {

		ldriver.findElement(By.xpath("//*[@id='ccScroll']/ul/li[" + index + "]/form/div[1]/div[3]/div/div[2]/button"))
				.click();

	}

}
