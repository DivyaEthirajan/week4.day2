package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("https://www.nykaa.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
WebElement brandElement= driver.findElement(By.xpath("//a[text()='brands']"));
Actions builder = new Actions(driver);
builder.moveToElement(brandElement).perform();
driver.findElement(By.xpath("//a[contains(text(),'Paris')]")).click();
driver.findElement(By.xpath("(//*[local-name()='svg' and @class='arrow-icon'])[1]")).click();
driver.findElement(By.xpath("//label[@for='radio_customer top rated_undefined']/div[2]")).click();
Thread.sleep(2000);
System.out.println(driver.findElement(By.xpath("//span[@class='sort-name']")).getText());
driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.ARROW_DOWN, Keys.ARROW_DOWN);
driver.findElement(By.xpath("(//*[local-name()='svg' and @class='arrow-icon'])[2]")).click();
driver.findElement(By.xpath("(//*[local-name()='svg' and @class='arrow-icon'])[2]")).click();
driver.findElement(By.xpath("(//*[local-name()='svg' and @class='arrow-icon'])[2]")).click();
driver.findElement(By.xpath("//span[text()='Shampoo']/parent::div/following-sibling::div")).click();

driver.findElement(By.xpath("//span[text()='Concern']/parent::div//div[@class='filter-action']//*[local-name()='svg']")).click();
//span[text()='Color Protection']//parent::div/following-sibling::div
driver.findElement(By.xpath("//span[text()='Color Protection']//parent::div/following-sibling::div")).click();

driver.findElement(By.xpath("//div[@class='css-1rd7vky']/div")).click();
String filterValue= driver.findElement(By.xpath("(//span[@class='filter-value'])[1]")).getText();
String shampoo = "Shampoo";
if(filterValue.equals(shampoo)) {
	System.out.println("The filter is "+ filterValue);
}
Set<String> windows= driver.getWindowHandles();
List<String>WindowList = new ArrayList<String>(windows);
driver.switchTo().window(WindowList.get(1));
Select quantityValue = new Select(driver.findElement(By.xpath("//select[@title='SIZE']")));
quantityValue.selectByValue("1");
System.out.println("the MRP is "+ driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText());
driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();

driver.findElement(By.xpath("//div[@aria-label='Kebab menu']/parent::div/following-sibling::div//*[local-name()='svg' and @fill='none']")).click();
driver.switchTo().frame(0);
List<WebElement> tableRows =driver.findElements(By.className("table-row"));
String grandTotal = tableRows.get(tableRows.size()-1).getText();
System.out.println(grandTotal);
driver.findElement(By.xpath("//span[text()='PROCEED']")).click();
driver.switchTo().defaultContent();
driver.findElement(By.xpath("//button[contains(text(),'CONTINUE')]")).click();
System.out.println(driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div/span")).getText());
	}




}
