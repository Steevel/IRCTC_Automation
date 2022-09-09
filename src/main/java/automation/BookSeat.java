package automation;

import java.util.List;

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
		
		// Check the checkbox and accept the popup
		Thread.sleep(1000l);
		driver.findElement(By.xpath("//label[@for=\"concessionBooking\"]")).click();
		Thread.sleep(1000l);
		driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
		
		// Click on Search button
		Thread.sleep(2000l);
		driver.findElement(By.xpath("//button[contains(@class, \"train_Search\")]")).click();
		
		
//		Thread.sleep(2000l);
//		WebElement e = driver.findElement(By.xpath("//span[contains(text(), \"Results for\")]"));
//		String str = e.getText();
//		int totalResults = Integer.parseInt(str.substring(0,2));
//		
//		System.out.println(totalResults);
		
		Thread.sleep(3000l);
		List<WebElement> resultTile = driver.findElements(By.xpath("//div[contains(@class, 'form-group no-pad')]"));
		int count = resultTile.size();
		System.out.println(count);
		
		Thread.sleep(2000l);
		driver.findElement(By.xpath("(//div[contains(@class, 'form-group no-pad')])[1]//td//strong[contains(text(),'3A')]")).click();
		Thread.sleep(3000l);
		driver.findElement(By.xpath("//td//div[contains(@class,\"AVAILABLE\")]")).click();
		Thread.sleep(2000l);
		driver.findElement(By.xpath("(//div[contains(@class, 'form-group no-pad')])[1]//button[contains(text(), \"Book Now\")]")).click();
		
//		for(int i=1; i<=count; i++) {
//			Thread.sleep(2000l);
//			driver.findElement(By.xpath("(//div[contains(@class, 'form-group no-pad')])["+i+"]//td//strong[contains(text(),'2A')]")).click();
//		}
		
		
		
	}

}
