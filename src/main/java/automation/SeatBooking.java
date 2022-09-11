package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeatBooking {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		// Disabling notification
		ChromeOptions option = new ChromeOptions ();
		option.addArguments("--disable-notifications");
				
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse Programs\\Selenium Workspace\\IRCTCAutomation\\src\\main\\resources\\chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.manage().window().maximize();
		
		// Accept first popup
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		// Enter from location
		WebElement searchBox1 = driver.findElement(By.xpath("//input[@aria-controls=\"pr_id_1_list\"]"));
		for(int i = 0; i < 14; i++) {
			searchBox1.sendKeys(Keys.ARROW_DOWN);
		}
		searchBox1.sendKeys(Keys.ENTER);
		
		// Enter To location
		Thread.sleep(2000l);
		WebElement searchBox2 = driver.findElement(By.xpath("//input[@aria-controls=\"pr_id_2_list\"]"));
		for(int i = 0; i < 3; i++) {
			searchBox2.sendKeys(Keys.ARROW_DOWN);
		}
		searchBox2.sendKeys(Keys.ENTER);
		
		// Select journey date
		driver.findElement(By.xpath("//p-calendar[@formcontrolname=\"journeyDate\"]")).click();
		Thread.sleep(2000l);
		driver.findElement(By.xpath("//div[contains(@class, \"ui-datepicker-calendar-container\")]//td//a[contains(text(), \"17\")]")).click();

		// Select Journey Class
		driver.findElement(By.xpath("//div[@role=\"button\"]")).click();
		Thread.sleep(1000l);		
		driver.findElement(By.xpath("(//p-dropdownitem)[8]")).click();
		
		// Select person with disability and accept the alert
		driver.findElement(By.xpath("(//div[@role=\"button\"])[2]")).click();
		Thread.sleep(1000l);
		driver.findElement(By.xpath("(//p-dropdownitem)[4]")).click();
		
		Thread.sleep(1000l);
		driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
		
		// Check the check box and accept the popup
		Thread.sleep(1000l);
		driver.findElement(By.xpath("//label[@for=\"concessionBooking\"]")).click();
		Thread.sleep(1000l);
		driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
		
		// Click on Search button
		Thread.sleep(2000l);
		driver.findElement(By.xpath("//button[contains(@class, \"train_Search\")]")).click();
		
		// Count number of results
		Thread.sleep(3000l);
		List<WebElement> resultTile = driver.findElements(By.xpath("//div[contains(@class, 'form-group no-pad')]"));
		int count = resultTile.size();
		System.out.println(count);
		
		for(int i=1; i<=count; i++) {
		Thread.sleep(2000l);
		List<WebElement> journeyClass = driver.findElements(By.xpath("(//div[contains(@class, 'form-group no-pad')])["+i+"]//td//strong[contains(text(),'3A')]"));
		
		if(journeyClass.size() > 0) {
			journeyClass.get(0).click();
			Thread.sleep(2000l);
			driver.findElement(By.xpath("//td//div[contains(@class,\"AVAILABLE\")]")).click();
			Thread.sleep(2000l);
			driver.findElement(By.xpath("(//div[contains(@class, 'form-group no-pad')])["+i+"]//button[contains(text(), \"Book Now\")]")).click();
			break;
		}
	}
		
		Thread.sleep(2000l);
		driver.findElement(By.xpath("//button//span[contains(text(),\"I Agree\")]")).click();
		Thread.sleep(2000l);
		driver.findElement(By.xpath("//button//span[contains(text(),\"Yes\")]")).click();
		
		
		Thread.sleep(2000l);
		driver.findElement(By.xpath("//input[@placeholder=\"User Name\"]")).sendKeys("adsfsad");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("adsfsad");
		driver.findElement(By.id("nlpAnswer")).sendKeys("adsfsad");
		Thread.sleep(1000l);
//		driver.findElement(By.xpath("//label[contains(text(),\"Login & Booking With OTP\")]")).click();
		driver.findElement(By.xpath("//button[contains(text(),\"SIGN IN\")]")).click();
		
	}

}
