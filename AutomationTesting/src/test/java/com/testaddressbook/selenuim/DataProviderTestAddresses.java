package com.testaddressbook.selenuim;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTestAddresses {

	WebDriver driver;
	static String csvPath;
	
	AddressPage address ;
	NewAddressPage newAddress;
	int oldAdressesCount = 0;
	int Count = 0;
	
	
	
	@Parameters("csvfilePath")
	@BeforeSuite
	public void beforeSuite(String csvfilePath) throws InterruptedException  {
    
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  DataProviderTestAddresses.csvPath = csvfilePath;
		 
		  driver.get("http://a.testaddressbook.com/sign_in");
		  Thread.sleep(3000);
		  
		  address = new AddressPage(driver);
		
		  SignInPage sign = new SignInPage(driver);
		  sign.signIn();
		  Thread.sleep(1000);
		  
		  HomePage home = new HomePage(driver);
		  home.goToAddressPage();
		  Thread.sleep(3000);
		  
		  oldAdressesCount = address.getAddressesCount();
		  
		  System.out.println("oldAdressesCount   :   " + oldAdressesCount);
		  address.newAddress();
		  Thread.sleep(5000);
		
	}
	
	@DataProvider
	public static Object[][]  getCsvData() throws Exception{
		
		List<String[]>  lines = WorkWithCsvFiles.readDataFromCsvFile(csvPath);
		lines.remove(0);
		
		Object[][] data = new Object[lines.size()][lines.get(0).length];
		
		int i = 0;
		for(String[] line : lines) {
			data[i]  = line;
		    i++;
		    
		   for(String  s :  line) {
			   System.out.print(s + "  ");
			   
		   }
		   System.out.println();
		}
		
		return data;
	}
	

	
	@Test(dataProvider = "getCsvData")
	public void testCsvDataString(String firstName, String lastName, String address1,
								String address2, String city, String state, String zipCode, String country,
								String birthday, String color, String age , String website, String phone,
								String chkBoxValues, String note) throws InterruptedException   {
		
	
	    newAddress = new NewAddressPage(driver);
		
		
		Count++;
		System.out.println("Count : " + Count);
		
	
		
		
		newAddress.addNewAddress(  firstName,  lastName,  address1,
					 address2,  city,  state,  zipCode,  country,
					 birthday,  color,  age,  website,  phone,chkBoxValues, note);
		
		List<String> elementsValues = newAddress.getElementsValues();
		elementsValues.clear();
		elementsValues.add(firstName);
		elementsValues.add(lastName);
		elementsValues.add(address1);
		elementsValues.add(address2);
		
		//	driver.navigate().back();
		
		Thread.sleep(4000);
		ShowPage showPage = new ShowPage(driver );
		
		
		
		List<String> showValues = showPage.getElementsValuesForAdd();
		
		
		showPage.goToAddressPage();
		Thread.sleep(5000);
		
		address.newAddress();
		Thread.sleep(5000);

		
		
		System.out.println("Assert");
		Assert.assertEquals(showValues ,elementsValues);
		

		
		
	
		
	}
	
	@AfterSuite
	public void AfterAll() throws InterruptedException {
		newAddress.goToaddressPage();
		Thread.sleep(3000);
		Assert.assertEquals(( address.getAddressesCount() - oldAdressesCount) , Count);
	
	}
		
}
