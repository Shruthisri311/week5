package week5.day1.classroom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnScrollDown {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
		
		WebElement sDown = driver.findElement(By.linkText("Conditions of Use & Sale"));
		//System.out.println(sDown.getText());
		Actions act=new Actions(driver);
		act.scrollToElement(sDown).perform();
		
		String text = driver.findElement(By.linkText("Conditions of Use & Sale")).getText();
		System.out.println(text);
	}

}
