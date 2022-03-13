package br.nttdata.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static WebDriverWait wait;

	@BeforeClass
	public static void beforeSuite() throws IOException {

		if (driver == null) {
			System.out.println(System.getProperty("user.dir"));
			Properties config = new Properties();
			FileInputStream fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\Config.properties");
			config.load(fileInputStream);

			switch (config.getProperty("browser")) {
			case "firefox": {

				System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\executables\\geckodriver.exe");
				ProfilesIni profile = new ProfilesIni();
				FirefoxProfile testprofile = profile.getProfile("SeleniumProfile");
				FirefoxOptions opt = new FirefoxOptions();
				opt.setProfile(testprofile);
				driver = new FirefoxDriver(opt);
				break;
			}
			case "opera": {

				System.setProperty("webdriver.opera.driver", "src\\test\\resources\\executables\\operadriver.exe");

				DesiredCapabilities capabilities = new DesiredCapabilities();
				OperaOptions options = new OperaOptions();
				options.setBinary("src\\test\\resources\\executables\\operadriver.exe");
				capabilities.setCapability(OperaOptions.CAPABILITY, options);

				driver = new org.openqa.selenium.opera.OperaDriver();
				break;
			}

			case "chrome": {

				ChromeOptions ops = new ChromeOptions();
				ops.addArguments("--disable-notifications");

				System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver(ops);
				break;
			}
			case "ie": {

				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

				System.setProperty("webdriver.ie.driver", "src\\test\\resources\\executables\\IEDriverServer.exe");

				driver = new InternetExplorerDriver(capabilities);
				break;
			}
			case "edge": {

				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			}
			default: {

				System.out.println("Webdriver não informado. " + "Escolha entre: chrome, firefox, ie, edge ou opera.");
			}
			}
			driver.get(config.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Long.parseLong(config.getProperty("timeouts")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 20);
		}

	}

//	@After
//	public static void clearCookiesAfter() throws Exception {
//		driver.manage().deleteAllCookies();
//	}

	@AfterEach
	public static void clearCookiesBefore() throws Exception {
		driver.manage().deleteAllCookies();

	}

	@AfterAll
	public static void afterAll() throws InterruptedException {
		if (null != driver) {
			Thread.sleep(2000);
			driver.close();
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}

	@AfterClass
	public static void teardDown() throws InterruptedException {
		driver.quit();
	}

}
