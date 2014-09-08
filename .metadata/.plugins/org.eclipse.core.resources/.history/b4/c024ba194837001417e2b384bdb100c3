package selenium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class Selenium_delete_items {
	Selenium selenium;
	String url;
	BufferedWriter out;
	
	public Selenium_delete_items(WebDriver driver, String url) {
		// TODO Auto-generated constructor stub
		this.url = url;
		driver.get(url);
		selenium = new WebDriverBackedSelenium(driver, url);
			
		
		//create test report file to log automate test result
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
				
		try{
		FileWriter fstream = new FileWriter("out_"+dateFormat.format(cal.getTime())+"DeleteItems"+".txt", true);
		 out = new BufferedWriter(fstream);
		 out.write(dateFormat.format(cal.getTime()) + " Delete Items automation test " +"\n"); 
		 out.newLine();
		 out.newLine();
		}
		catch(Exception e){
		System.err.println("Error occurs when creating output file: " + e.getMessage() );
		}	
		
		
	}
	
	// for Ajax
	public ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) {
        return new ExpectedCondition<WebElement>() {
          public WebElement apply(WebDriver driver) {
            WebElement element = driver.findElement(by);
            return element.isDisplayed() ? element : null;
          }
        };
        
      }

	public void delItems_byButton(WebDriver driver) throws IOException {
		
		driver.get(url+"/fi/order");
		
		selenium.click("id=reset");
		selenium.waitForPageToLoad("30000");
		
		if(selenium.isTextPresent("Ostoskorisi on tyhjä.")){
			System.out.println (" Pass! The item has been delete by the button. "); 
						
			out.write("Pass! The item has been delete by the button.");
	    	out.newLine();
	    	out.flush();
			
			
			}
			else{
			System.out.println (" Fail! The item has not been delete by the button. ");

			out.write("Fail! The item has not been delete by the button.");
	    	out.newLine();
	    	out.flush();
			
			
			}
		
		
	}

	public void delItems_byCheckBox(WebDriver driver) throws IOException {
		driver.get(url+"/fi/search?q=Apple+iPad+Air++tabletti");
		//driver.get(url+"/fi/product/39172/dqfcc/Apple-iPad-Air-64-Gt-Wi-Fi-tabletti-musta-MD787");
		selenium.click("link=Apple iPad Air 64 Gt Wi-Fi -tabletti, musta, MD787");
		selenium.waitForPageToLoad("30000");
		
		driver.findElement(By.id("add")).click();
		selenium.waitForPageToLoad("30000");
		
		
		Wait<WebDriver> wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(visibilityOfElementLocated(By.id("cart-order")));
				
		selenium.click("id=cart-order");
		selenium.waitForPageToLoad("30000");
		
		
		if ( !driver.findElement(By.id("products-product_39172-delete")).isSelected() )
		{
		     driver.findElement(By.id("products-product_39172-delete")).click();
		}
		
		selenium.click("id=update");
		selenium.waitForPageToLoad("30000");
		
		if(selenium.isTextPresent("Ostoskorisi on tyhjä.")){
			System.out.println ("Pass! The item has been delete by the Check-box. "); 
			
			out.write("Pass! The item has been delete by the Check-box.");
	    	out.newLine();
	    	out.flush();
			
			}
			else{
			System.out.println (" Fail! The item has not been delete by the Check-box. ");
			out.write(" Fail! The item has not been delete by the Check-box.");
	    	out.newLine();
	    	out.flush();
						
			}
		
	}
	
	
	
}