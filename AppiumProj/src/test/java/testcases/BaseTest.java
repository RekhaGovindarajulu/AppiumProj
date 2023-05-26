package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pages.EmailPage;
import com.pages.SearchPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public abstract class BaseTest {

	protected AndroidDriver<MobileElement> androidDriver;

	// object repo
	protected SearchPage searchpage;
	protected EmailPage emailpage;

	@BeforeMethod
	public void setupAndroidDriver() {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		caps.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\shrek\\OneDrive\\Dokumente\\simplilearn\\installs\\shoppingProject.apk");

		try {
			androidDriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		initializePageObjects();
	}

	public void initializePageObjects() {
		searchpage = new SearchPage(androidDriver);
		emailpage = new EmailPage(androidDriver);
	}

	@AfterMethod
	public void cleanUp() {
		androidDriver.quit();

	}

}
