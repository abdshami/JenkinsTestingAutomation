package com.testaddressbook.selenuim;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewAddressPage {
	
	static WebDriver driver;

	 WebElement firstName;
	 WebElement lastName;
	 WebElement address1;
	 WebElement address2;
	 WebElement city;
	 WebElement state;
	 WebElement zipCode;
	 List<WebElement> countries;
	 WebElement birthday;
	 WebElement color;
	 WebElement age;
	 WebElement website;
	 WebElement phone;
	 List<WebElement> commonInterestsChkBox;
	 WebElement note;
	
	 List<String> elementsValues;
	

	public NewAddressPage(WebDriver driver) {

		this.driver = driver;
	
		firstName = driver.findElement(By.id("address_first_name"));
		lastName = driver.findElement(By.id("address_last_name"));
		
		address1 = driver.findElement(By.id("address_street_address"));
		address2 = driver.findElement(By.id("address_secondary_address"));
		city = driver.findElement(By.id("address_city"));
		state = driver.findElement(By.id("address_state"));

		zipCode = driver.findElement(By.id("address_zip_code"));
		
		countries = driver.findElements(By.xpath("//input[@type='radio']"));
		
		birthday = driver.findElement(By.id("address_birthday"));
		color = driver.findElement(By.id("address_color"));
		
		age = driver.findElement(By.id("address_age"));
		website = driver.findElement(By.id("address_website"));
		phone = driver.findElement(By.id("address_phone"));
	
		commonInterestsChkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
	
		note = driver.findElement(By.id("address_note"));
		
		elementsValues = new ArrayList<String>();

	}

    

	public void addNewAddress( String firstName, String lastName, String address1,
			String address2, String city, String state, String zipCode, String country,
			String birthday, String color, String age, String website, String phone,
			String chkBoxValues, String note) throws InterruptedException  {
	
		elementsValues.add(firstName);
		elementsValues.add(lastName);
		elementsValues.add(address1);
		elementsValues.add(address2);
		
		
		this.firstName.sendKeys(firstName);      ;
		this.lastName.sendKeys(lastName); 
		this.address1.sendKeys(address1); ;
		this.address2.sendKeys(address2);
		this.city.sendKeys(city);
		
	    Select select = new Select(this.state);
		select.selectByVisibleText(state);
		
		this.zipCode.sendKeys(zipCode);
		
		for(WebElement country1 : countries) {
			if((country1.getAttribute("value")).equals(country)){
				country1.click();
				break;
			}
		}
	
		
		this.birthday.sendKeys(birthday);
		
		this.color.sendKeys(color);
		this.age.sendKeys(age);
		this.website.sendKeys(website); 
		this.phone.sendKeys(phone);
		
		
		String[] arrChkBox = chkBoxValues.split(",");
			
		for(String str : arrChkBox) {
				for(WebElement chkBox : commonInterestsChkBox) {
						if(chkBox.getAttribute("id").equals("address_interest_"+str)) {
							chkBox.click();
						}
				}
    	}

		this.note.sendKeys(note);
		Thread.sleep(3000);
		driver.findElement(By.name("commit")).click();
	
	}

	
	


	
	public List<String> getElementsValues() {
		  return elementsValues;
	}
	
	public void goToaddressPage() {
		  driver.findElement(By.cssSelector("a[href='/addresses']")).click();
	}
	
	
	
			
	
	
	
	

}
