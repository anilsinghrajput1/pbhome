package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class pb_home extends Base_Class {

	public pb_home(WebDriver driver) {
		super(driver);

	}

	// Elements
	@FindBy(xpath = "(//a[normalize-space()='Insurance Products'])[1]")
	WebElement term_hover;

	@FindBy(xpath = "//div[@class='ruby-col-3']//span[@itemprop='name'][normalize-space()='No Cost Term Insurance']")
	WebElement term_select;
	
	
	//Action Methods
	Actions act=new Actions(driver);
	
	public void selectterm() {
		act.moveToElement(term_hover).moveToElement(term_select).click().perform();
	}
}
