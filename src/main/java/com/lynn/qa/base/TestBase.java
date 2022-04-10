package com.lynn.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.lynn.qa.utils.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	// Initializing all the base properties

	public TestBase() {
		// Inside here, we read all the properties

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\Test_POM_Sample\\src\\main\\java\\com\\lynn\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void Initialization() {

		try {
			String browserName = prop.getProperty("browser");
			String os = System.getProperty("os.name");
			System.out.println("BROWSER NAME " + browserName);
			System.out.println("OS = " + os);

			if (browserName.equals("chrome")) {
				if (os.startsWith("Windows")) {
					System.setProperty("webdriver.chrome.silentOutput", "true");
					System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
				}

				else if (os.startsWith("Mac")) {
					System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
				}

				else {
					throw new IllegalStateException("not able to run tests on this machine");
				}

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--disable-notifications");
				options.addArguments("--window-size=2000,1180");

				driver = new ChromeDriver();
			}

			System.out.print("BROWSER LOADED SUCCESSFULLY!!!");

			driver.manage().window().maximize();

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

			driver.get(prop.getProperty("URL"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}
}
