package com.testing.trello.task;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTrello {
	
	
	

	WebDriver driver;
	WebDriverWait wait;
	HomePage homePage;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	BoardPage boardPage;
	CardPage cardPage;
	TakeScreenShot  takeScrShot;
	
	WindowHandle windowHandle;
	BrowsersClass browsers;
	
	static String browser;
	
	

	@Parameters("browser");
	@BeforeTest
		public void beforeTest(String browser) throws InterruptedException  {
			
		      System.out.println(browser);
		      System.out.println("l");
		
			  if (browser.equals("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}else if (browser.equals("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}else if (browser.equals("edge")) {
					WebDriverManager.edgedriver();
					driver = new EdgeDriver();
				}	
			  TestTrello.browser = browser;
			  System.out.println(browser);
			  
			  

			  driver.manage().window().maximize();
			  driver.get("https://trello.com");
			 // WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(2));
			  takeScrShot = new TakeScreenShot(driver);
			  
			  homePage = new HomePage(driver,wait);
			  homePage.clickLoginBtn();
			  loginPage = new LoginPage(driver,wait);
			  loginPage.logIn("kht75@hotmail.com", "lion8888");
		    
		}
		
    
	
	
	
	   @Test(priority=1)
		public void addNewBoard() throws InterruptedException {
			dashBoardPage = new DashBoardPage(driver,wait);
			dashBoardPage.createNewBoard("TestBoard");
			
		}
	
	   
		@Test(priority=2)
		public void addNewCard() throws InterruptedException, IOException {
			
			
			boardPage = new BoardPage(driver , wait , browser);
		    boardPage.addNewCard("TestCard");
		    
		    
		    
		    cardPage = new CardPage(driver , wait , browser);
		    cardPage.addCardDescription("TestCardDescription");
		    
		    
		    
		    cardPage.attachFile();
			
			
		    boardPage.closeCardPage();
		   
		    
		   // Assert.assertEquals( cardPage.filesToBeCompre.get(0) , cardPage.filesToBeCompre.get(1));
			
		}
		

		@Test(priority=3)
		public void addAnotherCardDeleteAndDeleteBoard() throws InterruptedException, IOException {
			
			 windowHandle = new WindowHandle(driver);
			 windowHandle.newTab();
			 windowHandle.changeWindow();
			 
			
			 boardPage.addNewCard("anotherTestCard");
			 
			 cardPage = new CardPage(driver , wait , browser);
			 cardPage.addCardDescription("Another Test Card Description");
			 boardPage.closeCardPage();
		     Thread.sleep(8000);
			 windowHandle.changeWindow();
			 Thread.sleep(4000);
			 boardPage.deleteLastCard();
			 
			 Thread.sleep(4000);
			 windowHandle.changeWindow();
			 
			 dashBoardPage.deleteBoard();
			
			 
			 
			
		}
		
	
	

}
