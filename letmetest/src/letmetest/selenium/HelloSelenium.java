package letmetest.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloSelenium {
	public static WebDriver driver = new FirefoxDriver();

	static {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {
		tutorialsPoint();
	}

	public static void googleDemo() {
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();

		// OPTION-1
		// driver.findElement(By.xpath(".//*[@id='lst-ib']")).sendKeys("JAVA");

		// OPTION-2
		driver.findElement(By.id("lst-ib")).sendKeys("INDIA");

		driver.close();
	}

	public static void caclulatorNet() {
		driver.navigate().to("http://www.calculator.net/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath(".//*[@id='menu']/div[3]/a")).click();
		driver.findElement(By.xpath(".//*[@id='menu']/div[4]/div[3]/a")).click();

		driver.findElement(By.id("cpar1")).sendKeys("10");
		driver.findElement(By.id("cpar2")).sendKeys("50");

		driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]")).click();

		String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();
		System.out.println(" The Result is " + result);

		driver.close();
	}

	public static void tutorialsPoint() {
		driver.navigate().to("http://www.tutorialspoint.com/selenium/");
		driver.manage().window().maximize();

		// html/body/div[3]/div[1]/div/div[2]/div[1]/div/div[3]/a
		WebElement webElement = driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[2]/div[1]/div/div[3]/a"));
		webElement.click();

		while (true) {
			try {
				WebElement elem1 = null;
				elem1 = driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[2]/div[1]/div/div[7]/a"));

				if (elem1 != null) {
					webElement = driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[2]/div[1]/div/div[3]/a"));
					webElement.click();
				} else {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}

		driver.close();
	}

}
