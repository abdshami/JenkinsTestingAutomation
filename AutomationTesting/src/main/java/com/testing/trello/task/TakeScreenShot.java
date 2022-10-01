package com.testing.trello.task;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	
	WebDriver driver;
	
	public TakeScreenShot(WebDriver driver) {
		this.driver = driver;
	}
	
	public  void takeScreenShot(String filePath) throws IOException, InterruptedException {
		TakesScreenshot scrShot =((TakesScreenshot) this.driver);
		Thread.sleep(1000);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(filePath);
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
