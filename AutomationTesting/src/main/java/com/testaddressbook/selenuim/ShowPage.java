package com.testaddressbook.selenuim;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ShowPage {

  WebDriver driver;
  
  List<String> orgValuesForNewAddress;
  List<String> orgValuesForUpdateAddress;
  
  //List<String> values;
  WebElement lastName;
  WebElement firstName;	
  WebElement address1;
  WebElement address2;
  WebElement city;
  WebElement state;
     
     
     public ShowPage(WebDriver driver ) {
    	 
 		this.driver = driver;
 		orgValuesForNewAddress = new ArrayList<String>();
 		orgValuesForUpdateAddress = new ArrayList<String>();
 		//System.out.println("show1");
 		
 		firstName = driver.findElement(By.xpath("/html/body/div/p[1]/span[2]"));
 		lastName  = driver.findElement(By.xpath("/html/body/div/p[2]/span[2]"));
 		address1  = driver.findElement(By.xpath("/html/body/div/p[3]/span[2]"));
 		address2  = driver.findElement(By.xpath("/html/body/div/p[4]/span[2]"));
 		
 		city  = driver.findElement(By.xpath("/html/body/div/p[5]/span[2]"));
 		state  = driver.findElement(By.xpath("/html/body/div/p[6]/span[2]"));
 		
 		//System.out.println("show11");
 		orgValuesForNewAddress.add(firstName.getText());
 		orgValuesForNewAddress.add(lastName.getText());
 		orgValuesForNewAddress.add(address1.getText());
 		orgValuesForNewAddress.add(address2.getText());
    	
 		orgValuesForUpdateAddress.add(firstName.getText());
 		orgValuesForUpdateAddress.add(lastName.getText());
 		orgValuesForUpdateAddress.add(city.getText());
 		orgValuesForUpdateAddress.add(state.getText());
 	//	this.values = values;
 		
 	  // Assert.assertEquals(orgValues ,values);
 	 // System.out.println("The end");
 		
     }  
      
//     public List<String> getElements() {
//    	
//    	
//    	
//    	return orgValues;
    	
//    	 if (orgValues.equals(values) == true) {
//    		 return true;
//         }
//         else {
//             return false;
//         }
//    	for(String value : orgValues) {
//    		if()
//    	}
    	
     public List<String> getElementsValuesForAdd(){
    	 return orgValuesForNewAddress;
     }
     
     public List<String> getElementsValuesForUpdate(){
    	 return orgValuesForUpdateAddress;
     }
    	
     
     
     public void goToAddressPage() {
    	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/a[2]")).click();
     }
     
     public void signOut() {
    	 driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/a[3]")).click();
     }



}
