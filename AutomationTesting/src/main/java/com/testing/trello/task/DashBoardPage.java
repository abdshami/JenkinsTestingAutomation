package com.testing.trello.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {
	
	
	 WebElement createMenuBtn;
	 WebElement createBoardBtn;
	 WebElement boardNameInput;
	 WebElement createSubmitBtn;
	 TakeScreenShot  takeScrShot;
	 WebDriver driver;
	 WebDriverWait wait;
	 Actions action;

	 public DashBoardPage(WebDriver driver , WebDriverWait wait) {
		this.driver = driver; 
		this.wait = wait;
		action = new Actions(driver);
		takeScrShot = new TakeScreenShot(driver);
	 }
	 
	 public void createNewBoard(String name) throws InterruptedException {
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@data-test-id ='header-create-menu-button']")));
		 Thread.sleep(8000); 
		 //deleteBoard();
		 createMenuBtn = driver.findElement(By.xpath("//button[@data-test-id ='header-create-menu-button']"));
		 
		 createMenuBtn.click();
		 Thread.sleep(8000);
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@data-test-id ='header-create-board-button']")));
		 createBoardBtn = driver.findElement(By.xpath("//button[@data-test-id ='header-create-board-button']"));
//		 Actions action = new Actions(driver);
//		 action.click(createBoardBtn);
//		 action.build().perform();
		 createBoardBtn.click();
	      
		 Thread.sleep(8000);
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@data-test-id ='create-board-title-input']")));                                                
	     boardNameInput = driver.findElement(By.xpath("//input[@data-test-id ='create-board-title-input']"));
		 boardNameInput.sendKeys(name);
		 Thread.sleep(8000);
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@data-test-id ='create-board-submit-button']")));
	     createSubmitBtn = driver.findElement(By.xpath("//button[@data-test-id ='create-board-submit-button']"));
//	     action.click(createSubmitBtn);
//		 action.build().perform();
	     createSubmitBtn.click();
	     
	     Thread.sleep(8000);
	   

	 }
	 
	 public void deleteBoard() throws InterruptedException {
		 Thread.sleep(12000);
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='popover-boundary']/div/div[1]/nav/div[1]/div/div/div[2]/div/div[3]/ul/div[2]/li[2]")));
		 WebElement boardTab = driver.findElement(By.xpath("//*[@id='popover-boundary']/div/div[1]/nav/div[1]/div/div/div[2]/div/div[3]/ul/div[2]/li[2]"));
		
		 action.moveToElement(boardTab);
		 action.perform();
		 Thread.sleep(9000);
			
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='popover-boundary']/div/div[1]/nav/div[1]/div/div/div[2]/div/div[3]/ul/div[2]/li[2]/div[2]/div[1]/button/span/span")));
		 WebElement boardOpt = driver.findElement(By.xpath("//*[@id='popover-boundary']/div/div[1]/nav/div[1]/div/div/div[2]/div/div[3]/ul/div[2]/li[2]/div[2]/div[1]/button/span/span"));
		 Thread.sleep(9000);
		 boardOpt.click();
		 
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[6]/div/section/div/div/button")));
		 driver.findElement(By.xpath("/html/body/div[6]/div/section/div/div/button")).click();
		 Thread.sleep(9000);
		 
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[6]/div/section/div/button")));
		 driver.findElement(By.xpath("/html/body/div[6]/div/section/div/button")).click();
		 Thread.sleep(9000);

		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='content']/div/div/div/div/div/div[2]/button")));
		 driver.findElement(By.xpath("//*[@id='content']/div/div/div/div/div/div[2]/button")).click();
		 Thread.sleep(10000);
		
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[6]/div/section/div/button")));
		 driver.findElement(By.xpath("/html/body/div[6]/div/section/div/button")).click();
		 Thread.sleep(10000);
	
		
	 }
	 
	
}
