package week5.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class WebTableFinanceyahoo {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://finance.yahoo.com");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//mouse over on More
		WebElement moreClick = driver.findElement(By.xpath("//span[text()='More']"));
		Actions act=new Actions(driver);
		act.moveToElement(moreClick).perform();
		
		//click on the crypto
		driver.findElement(By.xpath("//a[@aria-label='Finance: Crypto']")).click();
		//column count
		List<WebElement> columnCount = driver.findElements(By.xpath("//table[@class='yf-1m4mc7b bd']/tbody/tr/td[2]"));
		int size = columnCount.size();
		System.out.println("Column size is :" + size);
		System.out.println("--------------------------------------------------------");
		System.out.println("Crypto Names are : ");
		//using loop
		List<WebElement> cryptoNames = driver.findElements(By.xpath("//table[@class='yf-1m4mc7b bd']/tbody/tr/td[2]"));
		for (WebElement iterator : cryptoNames) {
			System.out.println(iterator.getText());
		}
	
	}

}
