package Test_cases;

import org.testng.annotations.Test;

import Test_baseclass.Test_base_class;
import pageObject.input_details;
import pageObject.pb_home;

public class TC_01_term extends Test_base_class {

	
	@Test
	public void setup() {
		pb_home ph= new pb_home(driver);
		ph.selectterm();
		
		
		
		input_details id=new input_details(driver);
try {
			id.popupshow();
		}
catch(Exception ex) {
	
}
		id.setusername("Test test");
		id.setDob("");
		id.setMobile("");
		id.submit();
		
	}
}
