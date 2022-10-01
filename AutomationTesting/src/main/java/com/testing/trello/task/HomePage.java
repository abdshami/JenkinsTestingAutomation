package com.testing.trello.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	 WebDriverWait wait;
	WebElement loginBtn;
	
	 public HomePage(WebDriver driver , WebDriverWait wait) {	
			this.driver = driver;  
			this.wait = wait;		
	 }
	 
	 public void clickLoginBtn() throws InterruptedException {
		
		 System.out.println("clickLoginBtn");
		 Thread.sleep(3000);
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']")));
		 loginBtn = driver.findElement(By.xpath("//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']"));
		 loginBtn.click();                        
	 }
		 
	

}
