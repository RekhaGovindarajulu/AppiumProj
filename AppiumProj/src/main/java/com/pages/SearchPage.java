package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SearchPage {

	AndroidDriver<MobileElement> androidDriver;
	AndroidTouchAction touchActions;
	Util util = new Util();
	
	// page locators
	private By search = By.xpath("//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.ImageView");
	private By searchtext = By.id("cm.aptoide.pt:id/search_src_text");
	private By applink = By.xpath("//*[contains(@text,'Amazon Fire TV')]");
	private By installbtn = By.id("cm.aptoide.pt:id/appview_install_button");
	private By button1 = By.id("android:id/button1");
	private By allowbutton = By.id("com.android.permissioncontroller:id/permission_allow_button");
	private By installbtn1 = By.id("cm.aptoide.pt:id/appview_install_button");
	private By button2 = By.id("android:id/button1");
	private By button3 = By.id("cm.aptoide.pt:id/appview_install_button");
	private By more = By.xpath("//android.widget.TextView[@text='More']");
	private By appversion = By.xpath("//android.widget.TextView[@text='2.3.10.0-aosp']");

	// constructor
	public SearchPage(AndroidDriver<MobileElement> androidDriver) {
		this.androidDriver = androidDriver;
	}

	// page methods
	public String installApp() {

		WebDriverWait wait = new WebDriverWait(androidDriver, 10);

		androidDriver.findElement(search).click();
		androidDriver.findElement(searchtext).sendKeys("Amazon");
		androidDriver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
		util.sleep(5);

		while (androidDriver.getPageSource().contains("Amazon Fire TV") == false) {
			swipeDown();
		}
		util.sleep(2);
		androidDriver.findElement(applink).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(installbtn));
		androidDriver.findElement(installbtn).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(button1));
		androidDriver.findElement(button1).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(allowbutton));
		androidDriver.findElement(allowbutton).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(installbtn1));
		androidDriver.findElement(installbtn1).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(button2));
		androidDriver.findElement(button2).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(button3));
		androidDriver.findElement(button3).click();

		util.sleep(5);
		androidDriver.findElement(more).click();
		String version = androidDriver.findElement(appversion).getText();
		return version;
	}

	public void swipeDown() {
		touchActions = new AndroidTouchAction(androidDriver);
		int deviceHeight = androidDriver.manage().window().getSize().getHeight();
		int deviceWidth = androidDriver.manage().window().getSize().getWidth();

		int startX = (int) (deviceWidth * .5);
		int endX = (int) (deviceWidth * .5);
		int startY = (int) (deviceHeight * .6);
		int endY = (int) (deviceHeight * .05);

		touchActions.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(startX, startY)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

	}
}
