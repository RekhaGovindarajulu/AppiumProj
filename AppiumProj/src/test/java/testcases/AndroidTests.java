package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidTests extends BaseTest {

	@Test
	public void testInstallApp() {
		String appversion = searchpage.installApp();
		Assert.assertEquals(appversion, "2.3.10.0-aosp");
	}

	@Test
	public void testSendEmail() {
		emailpage.sendEmail();
	}

}
