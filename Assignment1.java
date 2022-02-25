package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http:/www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		WebElement table = driver.findElement(By.xpath("//table[@class='display']"));
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		List<WebElement> tableColumns = table.findElements(By.tagName("th"));

		WebElement row3 = tableRows.get(2);
		List<WebElement> columnValuesOfRow3 = row3.findElements(By.tagName("td"));
		System.out.println("numbre of rows in table:" + tableRows.size());

		System.out.println("number of columns in table:" + tableColumns.size());

		System.out.println(columnValuesOfRow3.get(0).getText() + "progress% is " + columnValuesOfRow3.get(1).getText());
		WebElement row4 = tableRows.get(3);
		List<WebElement> columnValuesOfRow4 = row4.findElements(By.tagName("td"));
		List<WebElement> progressColumn = driver.findElements(By.xpath("//tr/td[2]"));
		String leastPercentageValue = "30%";
		for (int i=0;i<progressColumn.size();i++) {
			String ProgressValue = progressColumn.get(i).getText();
			System.out.println(ProgressValue);
						if (ProgressValue.equals(leastPercentageValue)) {
							System.out.println("got into if loop");

				 WebElement progressCheckBox = columnValuesOfRow4.get(2);
				 progressCheckBox.click();

				//driver.findElement(By.xpath("(//input[@name='vital'])[3]")).click();
			}
		}

		// driver.close();

	}
}
