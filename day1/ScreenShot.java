package week3.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {
	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		// driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Search for bags", Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement element = driver
				.findElement(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']"));
		String text = element.getText();
		System.out.println("Product Description " + text);
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		for (int i = 0; i < list.size(); i++) {
			String string = list.get(i).getText();
			System.out.println("Entire Price detalis: " + string);

		}
		File source = driver.getScreenshotAs(OutputType.FILE);

		File destination = new File("./sam/amazon.png");

		FileUtils.copyFile(source, destination);

	}

}
