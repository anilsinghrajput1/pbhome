package Test_baseclass;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class Test_base_class {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;

	@BeforeClass
	@Parameters("browser")
	public void setup(String Br) {
		
		rb=ResourceBundle.getBundle("Config");
		logger=LogManager.getLogger(this.getClass());
		if(Br.equals("chrome")) {
		driver = new ChromeDriver();
		}
		else if(Br.equals("edge")) {
			driver=new EdgeDriver();
		}
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appurl"));
		driver.manage().window().maximize();
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

	public String randomString() {
		String randomString = RandomStringUtils.randomAlphabetic(5);
		return randomString;
	}

	public String randomnumber() {
		String randomString2 = RandomStringUtils.randomNumeric(10);
		return randomString2;
	}

	public String randomnumberString() {
		String nu = RandomStringUtils.randomNumeric(3);
		String St = RandomStringUtils.randomAlphabetic(4);

		return (St + "@" + nu);
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	

}
