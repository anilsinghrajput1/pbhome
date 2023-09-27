package testCases;


import org.testng.Assert;

import org.testng.annotations.Test;

import Test_baseclass.Test_base_class;
import pageObject.input_details;
import pageObject.pb_home;

public class TC_01 extends Test_base_class {

	@Test
	void userinput() throws InterruptedException {
		
		logger.info("Starting Tc_01");
		logger.debug("test debug logs");

		pb_home ph = new pb_home(driver);
		ph.selectterm();

		input_details id = new input_details(driver);
		try {

			id.popupshow();
		} catch (Exception Ex) {
			Ex.getMessage();
		}
		logger.info("Input page");
		id.setusername("Test test");
		id.setDob("01011999");
		id.setMobile("9757985478");
		id.submit();
		logger.info("user registered");
		
		Thread.sleep(5000);
		String txt=id.text();		
		Assert.assertEquals(txt, "Please choose your occupation type");
		
		logger.info("login pass");
	}
	
}
