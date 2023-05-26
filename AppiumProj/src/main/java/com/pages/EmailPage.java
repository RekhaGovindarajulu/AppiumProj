package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class EmailPage {

	AndroidDriver<MobileElement> androidDriver;
	Util util = new Util();
	
	// page locators
	private By storesbtn = By.xpath("//android.widget.TextView[@text='Stores']");
	private By loginbtn = By.id("cm.aptoide.pt:id/tc_checkbox");
	private By checkbox = By.id("cm.aptoide.pt:id/tc_checkbox");
	private By login = By.id("cm.aptoide.pt:id/show_login_with_aptoide_area");
	private By email = By.id("cm.aptoide.pt:id/email");
	private By sendlink = By.id("cm.aptoide.pt:id/send_magic_link_button");

	// constructor
	public EmailPage(AndroidDriver<MobileElement> androidDriver) {
		this.androidDriver = androidDriver;
	}

	// page methods
	public void sendEmail() {
		androidDriver.findElement(storesbtn).click();
		WebDriverWait wait = new WebDriverWait(androidDriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginbtn));
		androidDriver.findElement(loginbtn).click();
		androidDriver.findElement(checkbox).click();
		androidDriver.findElement(login).click();
		androidDriver.findElement(email).sendKeys("rekhablore@mailinator.com/");
		androidDriver.findElement(sendlink).click();
		util.sleep(2);
	}

}
