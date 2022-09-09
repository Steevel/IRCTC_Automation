package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookSeat {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse Programs\\Selenium Workspace\\IRCTCAutomation\\src\\main\\resources\\chromedriver.exe");
		
		// Disabling notification
		ChromeOptions option = new ChromeOptions ();
		option.addArguments("--disable-notifications");
				
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		WebElement searchBox1 = driver.findElement(By.xpath("//input[@aria-controls=\"pr_id_1_list\"]"));
		for(int i = 0; i < 14; i++) {
			searchBox1.sendKeys(Keys.ARROW_DOWN);
		}
		searchBox1.sendKeys(Keys.ENTER);
		
		Thread.sleep(3000l);
		WebElement searchBox2 = driver.findElement(By.xpath("//input[@aria-controls=\"pr_id_2_list\"]"));
		for(int i = 0; i < 3; i++) {
			searchBox2.sendKeys(Keys.ARROW_DOWN);
		}
		searchBox2.sendKeys(Keys.ENTER);
		
//		Thread.sleep(1000l);
//		driver.findElement(By.id("//p-calendar[@id=\"jDate\"]//span//input[@type=\"text\"]")).sendKeys("14/09/2022");
//		driver.findElement(By.id("(//input[@type=\"text\"])[3]")).click();
		
		driver.findElement(By.xpath("//div[@role=\"button\"]")).click();
		Thread.sleep(1000l);		
		driver.findElement(By.xpath("(//p-dropdownitem)[6]")).click();
		
		
		driver.findElement(By.xpath("(//div[@role=\"button\"])[2]")).click();
		Thread.sleep(1000l);
		driver.findElement(By.xpath("(//p-dropdownitem)[4]")).click();
		
		Thread.sleep(1000l);
		driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
		
		
	}

}
