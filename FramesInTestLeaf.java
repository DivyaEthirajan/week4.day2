package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesInTestLeaf {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("Click")).click();
		System.out.println("The first click me button is clicked");
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./src/main/resources/snaps/Img001");
		FileUtils.copyFile(source, destination);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click1")).click();
		System.out.println("The second click me button is clicked");
		driver.switchTo().defaultContent();
		List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
		System.out.println(frameList.size());
		driver.switchTo().frame(2);
		
		List<WebElement> frameList1 = driver.findElements(By.tagName("iframe"));
		System.out.println(frameList1.size());
		

	}

}
