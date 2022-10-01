package com.testing.trello.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	 WebDriver driver;
	 WebDriverWait wait;
	 WebElement email;
	 WebElement password;
	 WebElement logInSubmitBtn;
	 WebElement loginBtn;
	 
	

	 public LoginPage(WebDriver driver , WebDriverWait wait ) {
		this.driver = driver;
		this.wait = wait;
	 }
	 
	 
   public void logIn(String emailStr ,String pass) throws InterruptedException {
	   Thread.sleep(10000);
	   //jj
	   //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("user")));
	   email = driver.findElement(By.id("user"));
	   email.sendKeys(emailStr);
	  // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("login")));
	   Thread.sleep(10000);
	   loginBtn = driver.findElement(By.id("login"));
   	   loginBtn.click();
   	 Thread.sleep(10000);
      // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("password")));
       password = driver.findElement(By.id("password"));
       password.sendKeys(pass);
       Thread.sleep(10000);
       //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("login-submit")));
       logInSubmitBtn = driver.findElement(By.id("login-submit"));
       
//       Actions action = new Actions(driver);
//	   action.click(logInSubmitBtn);
//	   action.build().perform();
       
       logInSubmitBtn.click();
      
       
   }

}
