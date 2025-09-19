package week5.day1.classroom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnTable {
	
public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("MAS",Keys.ENTER);
		
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("MDU");
		to.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		List<WebElement> allNames = driver.findElements(By.xpath
				("//table[@class=\"DataTable TrainList TrainListHeader stickyTrainListHeader\"]/tbody/tr/td[2]"));
		for (WebElement iterator : allNames) {
			System.out.println(iterator.getText());
			
		}
}
}