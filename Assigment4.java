package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assigment4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http:/www.leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30)); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Click ME')]")));
		
		driver.findElement(By.xpath("//button[@onclick='clicked()']")).click();
		Alert alertPopUp = driver.switchTo().alert();
		System.out.println(alertPopUp.getText());
		alertPopUp.accept();
	}

}
