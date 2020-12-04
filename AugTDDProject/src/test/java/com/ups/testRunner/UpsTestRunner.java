package com.ups.testRunner;

import static org.testng.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ups.loginPage.UpsLoginTest;

public class UpsTestRunner {

	WebDriver driver;
	UpsLoginTest loginTest;

	@BeforeMethod
	void chromeDriverMethod() {
		this.driver = new ChromeDriver();
		this.loginTest = new UpsLoginTest(driver);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.get("https://www.ups.com/lasso/login?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	void loginTest() {
		String msg = loginTest.upsLoginErrorTest();
		if (msg.contains("ryrtyyrt")) {
			System.out.println("PASSED");
		} else {
			fail();
		}

	}

	@Test
	void noTest() {
		System.out.println("NO TEST");
	}

	@AfterMethod
	void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();

	}

}
