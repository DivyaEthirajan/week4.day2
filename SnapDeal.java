 package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[@id='pushDenied']")).click();
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("(//li//span[2])[1]"))).perform();
		
				driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
				String totalShoes =driver.findElement(By.xpath("//h1[@category='Sports Shoes for Men']/parent::div//span")).getText();
				System.out.println(totalShoes);
				driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
				driver.findElement(By.xpath("//ul[@class='sort-value']//li[@data-index='1']")).click();
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
				
				driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
				driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900",Keys.TAB,"1200");
				driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
				System.out.println(driver.findElement(By.xpath("(//a[@data-key='Price|Price'])[1]")).getText());
				//List<WebElement> section=driver.findElements(By.xpath("//div[@class='product-row js-product-list centerCardAfterLoadWidgets dp-click-widgets']/section"));
//for(int i=0;i<section.size();i++) {
	List<WebElement> div = driver.findElements(By.xpath("//div[@class='product-desc-rating ']/a/p"));
	{for (int j=0;j<div.size();j++) {
		String shoeName= div.get(j).getText();
		System.out.println(shoeName);
	}}
	builder.moveToElement(driver.findElement(By.xpath("(//picture[@class='picture-elem'])[1]"))).perform();
	driver.findElement(By.xpath("(//div[contains(text(),'Quick')])[1]")).click();
	Set<String> win = driver.getWindowHandles();
	List<String> win1=new ArrayList<String>(win);
	driver.switchTo().window(win1.get(0));
	//driver.switchTo().frame(0);
	System.out.println(driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText());
	System.out.println(driver.findElement(By.xpath("//span[@class='payBlkBig']/following-sibling::span")).getText());
	WebElement shoeScreen= driver.findElement(By.xpath("//img[@itemprop='image']"));
	File source  = shoeScreen.getScreenshotAs(OutputType.FILE);
	File Dest = new File("./src/main/resources/snaps/SnapDeal001");
	FileUtils.copyFile(source, Dest);
	//driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
	driver.close();
	
	
	
	}
		
	}
	

	


	


