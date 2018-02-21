package aaahome;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

//import java.util.concurrent.TimeUnit;


public class AAAhomepage {

	public static void main(String[] args) {

		// please note that geckodriver has to be installed to run the code
		System.setProperty("webdriver.gecko.driver", "/Users/Anuhya/Downloads/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		
		//Wait time for the page elements to load
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        //launch application
        driver.get("https://www.aaalife.com/term-life-insurance-quote-input");
		
        //Enter ZIP Code
        driver.findElement(By.id("zip")).sendKeys("48167");
        
        //Select Gender
        WebElement gender = driver.findElement(By.name("gender"));
        SelectDropDown(gender,"VisibleText", "Female");
        
        //Select Data of Birth
        WebElement month = driver.findElement(By.name("month"));
        WebElement day = driver.findElement(By.name("day"));
        WebElement year = driver.findElement(By.name("year"));
        
        SelectDropDown(month,"VisibleText", "August");
        SelectDropDown(day,"Value", "2");
        SelectDropDown(year,"Value", "1991");
        
        //Select AAA Member
        
        driver.findElement(By.xpath("//label[@for='isMemberNo']/span")).click();
        
        //Enter Email Address
        driver.findElement(By.name("email")).sendKeys("bukkaanuhya@gmail.com");
        
        //Enter Height
        WebElement feet = driver.findElement(By.name("feet"));
        WebElement inches = driver.findElement(By.name("inches"));
        SelectDropDown(feet,"Value", "5");
        SelectDropDown(inches,"Value", "6");
        
        //Enter weight
        driver.findElement(By.id("weight")).sendKeys("160");
        
        //Last 12 months
        driver.findElement(By.xpath("//label[@for='nicotineUseNo']/span")).click();
        
        //Select Coverage Amount
        WebElement coverageAmount = driver.findElement(By.name("coverageAmount"));
        SelectDropDown(coverageAmount,"Value", "100,000");
        
        //Term Length
        WebElement termLength = driver.findElement(By.name("termLength"));
        SelectDropDown(termLength,"Value", "10");
        
        //Click on Quote button
        driver.findElement(By.xpath("//button[@id='seeQuote']")).click();

	}
	
	public static void SelectDropDown(WebElement ele, String type, String drpvalue)
    {
        Select select = new Select(ele);
        
        if(type == "Value")
        {
            select.selectByValue(drpvalue);
        }
        
        if(type == "VisibleText")
        {
            select.selectByVisibleText(drpvalue);
        }
    }

}

