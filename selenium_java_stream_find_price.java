import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium_java_stream_find_price {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("table[class='table table-bordered'] th:nth-child(1)")).click();

		List<String> price;
		
		do {
			List<WebElement>	listOfVeg =	driver.findElements(By.cssSelector("table[class='table table-bordered'] tr td:nth-child(1)"));
		 price =	listOfVeg.stream().filter(s-> s.getText().contains("Rice")).
				map(s->getPriceVeg(s)).collect(Collectors.toList());				
		price.forEach(a-> System.out.println(a));
		 if(price.size()<1) {
			driver.findElement(By.xpath("//*[@aria-label = 'Next']")).click();
		}
	}while(price.size()<1);
		
	}
	private static String getPriceVeg(WebElement s) {
		
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
