package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandlingLeaftap {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");

		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("SFA")).click();
		//click on the contact button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//click on the merge contact
		driver.findElement(By.linkText("Merge Contacts")).click();
		
		//click the widget of the 1st contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Thread.sleep(3000);
		//using set
		Set<String> fcontact = driver.getWindowHandles();
		//convert the set into list
		List<String> cWindow=new ArrayList<String>(fcontact);
		driver.switchTo().window(cWindow.get(1));
		String childWindow = driver.getWindowHandle();
		System.out.println(childWindow);
		System.out.println(driver.getTitle());
	    // Click first contact link
	    driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
	    driver.switchTo().window(cWindow.get(0));
	    
	   
	    //click the widget of the 2nd contact
	    driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	    Thread.sleep(1000);
	    //using set
	    Set<String> sContact=driver.getWindowHandles();
	    //convert set into list
	    List<String> cWindow1=new ArrayList<String>(sContact);
	    driver.switchTo().window(cWindow1.get(1));
		String childWindow1 = driver.getWindowHandle();
		System.out.println(childWindow1);
		System.out.println(driver.getTitle());
	   
	    // Click second contact link
	    driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();
	    driver.switchTo().window(cWindow1.get(0));
	    
	    //click the merge
	    driver.findElement(By.xpath("//a[text()='Merge']")).click();
	    
	    //handle the alert
	    Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(4000);
		driver.close();
		
		
		
		
		
		
	      
		
		
		
	}

}
