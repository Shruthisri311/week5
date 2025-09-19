package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

public class ActionsSnapdeal {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String title = driver.getTitle();
		System.out.println(title);
		//Mouse Over the men's fashion
		WebElement menFashion = driver.findElement(By.xpath("//span[@class='catText']"));
		Actions act=new Actions(driver);
		act.moveToElement(menFashion).perform();
		//click the sports shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		//get the count of sport shoes
		String allItems = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText();
		System.out.println("Total count of Sport Shoes: " + allItems);
		//select sort by
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
		//check if the displayed items are sorted correctly
		
		//select 500-700
		WebElement from = driver.findElement(By.xpath("//input[@name='fromVal']"));
		from.clear();
		from.sendKeys("500",Keys.ENTER);
		
		WebElement to = driver.findElement(By.xpath("//input[@name='toVal']"));
		to.clear();
		to.sendKeys("700",Keys.ENTER);
		Thread.sleep(2000);
		//filter by any color
		WebElement selectColor = driver.findElement(By.xpath("//label[@for='Color_s-Blue']"));
		act.scrollToElement(selectColor).perform();
		act.doubleClick(selectColor).perform();
		//. Verify all the applied filters
		
		//mouse over the first resulting shoe
		WebElement firstResult = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
		act.moveToElement(firstResult).perform();
		Thread.sleep(2000);
		//click the quick view
		driver.findElement(By.xpath("(//div[@class='clearfix row-disc'])[1]")).click();
		Thread.sleep(2000);
		//print the price and percentage
		String text = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
		System.out.println("Cost and the discount percentage of the shoe is : " + text);
		
		//driver.close();
		//close all the tabs
		Thread.sleep(2000);
		
		
		
		
	}

}
