package com.testing.trello.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	 WebDriver driver;
	 String  firstTab;
	 String  secondTab;
	 
	 public WindowHandle(WebDriver driver) {
		 this.driver = driver;
	 }


	  
	 
	 public void newTab() throws InterruptedException {
		
		  firstTab = driver.getWindowHandle();
		  String url = driver.getCurrentUrl();
		  driver.switchTo().newWindow(WindowType.TAB);
		  secondTab = driver.getWindowHandle();
          driver.get(url);
          
          Thread.sleep(4000);
         
         
	}
	
	public void changeWindow() {
		
		
		if(driver.getWindowHandle().equals(firstTab) && secondTab != null) {
			driver.switchTo().window(secondTab);
		}else if(driver.getWindowHandle().equals(secondTab) && firstTab != null) {
			driver.switchTo().window(firstTab);
		}
		
		driver.navigate().refresh();
		 
	}

}
