package Test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Test_baseclass.Test_base_class;
import pageObject.input_details;
import pageObject.pb_home;

public class TC_01_term extends Test_base_class {

	
	@Test
	public void setup() throws InterruptedException {
		pb_home ph= new pb_home(driver);
		ph.selectterm();
		
		
		
		input_details id=new input_details(driver);
try {
			id.popupshow();
		}
catch(Exception ex) {
	
}
		id.setusername("Test test");
		id.setDob("09091999");
		id.setMobile("8521762380");
		id.submit();
		
		
		Thread.sleep(5000);
		String txt=id.text();
		
		Assert.assertEquals(txt, "Welcome back, Test!");
		
	}
}
