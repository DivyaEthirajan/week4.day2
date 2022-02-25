package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http:/www.leafground.com/pages/appear.html");
		driver.manage().window().maximize();
		List<WebElement> buttonList = driver.findElements(By.xpath("//div[@class='flex']/button"));
		List<String> buttonNames = new ArrayList<String>();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//b[contains(text(),'here Guys')]"))));
		
		for(WebElement button:buttonList) {
			buttonNames.add(button.getText());}
			System.out.println(buttonNames);
		}
		
	

}
