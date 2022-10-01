package com.testing.trello.task;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardPage {

	

	WebDriver driver;
	WebDriverWait wait;
	WebElement addCardBtn;
	WebElement titleCardText;
	WebElement editCardAnchor;
	List<WebElement>  cardsList;
	Actions action ;
	TakeScreenShot  takeScrShot;
	WebElement closeDialogBtn;
	String browser;
	
	
	
	 public BoardPage(WebDriver driver , WebDriverWait wait , String browser) {	
			this.driver = driver;
			this.wait = wait;
			action = new Actions(driver);
			takeScrShot = new TakeScreenShot(driver);
			this.browser = browser;
			
	 }
	 
	 public void addNewCard(String name ) throws InterruptedException, IOException {
		    
		    Thread.sleep(9000);
			takeScrShot.takeScreenShot("beforeCardCreation-"+browser+".jpeg");
		    Thread.sleep(9000);
		
		try {
			addCardBtn = driver.findElement(By.xpath("//*[@id='board']/div[1]/div/div[3]/a"));	
			addCardBtn.click();
		}catch(Exception e) {
			
		}
		 

		 Thread.sleep(9000);
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//textarea[@placeholder ='Enter a title for this card…']")));	
		 titleCardText = driver.findElement(By.xpath("//textarea[@placeholder ='Enter a title for this card…']"));		
		 titleCardText.sendKeys(Keys.ENTER);
		 titleCardText.sendKeys(name);
		 titleCardText.sendKeys(Keys.ENTER);

		 Thread.sleep(9000);                       
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='board']/div[1]/div/div[2]/a")));
		 cardsList = driver.findElements(By.xpath("//*[@id='board']/div[1]/div/div[2]/a"));
		 
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='board']/div[1]/div/div[2]/a["+cardsList.size()+"]")));
		 editCardAnchor = driver.findElement(By.xpath("//*[@id='board']/div[1]/div/div[2]/a["+cardsList.size()+"]"));
		
		 action.moveToElement(editCardAnchor);
		 action.click(editCardAnchor);
		 action.build().perform();
	
		                      
		 
		                        
		
		 
	 }
	

	 public void deleteLastCard() throws InterruptedException {
		
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='board']/div[1]/div/div[2]/a")));
		 cardsList = driver.findElements(By.xpath("//*[@id='board']/div[1]/div/div[2]/a"));
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='board']/div[1]/div/div[2]/a["+cardsList.size()+"]")));
		 editCardAnchor = driver.findElement(By.xpath("//*[@id='board']/div[1]/div/div[2]/a["+cardsList.size()+"]"));
		 action.contextClick(editCardAnchor);
		 action.build().perform();
		 Thread.sleep(10000);
		 WebElement archive = driver.findElement(By.xpath("//*[@id='chrome-container']/div[7]/div/div[2]/a[8]"));
		
		 action.click(archive);
		 action.build().perform();
	 }
	 
	 public void closeCardPage() throws InterruptedException, IOException {
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='chrome-container']/div[3]/div/div/a")));
		 Thread.sleep(10000);  
		
         closeDialogBtn = driver.findElement(By.xpath("//*[@id='chrome-container']/div[3]/div/div/a"));
		 closeDialogBtn.click();
		
		 Thread.sleep(10000);
		 takeScrShot.takeScreenShot("AfterCardCreation-"+browser+".jpeg");
		 Thread.sleep(10000);
	
	 }
	 
	
}
