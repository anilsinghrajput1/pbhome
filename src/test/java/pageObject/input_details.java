package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class input_details extends Base_Class {

	public input_details(WebDriver driver) {
		super(driver);
	}

	
	// Elements
	@FindBy(id = "termName")
	WebElement username;

	@FindBy(id = "dob")
	WebElement UserDob;

	@FindBy(id = "termMobile")
	WebElement UserMobile;

	@FindBy(id = "btnSubmitTerm")
	WebElement Submituserdetails;

	@FindBy(xpath = "//a[@class='close ng-star-inserted']")
	WebElement Popup;
	
	@FindBy(xpath="//h3[normalize-space()='Please choose your occupation type']")
	WebElement msg;

	
	// Action
	public void setusername(String name) {
		username.sendKeys(name);
	}

	public void setDob(String Dob) {
		UserDob.sendKeys(Dob);
	}

	public void setMobile(String Mob) {
		UserMobile.sendKeys(Mob);
	}

	public void submit() {
		Submituserdetails.click();
	}

	public void popupshow() {
		if (Popup.isDisplayed()) {
			Popup.click();
		}
	}	

	public String text() {
		try {

			return (msg.getText());
		} catch (Exception Ex) {
			return (Ex.getMessage());
		}

	}

}
