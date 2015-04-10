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
import ui.test.tools.WebTool;

/**
 * @author chenguangjian
 *
 */
public class MemberRegister {
	private static Logger logger = LoggerFactory
			.getLogger(MemberRegister.class);

	public synchronized WebDriver doMemberRegister(String tcKey) {

		WebDriver driver = WebTool.initWebDriver();

		String tcValue = new DBTool().getTcValueBytcKey(tcKey);

		try {

			driver.get(Const.homeUrl);
			TimeTool.delayMilliSeconds(1000L);
			logger.info(tcValue);

			// 未注册会员用户，登陆
			((JavascriptExecutor) driver)
					.executeScript(new DBTool()
							.getTcValueBytcKey("LoginTest.SolutionTestNotMemberRegistered"));

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
