package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		WebElement mergeContacts=driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_contacts']"));
		
		if(mergeContacts.isDisplayed()) {
			System.out.println(mergeContacts.getText());
		}else System.out.println("Merge Contact not popped up on screen");
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> urls = driver.getWindowHandles();
		List<String> windowHandleFindContact = new ArrayList<String>(urls);
		String FindContactWindow = windowHandleFindContact.get(1);
		driver.switchTo().window(FindContactWindow);
	System.out.println(	driver.getCurrentUrl());
	/*List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class='x-panel-body xedit-grid']//tr[1]"));
		
		WebElement firstRow = tableRows.get(0);
		List<WebElement> tableColumn=firstRow.findElements(By.tagName("td"));
		WebElement firstCellData = tableColumn.get(0);
		firstCellData.click();*/
	Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-panel-body xedit-grid']//tr[1])[3]/td[1]/div/a")).click();
				
		String MergePage = windowHandleFindContact.get(0);
		driver.switchTo().window(MergePage);
		System.out.println(	driver.getCurrentUrl());
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> urls1 = driver.getWindowHandles();
		List<String> windowHandleFindContact1 = new ArrayList<String>(urls1);
		String FindContactWindow1 = windowHandleFindContact1.get(1);
		driver.switchTo().window(FindContactWindow1);
		System.out.println(	driver.getCurrentUrl());
/*List<WebElement> tableRows1 = driver.findElements(By.xpath("//div[@class='x-panel-body xedit-grid']//tr[1]"));
		WebElement firstRow1 = tableRows1.get(0);
		List<WebElement> tableColumn1=firstRow1.findElements(By.tagName("td"));
		WebElement firstCellData1 = tableColumn1.get(0);
		firstCellData1.click();*/
		Thread.sleep(2000);
driver.findElement(By.xpath("(//div[@class='x-panel-body xedit-grid']//tr[1])[2]/td[1]//div/a")).click();
		
		driver.switchTo().window(MergePage);
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		System.out.println(	driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
	}

}
