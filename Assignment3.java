package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http:/www.leafground.com/pages/disapper.html");
		driver.manage().window().maximize();
		WebElement disappearBox = driver.findElement(By.xpath("//button[@id='btn']"));
		Thread.sleep(3000);

		if (disappearBox.isDisplayed()) {
			System.out.println("The button is available");
		} else {
			String textMessage = driver.findElement(By.xpath("//Strong")).getText();
			System.out.println(textMessage);
			System.out.println("the box is available:" + disappearBox.isDisplayed());
		
		}
	}

}
