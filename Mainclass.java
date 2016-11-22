package day4;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Mainclass 

{
	private static WebDriver driver=null;
	private static final String URL="https://www.hotels.com/";
	
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		Mainclass.driver = driver;
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public static void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","C://Selenium//geckodriver.exe");
		driver=new ChromeDriver();
		//driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get(URL);
	}
	
	
	
	@AfterClass
	public static void afterClass()
	{
		driver.manage().deleteAllCookies();
		driver.close();
		
	}
	public static String tomarrowDate()
	{
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();
		
		calendar.add(Calendar.DATE, 1);
		Date tomorrow = calendar.getTime();
		DateFormat formatter = new SimpleDateFormat("MM/dd/YY");
		String tomarrowstring = formatter.format(tomorrow);
		System.out.println(tomarrowstring);
		return tomarrowstring;
	}
	public static String afterweek()
	{
		Calendar cal = Calendar.getInstance();
		Date today1 = cal.getTime();
		cal.add(Calendar.DATE, 8);
		Date afterweek = cal.getTime();
		DateFormat formatter = new SimpleDateFormat("MM/dd/YY");
		String seven = formatter.format(afterweek);
		System.out.println(seven);
		return seven;
	}
	public static void switchToWindow(int index)
	{
		List <String> listOfWindows=new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(listOfWindows.get(index));
	}
	
	public static void switchToRootCloseCurrentWindow() 
	{
		List<String> list = new ArrayList<String>(getDriver().getWindowHandles());
		for (int i = 1; i < list.size(); i++)
		{
			getDriver().switchTo().window(list.get(i));
			getDriver().close();
		}
		getDriver().switchTo().window(list.get(0));
	
	
	
	

	}
	
	
	
	

}
