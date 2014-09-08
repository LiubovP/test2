package selenium;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.Selenium_add_items;
import selenium.Selenium_items_search;



public class simple_test {
	static String url = "http://www.verkkokauppa.com";

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		search_test(driver, url);
		add_toBasket(driver, url);
		delete_items(driver, url);
		
		//driver.close();
		//driver.quit();
		
		//check this command
	}
	
	
    private static void delete_items(WebDriver driver, String url) throws IOException {
    	Selenium_delete_items s_delItems =new Selenium_delete_items(driver, url); 
    	s_delItems.delItems_byButton(driver);
    	s_delItems.delItems_byCheckBox(driver);
    	
	}


	public static void search_test(WebDriver driver, String url) throws IOException{
    	Selenium_items_search s_items =new Selenium_items_search(driver, url); 	
    	s_items.itemsSearch_byHae(driver);
    	s_items.itemsSearch_byMenu(driver);    	
    }
    
    public static void add_toBasket(WebDriver driver, String url) throws IOException{
    	Selenium_add_items s_addItems =new Selenium_add_items(driver, url); 	
    	s_addItems.addItems(driver);    	   	   	
    }
    
    
    
    
}
