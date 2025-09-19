package week5.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsAmazon {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.Amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String title = driver.getTitle();
		System.out.println(title);
		//click to continue
		driver.findElement(By.className("a-button-text")).click();
		//search one plus
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		//get the price of the first product
		String text = driver.findElement(By.className("a-price-whole")).getText();
		System.out.println("First Product Price is : " + text);
		//get the no.of rating of 1st product
		String text2 = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		System.out.println("Total Ratings are : "+ text2);
		//click the first text
		driver.findElement(By.xpath("(//div[@data-cy='title-recipe'])[1]")).click();
		//using set
		Set<String> cWindow = driver.getWindowHandles();
		//using list
		List<String> fPage=new ArrayList<String>(cWindow);
		driver.switchTo().window(fPage.get(1));
		
		//add to cart
		WebElement sDown = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"));
		Actions act=new Actions(driver);
		act.scrollToElement(sDown).perform();
		sDown.click();
		
		String text3 = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("Cart Subtotal is : "+text3);
		
		
		
		//close all the browsers
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
	}

}
