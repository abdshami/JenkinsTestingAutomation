package com.testing.trello.task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.testaddressbook.selenuim.WorkWithCsvFiles;

public class CardPage {

	WebDriver driver;
	WebDriverWait wait;
    WebElement cardDescriptionText;
	WebElement saveBtn;
	WebElement closeDialogBtn;
	WebElement attachment;
	WebElement attachLinkText;
	WebElement attachBtn;
	WebElement copmuterUploadBtn;
	WebElement downloadBtn;
	TakeScreenShot  takeScrShot;
	String browser;
	
	List<List<String>> filesToBeCompre;

	 public CardPage(WebDriver driver , WebDriverWait wait , String browser ) {	
			this.driver = driver;
			this.wait = wait;
			takeScrShot = new TakeScreenShot(driver);
			this.browser = browser;
	
	 }
	
	 
	 public void addCardDescription(String description) throws InterruptedException {
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//textarea[@placeholder = 'Add a more detailed description…']")));		
		 Thread.sleep(8000);
		
		 cardDescriptionText = driver.findElement(By.xpath("//textarea[@placeholder = 'Add a more detailed description…']"));		
		 cardDescriptionText.click();
		 cardDescriptionText.sendKeys(description);
		
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@ value = 'Save']")));
		 Thread.sleep(8000); 
		 saveBtn = driver.findElement(By.xpath("//input[@ value = 'Save']"));
		 saveBtn.click();
//		 action.click(saveBtn);
//		 action.build().perform();
	 }
	 
	 
	 public void attachFile() throws InterruptedException, IOException {
		
		Thread.sleep(8000);
		takeScrShot.takeScreenShot("BeforeAttachingFile-"+browser+".jpeg");
			
			
		 
		Thread.sleep(8000); 
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@ title = 'Attachment']"))) ;
		attachment = driver.findElement(By.xpath("//a[@ title = 'Attachment']")) ;
		attachment.click();
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("addLink")));
		Thread.sleep(8000); 
		//attachLinkText = driver.findElement(By.id("addLink"));
		
		WorkWithCsvFiles.writeToCsvFile("khaldoun.csv", createCsvFile());
		Thread.sleep(8000);
		
		File file = new File("khaldoun.csv");
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("//input[@ name ='file']")));
		copmuterUploadBtn = driver.findElement(By.xpath("//input[@ name ='file']"));
		copmuterUploadBtn.sendKeys(file.getAbsolutePath());
		
		Thread.sleep(8000); 
		takeScrShot.takeScreenShot("AfterAttachingFile-"+browser+".jpeg");
		Thread.sleep(8000);
		
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("//*[@id='chrome-container']/div[3]/div/div/div/div[4]/div[9]/div[2]/div/div/a")));
		downloadBtn = driver.findElement(By.xpath("//*[@id='chrome-container']/div[3]/div/div/div/div[4]/div[9]/div[2]/div/div/a"));
		downloadBtn.click();
		
		Thread.sleep(8000); 
		file = new File("C:\\Users\\HP\\Documents\\Downloads\\khaldoun.csv");
		List<String[]>  fileToRead = WorkWithCsvFiles.readDataFromCsvFile(file.getAbsolutePath());
		
		List<String[]>  writedFile = createCsvFile();
		Thread.sleep(8000);
		
		
		filesToBeCompre = compareFiles(fileToRead , writedFile);
		
		Thread.sleep(8000);
		
		
       Thread.sleep(8000);
		
	 }
	 
	 
	 public List<List<String>> getFilesToCompare(){
		return this.filesToBeCompre;
	 }
	 
	 
	 public List<String[]> createCsvFile(){
		
		 List<String[]> data = new ArrayList<String[]>();
		 String[] arr = {"khaldoun","Takrouri"};
		 data.add(arr);

		 return data;
	 }
	 
	 
	 public List<List<String>> compareFiles(List<String[]> file1 , List<String[]> file2) {
		    boolean equal = true;
		    List<String> list1 = new ArrayList<String>();
		    List<String> list2 = new ArrayList<String>();
		    
		    List<List<String>> filesToCompre = new ArrayList<List<String>>();

			for(int i = 0 ; i < file2.size(); i++) {
				for(int j = 0 ; j < file2.get(i).length ; j++) {
					
					list1.add(file1.get(i)[j]);
					list2.add(file2.get(i)[j]);
					System.out.println(file1.get(i)[j]  + "   |   " + file2.get(i)[j]);
					if(!file1.get(i)[j].equals(file2.get(i)[j])){
						equal = false;
					}
				}
			}
			
			filesToCompre.add(list1);
			filesToCompre.add(list2);
			
			if(equal){
				System.out.println("Files is equals");
			}else{
			    System.out.println(" Files Not equals");
			}
			return filesToCompre;
			
			
	 }
	 
	 
	 
	 
	
	 
	 
	
	
	
}
