package week4.day2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http:/www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		List<WebElement> namesColumn = driver.findElements(By.xpath("(//td[2])"));	

		List<String> list = new ArrayList<String>();
		
	
	for(WebElement nameList : namesColumn){
		list.add(nameList.getText());
	}
		   System.out.println(list);
		   Collections.sort(list);
		   System.out.println("The code sorted name list is" + list);
		   driver.findElement(By.xpath("//th[2]")).click();
		   List<WebElement> namesColumn1 = driver.findElements(By.xpath("(//td[2])"));
		   List<String> list2 = new ArrayList<String>();
		   for(WebElement nameList : namesColumn1){
				list2.add(nameList.getText());
			}
				   System.out.println("The table sorted name list is " + list2);
		   
				   if (list.equals(list2) == true) {
			            System.out.println(" name List are equal"); 
	}}}