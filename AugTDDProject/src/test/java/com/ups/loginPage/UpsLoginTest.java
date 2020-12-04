package com.ups.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpsLoginTest {

	WebDriver driver = null;

	public UpsLoginTest(WebDriver driver) {
		this.driver = driver;
	}

	public String upsLoginErrorTest() {

		WebElement closeCookieBanner;
		WebElement userId;
		WebElement password;
		WebElement logInBtn;
		WebElement errorMsg;
		String msg = null;

		closeCookieBanner = driver.findElement(By.xpath("//*[@id='__tealiumImplicitmodal']/div/button/span[1]"));
		userId = driver.findElement(By.id("email"));
		password = driver.findElement(By.name("password"));
		logInBtn = driver.findElement(By.cssSelector("#submitBtn"));

		closeCookieBanner.click();
		userId.sendKeys("username");
		password.sendKeys("password");
		logInBtn.click();

		errorMsg = driver.findElement(By.xpath("//*[@id='errorMessages']"));
		msg = errorMsg.getText();
		return msg;

	}
}
