import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class filterTableUsingStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
	List<WebElement> listVegie= 	driver.findElements(By.xpath("//tr/td[1]"));
	
 Long riceCount =	listVegie.stream().filter(s-> s.getText().contains("Rice")).count();
 
 	List<WebElement> filteredList	=listVegie.stream().filter(s-> s.getText().contains("Rice")).collect(Collectors.toList());
 	
 	Assert.assertTrue(listVegie.equals(filteredList));
 	
 	Assert.assertEquals(listVegie.size(), filteredList.size());
 	
 	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src,new File("D://screenshot.png"));
	
 	
 	System.out.println(riceCount);
	}

}
