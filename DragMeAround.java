package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragMeAround {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable/");
		System.out.println(driver.findElement(By.className("entry-title")).getText());
		driver.switchTo().frame(0);
		Actions dragMe= new Actions(driver);
		dragMe.dragAndDropBy(driver.findElement(By.id("draggable")), 30, 30).build().perform();
		WebDriverManager.chromedriver().setup();
	WebDriver newWin=driver.switchTo().newWindow(WindowType.TAB);
	newWin.get("https://jqueryui.com/droppable/");
	driver.switchTo().frame(0);
	Actions dragAndDropMe = new Actions(driver);
	WebElement source = driver.findElement(By.id("draggable"));
	WebElement target = driver.findElement(By.id("droppable"));
	dragAndDropMe.dragAndDrop(source, target).build().perform();

	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://jqueryui.com/selectable/");
	driver.switchTo().frame(0);
	Actions select = new Actions(driver);
	List<WebElement> selectItems = driver.findElements(By.className("ui-selectable"));
	for(WebElement items:selectItems) {
		
		
	
	
	select.keyDown(Keys.CONTROL).click(items).keyUp(Keys.CONTROL).perform();
	
	//driver.close();

}
	

	WebDriver newWin1=driver.switchTo().newWindow(WindowType.TAB);
	newWin1.get("https://jqueryui.com/resizable/");
	driver.switchTo().frame(0);
	Actions reSize = new Actions(driver);
	WebElement source1 = driver.findElement(By.xpath("//div[@id='resizable']//div[3]"));
	reSize.dragAndDropBy(source1, 100, 100).perform();
	
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://jqueryui.com/selectable/");
		driver.switchTo().frame(0);
		Actions select1 = new Actions(driver);
		List<WebElement> selectItems1 = driver.findElements(By.className("ui-selectable"));
		for(WebElement items:selectItems) {
			
			
		
		
		select.keyDown(Keys.CONTROL).click(items).keyUp(Keys.CONTROL).perform();
		
		//driver.close();

	}

}
}