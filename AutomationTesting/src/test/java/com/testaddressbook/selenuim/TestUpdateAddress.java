package com.testaddressbook.selenuim;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUpdateAddress {
	
	WebDriver driver;
	static String csvPath;
	AddressPage address ;
	
	//List<String> rowInfo;
	List<String> newFullName;
	
	
	
	
	@BeforeSuite
	public void beforeSuite() throws InterruptedException  {

		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("http://a.testaddressbook.com/sign_in");
		  Thread.sleep(3000);
		  
		  address = new AddressPage(driver);
		
		  SignInPage sign = new SignInPage(driver);
		  sign.signIn();
		  Thread.sleep(1000);
		  
		  HomePage home = new HomePage(driver);
		  home.goToAddressPage();
		  Thread.sleep(3000);
	
		 // rowInfo = address.getRowInfo();
		
		  
	}
	
	
	
	
	
	@Test(priority=1)		
	public void updateAddress() throws InterruptedException {
	   
		address.clickEditFirstRow();
		Thread.sleep(3000);
		UpdateAddressPage updateAddressPage = new UpdateAddressPage(driver);
	
		List<String> fullName = updateAddressPage.updateAddress();
	
		
		Thread.sleep(3000);
		
		ShowPage showPage = new ShowPage(driver);
		showPage.goToAddressPage();
		
		Thread.sleep(5000);
		newFullName = address.getRowInfo(1);
		List<String> fullName11 = new ArrayList<String>();
		
		for(int i = 0 ; i < 2 ; i++) {
			fullName11.add(newFullName.get(i));
		}
		
		
		
		System.out.println("update");
		Assert.assertEquals(fullName11, fullName);
		
	}
	

	@Test(priority=2)		
	public void showAddress() throws InterruptedException {
	    int count = address.getAddressesCount();
	    List<String> row = new ArrayList<String>();
	    List<String> elementsValues = new ArrayList<String>();
	    
	    
	    
	    for(int i = 1 ; i <= count ; i++ ) {
	    	Thread.sleep(3000);
	    	row = address.getRowInfo(i);
	    	row.remove(6);
	    	row.remove(5);
	    	row.remove(4);
	    	address.show(i);
			Thread.sleep(3000);
			ShowPage showPage = new ShowPage(driver);
			elementsValues = showPage.getElementsValuesForUpdate();
	         
			System.out.println("show");
	    	Assert.assertEquals(row, elementsValues);
			showPage.goToAddressPage();
			
	    }
		
		
		
	}
	

	@Test(priority=3)		
	public void deleteAddress() throws InterruptedException {
		System.out.println("Destroy");
		int count = address.getAddressesCount();
		List<String> row = new ArrayList<String>();
		
		for(int i = 0 ; i < count ; i++ ) {
			
	    	Thread.sleep(3000);
	    	int count1 = address.getAddressesCount();
	    	row = address.getRowInfo(1);
	    	address.destroy();
	    	Thread.sleep(3000);
	    	driver.switchTo().alert().accept();
	    	Thread.sleep(2000);
	    	System.out.println(count1-1 + "   " + address.getAddressesCount());
	    	
	    	for(String str : row) {
	    		System.out.println("row  " +  str);
	    	}
	    	
	    	System.out.println("------------------------------------");
	    	
	    	for(String str : address.getRowInfo(1) ) {
	    		System.out.println("rowInfo  " +  str);
	    	}
   	
	    	Assert.assertEquals(address.getAddressesCount() , count1-1);
	    	Assert.assertNotEquals(address.getRowInfo(1) , row);
	    	
	    	
	    	
	    	
		}

	}

}
