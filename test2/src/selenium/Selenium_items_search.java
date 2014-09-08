package selenium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;


public class Selenium_items_search {
	Selenium selenium;
	String url;
	BufferedWriter out;

	public Selenium_items_search(WebDriver driver, String url){
		this.url = url;
		//driver.get(url);
		selenium = new WebDriverBackedSelenium(driver, url);
	
		
		//create test report file to log automate test result
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
				
		try{
		FileWriter fstream = new FileWriter("out_"+dateFormat.format(cal.getTime())+"ItemsSearch"+".txt", true);
		 out = new BufferedWriter(fstream);
		  
		 out.write(dateFormat.format(cal.getTime()) + " Items search automation test " +"\n"); 
		 out.newLine();
		 out.newLine();
		}
		catch(Exception e){
		System.err.println("Error occurs when creating output file: " + e.getMessage() );
		}	
			
	}

	
	// search with the existing items
	public void itemsSearch_byHae(WebDriver driver) throws IOException {
		String itemForSearch = "Apple iPad Air tabletti";
		
		//driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys(itemForSearch);
		selenium.waitForPageToLoad("30000");
		driver.get(url+"/fi/search?q=Apple+iPad+Air++tabletti");
		selenium.waitForPageToLoad("30000");
		
		if (driver.findElement(By.linkText("Apple iPad Air 64 Gt Wi-Fi -tabletti, musta, MD787"))!= null){
			selenium.waitForPageToLoad("30000");
	    	System.out.println ("Pass! The items is found.");
	    	
	    	System.out.println ("Pass! The items is found.");
	    	out.write("Pass! The items is found.");
	    	out.newLine();
	    	out.flush();

		    
	    }
	    else{
	    	System.out.println ("Fail! The items is not found.");
	    	out.write("Fail! The items is not found.");
	    	out.newLine();
	    	out.flush();

	    	
	    }	
	    				
	}

	// search with not the existing items
	
	
	
	
	//search items by menu
	
	public void itemsSearch_byMenu(WebDriver driver) throws IOException {
		
		driver.get(url+"/fi/catalog/5a/Tietokoneet");
		driver.get(url+"/fi/catalog/817b/Tietokoneet-Tabletit");
		selenium.waitForPageToLoad("30000");
		
		if(selenium.isTextPresent("Tabletit")){
			System.out.println (" Pass! The search is successful. "); 
			
			out.write("Pass! The search is successful.");
	    	out.newLine();
	    	out.flush();
						
			}
			else{
			System.out.println (" Fail! The search is not successful. ");
			out.write("Fail! The search is not successful.");
	    	out.newLine();
	    	out.flush();
							
			}
				
		
	}


	
	
}
