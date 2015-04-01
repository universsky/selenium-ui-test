/**
 * 
 */
package ui.test.cases;

import java.awt.Toolkit;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author chenguangjian 2015年3月30日 下午5:24:21
 */
public class Register {

	public Register() {
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

	public void doRegister(String tc) {

		try {

			driver.get(url);

			// click free register
			driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/a"))
					.click();

			((JavascriptExecutor) driver).executeScript(tc); //$NON-NLS-1$

			// register
			driver.findElement(
					By.xpath("//*[@id=\"pro_box\"]/div[2]/form/ul/li[7]/button"))
					.click();

			// check the agree box
			driver.findElement(By.id("agreeCheck")).click();

			// click button register
			driver.findElement(
					By.xpath("//*[@id=\"pro_box\"]/div[2]/form/ul/li[7]/button"))
					.click();

			Thread.sleep(5000);

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
