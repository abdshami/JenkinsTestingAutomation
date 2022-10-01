package com.testing.trello.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowsersClass {
	
	WebDriver driver;

	public BrowsersClass(WebDriver driver) {
		this.driver = driver;
	}
	
      
	public WebDriver getBrowser(String browser) {
		
		if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver();
			driver = new EdgeDriver();
		}	
		return this.driver;
	}
}
