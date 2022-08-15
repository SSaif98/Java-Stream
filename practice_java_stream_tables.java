import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice_java_stream_tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Selenium//SQA Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//span[text() = 'Veg/fruit name']")).click();

		List<WebElement> vegieList = driver
				.findElements(By.cssSelector("table[class='table table-bordered'] td:nth-child(1)"));

		List<String> originalList = vegieList.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		Assert.assertTrue(originalList.equals(sortedList));
		List<String> priceList;
		do {
			List<WebElement> vegieList1 = driver
					.findElements(By.cssSelector("table[class='table table-bordered'] td:nth-child(1)"));
		priceList = vegieList1.stream().filter(s -> s.getText().contains("Rice")).map(s -> getVegiePrice(s))
				.collect(Collectors.toList());
		priceList.forEach(a -> System.out.println(a));
		
		if(priceList.size()<1) {
		driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		
		}while(priceList.size()<1);
	}

	private static String getVegiePrice(WebElement s) {

		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
