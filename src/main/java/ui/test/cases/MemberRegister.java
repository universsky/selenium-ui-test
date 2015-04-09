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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.test.constant.Const;
import ui.test.tools.DBTool;
import ui.test.tools.TimeTool;

/**
 * @author chenguangjian
 *
 */
public class MemberRegister {
	private static Logger logger = LoggerFactory
			.getLogger(MemberRegister.class);

	public synchronized WebDriver doMemberRegister(String tcKey) {

		System.setProperty(TCData.getString("LoginTest.firefox_bin"), //$NON-NLS-1$
				TCData.getString("LoginTest.firefox_bin_path")); //$NON-NLS-1$
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxProfile firefoxprofile = new FirefoxProfile(new File(
				TCData.getString("LoginTest.firefox_profile_path"))); //$NON-NLS-1$
		capabilities.setCapability(FirefoxDriver.PROFILE, firefoxprofile);

		WebDriver driver = new FirefoxDriver(capabilities);
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

		String tcValue = new DBTool().getTcValueBytcKey(tcKey);

		try {

			driver.get(Const.homeUrl);
			TimeTool.delayMilliSeconds(1000L);
			logger.info(tcValue);

			// 未注册会员用户，登陆
			((JavascriptExecutor) driver).executeScript(new DBTool()
					.getTcValueBytcKey("LoginTest.SolutionTest未申请会员"));

			TimeTool.delayMilliSeconds(1000L);

			((JavascriptExecutor) driver).executeScript(tcValue);

			driver.findElement(
					By.xpath(TCData.getString("MemberRegister.submit_button")))
					.click();
			TimeTool.delayMilliSeconds(1000L);

			return driver;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
