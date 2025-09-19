package week5.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsBigbasket {


	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.xpath("(//span[text()='Category'])[2]")).click();
		Thread.sleep(2000);
		//MH the food
		WebElement moFood = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		Actions act=new Actions(driver);
		act.moveToElement(moFood).perform();
		Thread.sleep(2000);
		//MH the rice and rice
		WebElement moRice = driver.findElement(By.partialLinkText("Rice & Rice"));
		act.moveToElement(moRice).perform();
		//click the boiled rice
		driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")).click();
		//filter the bbroyal
		WebElement bbRoyal = driver.findElement(By.xpath("//label[@for='i-bbRoyal']"));
		act.scrollToElement(bbRoyal).perform();
		act.doubleClick(bbRoyal).perform();
		Thread.sleep(1000);
		//click on tamil ponni
		driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']")).click();
		//using set
		Set<String> fPage = driver.getWindowHandles();
		//convert the set into list
		List<String> cWindow=new ArrayList<String>(fPage);
		driver.switchTo().window(cWindow.get(1));
		
		System.out.println(driver.getTitle());
	    //select the 5kg bag
	    WebElement sDown = driver.findElement(By.xpath("//span[text()='5 kg']"));
	    act.scrollToElement(sDown).perform();
	    sDown.click();
	    //note the price of the rice
	    String text = driver.findElement(By.xpath("(//span[@class='Label-sc-15v1nk5-0 PackSizeSelector___StyledLabel5-sc-l9rhbt-5 gJxZPQ bvikaK'])[4]")).getText();
		System.out.println(text);
		//add to basket
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
		//verify the success message
		String text2 = driver.findElement(By.xpath("//p[@class='mx-4 flex-1']")).getText();
		System.out.println(text2);
		//switch to the parent window
		  driver.switchTo().window(cWindow.get(0));
		  Thread.sleep(2000);
		  //driver.quit();
		
		
		
		
		
		
		
		
		
		
		

	}

}
