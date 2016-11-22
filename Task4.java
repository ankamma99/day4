package day4;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Task4 extends Mainclass
{
	@Test
	public void feedback() throws InterruptedException
	{
		getDriver().findElement(By.id("hdr-feedback")).click();
		Thread.sleep(3000);
		switchToWindow(1);
		getDriver().manage().window().maximize();
		getDriver().findElement(By.xpath(".//*[@id='rater_buttons']/div[2]/label")).click();
		Thread.sleep(3000);
		getDriver().findElement(By.xpath(".//*[@id='cdu_content']/div[2]/label")).click();
		getDriver().findElement(By.xpath(".//*[@id='cdu_design']/div[3]/label")).click();
		getDriver().findElement(By.xpath(".//*[@id='cdu_usability']/div[4]/label")).click();
		Thread.sleep(4000);
		getDriver().findElement(By.xpath(".//*[@id='custom_questions']/div[1]/div[3]/fieldset/div[1]/label")).click();
		getDriver().findElement(By.xpath(".//*[@id='custom_questions']/div[1]/div[4]/fieldset/div[2]/label")).click();
		Thread.sleep(3000);
		getDriver().findElement(By.id("submit_button")).click();
		switchToRootCloseCurrentWindow(); 
		
		
		
		
		
	}

}
