package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3day2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.tagName("input")).sendKeys("Divya",Keys.TAB);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		Select animalSelection = new Select(driver.findElement(By.id("animals")));
		animalSelection.selectByValue("avatar");
		
driver.switchTo().defaultContent();
System.out.println(driver.getCurrentUrl());
driver.close();
	}

}
