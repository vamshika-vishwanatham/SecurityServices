package factory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass{

	public static WebDriver driver;

	public BaseClass(WebDriver driver2) {
		driver2 = BrowserInvoke();
		//PageFactory.initElements(driver, this);
	}

	public static WebDriver BrowserInvoke(){
		ResourceBundle rb=ResourceBundle.getBundle("Config");
		if (driver == null) {
		String setPropertyText1 = rb.getString("set_Property1"); 
		String setPropertyText2 =rb.getString("set_Property2");
		System.setProperty(setPropertyText1,setPropertyText2);
		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		}
		return driver;
	}


	public static WebDriver getDriver() {
		return driver;
	}
	public void windowHandle() {

		Set<String> windows = driver.getWindowHandles();
		for (String ServiceDeskPortal : windows) {
			driver.switchTo().window(ServiceDeskPortal);
		}
	}
	

	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver; 
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		try 
		{
			FileUtils.copyFile(source, new File(destination)); 
		} 
		catch (Exception e) 
		{ 
			e.getMessage(); 
		} 
		return destination;
	}
}
