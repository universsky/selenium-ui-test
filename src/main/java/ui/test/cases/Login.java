/**
 * 
 */
package ui.test.cases;

import java.awt.Toolkit;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import ui.test.tools.WebTool;

/**
 * @author chenguangjian 2015年3月30日 下午3:26:21
 */
public class Login {

	public Login() {
		super();
	}

	private static final String url = TCData.getString("LoginTest.url"); //$NON-NLS-1$
	private WebDriver driver;

	public void init() {
		System.setProperty(TCData.getString("LoginTest.firefox_bin"), //$NON-NLS-1$
				TCData.getString("LoginTest.firefox_bin_path")); //$NON-NLS-1$
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxProfile firefoxprofile = new FirefoxProfile(new File(
				TCData.getString("LoginTest.firefox_profile_path"))); //$NON-NLS-1$
		capabilities.setCapability(FirefoxDriver.PROFILE, firefoxprofile);

		driver = new FirefoxDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit()
				.getScreenSize();
		// set browser window size
		Dimension targetSize = new Dimension(screenSize.width,
				screenSize.height);
		driver.manage().window().setSize(targetSize);
		// set browser position

		// Point targetPosition = new Point(screenSize.width,
		// screenSize.height);
		Point targetPosition = new Point(0, 0);
		driver.manage().window().setPosition(targetPosition);
		// // WebDriver driver = new InternetExplorerDriver();
	}

	/**
	 * 
	 * @param tcKey
	 */
	public void doLogin(String tcKey) {

		String tcValue = TCData.getString(tcKey);

		try {

			driver.get(url);
			((JavascriptExecutor) driver).executeScript(tcValue);
			String xpathExpression = TCData.getString("Login.loginXPath"); //$NON-NLS-1$
			driver.findElement(By.xpath(xpathExpression)).click();

			Thread.sleep(5000);

			WebTool.takeScreenShot(driver, tcKey);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				driver.close();
				driver.quit();
			} catch (Exception e) {
			}
		}

	}
}
