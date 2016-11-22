package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Task3 extends Mainclass
{
	@Test
	public void price() throws InterruptedException
	{
	//getDriver().findElement(By.xpath(".//*[@id='filter-price']/div[2]/div/div[2]/div[3]")).click();
		
        WebElement source = getDriver().findElement(By.xpath(".//*[@id='filter-price']/div[2]/div/div[2]/div[3]"));
        WebElement target = getDriver().findElement(By.xpath(".//*[@id='filter-price']/div[2]/div/div[2]/div[2]"));
        Actions action = new Actions(getDriver());
        action.dragAndDropBy(source,-92,0).release().build().perform();
        String actual = getDriver().findElement(By.xpath(".//*[@id='listings']/ol/li[1]/article/div/div[3]/div[1]/a/span/ins")).getText();
        String expected = "first hotel price is less then 200";
        Assert.assertEquals(actual, expected);
        Thread.sleep(10000);
	}

		
		
		
	}


