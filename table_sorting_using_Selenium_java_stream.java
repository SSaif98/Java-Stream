import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class table_sorting_using_Selenium_java_stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		System.out.println(driver.findElement(By.xpath("//span[text() = 'Veg/fruit name']")).getText());
	//	driver.findElement(By.cssSelector("table[class='table table-bordered'] th:nth-child(1)")).click();
		
		
		WebElement op= driver.findElement(By.id("page-menu"));
		Select options = new Select(op);
		options.selectByVisibleText("20");
		

	List<WebElement>	listOfVeg =	driver.findElements(By.cssSelector("table[class='table table-bordered'] tr td:nth-child(1)"));
	System.out.println("\nUnsorted List: \n");
	listOfVeg.stream().map(s-> s.getText()).forEach(s-> System.out.println(s));
	
	
	List<String>  originalList =	listOfVeg.stream().map(s-> s.getText()).collect(Collectors.toList());
	
	List<String>   sortedList =  originalList.stream().sorted().collect(Collectors.toList());
	
	System.out.println("\nSorted List: \n");
	sortedList.stream().forEach(s-> System.out.println(s));
	
	//Assert.assertEquals(sortedList, originalList);
	
	Assert.assertTrue(originalList.equals(sortedList));
	

	
	}



}
