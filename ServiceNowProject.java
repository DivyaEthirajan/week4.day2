package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowProject {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev117988.service-now.com");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='user_name']")));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");

		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("AmmuKutty@14");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Logged into service now page");
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident",Keys.ENTER);
		
		driver.findElement(By.xpath("//ul[@aria-label='Modules for Application: Incident']/li[6]//div[text()='All']")).click();
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//button[@value='sysverb_new']")).click();
		
		driver.findElement(By.xpath("//button[@name='lookup.incident.caller_id']/span")).click();
		Set<String> Windows= driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(Windows);
		String lookUpWindow = windowsList.get(1);
		driver.switchTo().window(lookUpWindow);
		WebElement lookUpTable = driver.findElement(By.xpath("//table[@id='sys_user_table']"));
		List<WebElement> tabeRows = lookUpTable.findElements(By.xpath("//tr"));
		WebElement firstRow = tabeRows.get(3);
		
		List<WebElement> tabeColumn = firstRow.findElements(By.xpath("//tr"));
		WebElement firstCellData = tabeColumn.get(3);
		System.out.println(firstCellData.getText());
		
	firstCellData.findElement(By.tagName("a")).click();
	
	String lookUpWindow1 = windowsList.get(0);
	driver.switchTo().window(lookUpWindow1);
	System.out.println(driver.getCurrentUrl());
	driver.switchTo().frame(0);
	driver.findElement(By.xpath("//input[@name='incident.short_description']")).sendKeys("This short description for testing purpose only");
	System.out.println(driver.findElement(By.id("incident.number")).getAttribute("value"));
	String incidentNum = driver.findElement(By.id("incident.number")).getAttribute("value");
	driver.findElement(By.xpath("//span/button[@value='sysverb_insert']")).click();
	driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Search']")).sendKeys(incidentNum,Keys.ENTER);
	String incidentNumber = driver.findElement(By.xpath("(//table//tr)[4]/td[3]/a")).getText();
	if(incidentNumber.equals(incidentNum)) {
		System.out.println("The incident ticket created successfully");
	}
	
		
		
		

	}

}
