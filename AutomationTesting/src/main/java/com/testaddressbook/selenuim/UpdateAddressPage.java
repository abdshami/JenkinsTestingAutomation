package com.testaddressbook.selenuim;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class UpdateAddressPage {

			WebDriver driver;		
			WebElement firstName;
			WebElement lastName;
			List<String> fullName ;
			
			
			
	
			
	public UpdateAddressPage(WebDriver driver) {
		this.driver = driver;
		fullName = new ArrayList<String>();
		
		firstName = this.driver.findElement(By.id("address_first_name"));
		lastName = this.driver.findElement(By.id("address_last_name"));
		
		fullName.add("Khaldoun");
		fullName.add("Tamimi");
	
	}
	

	public List<String> updateAddress() throws InterruptedException {
		firstName.clear();
		lastName.clear();
		firstName.sendKeys(fullName.get(0));
		lastName.sendKeys(fullName.get(1));
	    driver.findElement(By.name("commit")).click();
	    Thread.sleep(2000);
	    return fullName;
	}
	
	public void goToaddressPage() {
		  driver.findElement(By.cssSelector("a[href='/addresses']")).click();
	}
	
	public void show() {
		driver.findElement(By.cssSelector("a[href  = '/addresses/21795']")).click();
	}
	
    
    public void signOut() {
   	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/a[3]")).click();
    }
	
	

}
