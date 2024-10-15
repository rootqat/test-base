package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties pro;

	public BaseClass() {
		try {
			pro = new Properties();
			FileInputStream fis = new FileInputStream(
					"D:\\Java\\FrameworkNew\\src\\main\\java\\configuration\\config.properties");
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public static void setup() {
		String browserName = pro.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();

			chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(pro.getProperty("baseurl"));
	}

	public String takeScreenshot(String testMethodName, WebDriver driver) throws IOException {

		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testMethodName + ".png";
		File destinationFile = new File(destinationFilePath);
		FileUtils.copyFile(SourceFile, destinationFile);
		return destinationFilePath;

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
