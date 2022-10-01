package com.testaddressbook.selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	
	//https://docs.google.com/document/d/1VVFqWi8T8oYeEDsm6eGgu1FLqCFa6hVkRa1227i1rTg/edit?usp=sharing
	
	 String email;
	 String password;
	 WebDriver driver;

	 public SignInPage(WebDriver driver) {
		
		this.driver = driver;
	   }
	 
	 
    public void signIn() throws InterruptedException {
    	driver.findElement(By.id("session_email")).sendKeys("khaldountak88@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("lion8888");
        driver.findElement(By.name("commit")).click();
    	
    	
    	
    }
    

}
