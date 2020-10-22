package SQA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Setting Chrome Driver Property
		System.setProperty("webdriver.chrome.driver", "binaries\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "binaries\\geckodriver.exe");
		
		// Instatiate the ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		// Maximizing the Browser window
		driver.manage().window().maximize();
		
		// Instantiate Firefox Driver
		//FirefoxDriver driver = new FirefoxDriver();
		
		// Instantiating a Property Class
		Properties prop = new Properties();
		
		// Reading the Property file
		try {
			// Reading file stream from the specified file
			FileInputStream file = new FileInputStream("src\\config.properties");
			// Loading the file stream into the prop object
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Get the value of baseURL
		String url = prop.getProperty("baseURL");
		
		// Opening Google Homepage in Chrome Browser
		driver.get(url);
		
		// Sending search string to Google Search field
		driver.findElementByName("q").sendKeys("Software Quality Assurance");
		
		//By searchField = By.name("q");
		//WebElement googleSearchField = driver.findElement(searchField);
		WebElement googleSearchField = driver.findElement(By.name("q"));
		
		// Click on Enter button
		driver.findElementByName("q").sendKeys(Keys.ENTER);
		
		// Quitting the driver
		//driver.quit();

	}

}
