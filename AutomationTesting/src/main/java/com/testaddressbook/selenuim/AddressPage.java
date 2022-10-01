package com.testaddressbook.selenuim;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressPage {

    WebDriver driver;
    
    
    
      public List<String> getRowInfo(int index){
		
		List<WebElement> rows = driver.findElements(By.xpath("//tr["+index+"]/td"));
		List<String> rowInfo = new ArrayList<String>();
		for(WebElement td : rows) {
			rowInfo.add(td.getText());
		}
		return rowInfo;
	
	}
    
    public AddressPage(WebDriver driver) {
		this.driver = driver;
	}



    public void clickEditFirstRow() {
    	driver.findElement(By.xpath("//tr[1]/td[6]/a")).click();	
    }

	public void signOut() {
   	  driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/a[3]")).click();
    }
	
	
	public void show(int index) {
		driver.findElement(By.xpath("//tr["+index+"]/td[5]/a")).click();
	}
	
	public void edit() {
		driver.findElement(By.cssSelector("a[href  = '/addresses/21795/edit']")).click();
	}
	
	public void destroy() {
		driver.findElement(By.xpath("//tr[1]/td[7]/a")).click();
	}
	
	public void newAddress() {
		driver.findElement(By.cssSelector("a[href = '/addresses/new']")).click();
	}
	
	public int getAddressesCount() {
		return driver.findElements(By.xpath("/html/body/div/table/tbody/tr")).size();
	}
	
}
