package com.testaddressbook.selenuim;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.*;

 public  class WorkWithCsvFiles {
	
	

	public static  ArrayList<String[]> readDataFromCsvFile(String file)
	
	{
	  
		ArrayList<String[]> testCases = new  ArrayList<String[]>();
		
	    try {
	  
	        FileReader filereader = new FileReader(file);
	  
	        CSVReader csvReader = new CSVReader(filereader);

	        String[] record;
	 
	        while ((record = csvReader.readNext()) != null) {
	        	
	        	testCases.add(record);
	       
	        }
	        
	        
	        csvReader.close();
	        
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    
	    
	    return testCases;
	}
	
	
	
	
	
	public static String writeToCsvFile(String filePath , List<String[]> data)
	{
	     ArrayList<String[]> newData = (ArrayList<String[]>) data;
	   
	    File file = new File(filePath);
	  
	    try {
	      
	    	//FileWriter pw = new FileWriter("F:\\data.csv",true); 
	        FileWriter outputfile = new FileWriter(file,true);
	 
	        CSVWriter writer = new CSVWriter(outputfile);
	  
	        // create a List which contains String array
	        //List<String[]> data = new ArrayList<String[]>();
//	        data.add(new String[] { "route", "statusCode" });
//	        data.add(new String[] { "/posts", "200" });
//	        data.add(new String[] { "/posts/1", "200" });
//	        data.add(new String[] { "/posts/1000", "404" });
//	        data.add(new String[] { "/posts/test", "404" });
//	        data.add(new String[] { "/comments?postId=1", "200" });
//	        data.add(new String[] { "/comments?postId=test", "404" });
//	        data.add(new String[] { "/comments?postId=10000", "404" });
//	        data.add(new String[] { "/posts/1/comments", "200" });
//	        data.add(new String[] { "/posts/3333/comments", "404" });
//	        data.add(new String[] { "/posts/test/comments", "404" });
	        
//	        data.add(new String[] { "/posts", "404" });
//	        data.add(new String[] { "/posts/1", "404" });
//	        data.add(new String[] { "/posts/1", "404" });
//	        data.add(new String[] { "/posts/1", "404" });
	        writer.writeAll(newData);
	        
//	        
//	        POST	
//	        PUT	
//	        PATCH	
//	        DELETE	
	  
	        // closing writer connection
	        writer.close();
	    }
	    catch (IOException e) {
	       
	        e.printStackTrace();
	    }
	    return filePath;
	   
	
	
	
	}

}
