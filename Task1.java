package day4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import org.openqa.selenium.support.ui.Select;


public class Task1 extends Mainclass
{
	
	@Test
	public void hotelDeals() throws InterruptedException
	{
		getDriver().findElement(By.id("hdr-deals")).click();
		getDriver().findElement(By.id("qf-1q-destination")).sendKeys("London");
		Thread.sleep(3000);
		List<WebElement> orginSuggestionList = getDriver().findElements(By.xpath(".//div[@class='autosuggest-category-result']"));
	    Thread.sleep(4000);
		
		for (WebElement el : orginSuggestionList)
		{
			if (el.getText().contains("London, United Kingdom")) 
			{
				el.click();
				break;
			}
		}
		

		getDriver().findElement(By.id("qf-1q-localised-check-in")).sendKeys(tomarrowDate());
		getDriver().findElement(By.id("qf-1q-localised-check-out")).sendKeys(afterweek());
		Thread.sleep(3000);
		
		Select dropDown=new Select(getDriver().findElement(By.id("qf-1q-rooms")));
		dropDown.selectByVisibleText("2");
		Select dropDown1=new Select(getDriver().findElement(By.id("qf-1q-room-0-adults")));
		dropDown1.selectByVisibleText("2");
		Select dropDown2=new Select(getDriver().findElement(By.id("qf-1q-room-0-children")));
		dropDown2.selectByVisibleText("1");
		Select dropDown3=new Select(getDriver().findElement(By.id("qf-1q-room-0-child-0-age")));
		dropDown3.selectByVisibleText("2");
		Select dropDown4=new Select(getDriver().findElement(By.id("qf-1q-room-1-adults")));
		dropDown4.selectByVisibleText("4");
		Select dropDown5=new Select(getDriver().findElement(By.id("qf-1q-room-1-children")));
		dropDown5.selectByVisibleText("0");
		getDriver().findElement(By.cssSelector(".cta.cta-strong")).click();
		String actual=(getDriver().findElement(By.cssSelector(".summary>h1"))).getText();
		String expected="London, England, United Kingdom";
        Assert.assertEquals(expected, actual);
		
	}



	}
