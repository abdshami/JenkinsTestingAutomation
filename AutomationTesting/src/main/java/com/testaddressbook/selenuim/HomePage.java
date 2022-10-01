package com.testaddressbook.selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

     WebDriver driver;
     
     
     
     public HomePage(WebDriver driver) {
 		this.driver = driver;
     }
      
     
     
     public void goToAddressPage() {
    	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/a[2]")).click();
     }
     
     public void signOut() {
    	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/a[3]")).click();
     }



	
	
}
