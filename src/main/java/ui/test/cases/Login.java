/**
 * 
 */
package ui.test.cases;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import ui.test.constant.Const;
import ui.test.tools.DBTool;
import ui.test.tools.ReportTool;
import ui.test.tools.TimeTool;
import ui.test.tools.WebTool;

/**
 * @author chenguangjian 2015年3月30日 下午3:26:21
 */
public class Login {

	private static final String url = TCData.getString("LoginTest.url"); //$NON-NLS-1$

	/**
	 * 
	 * @param tcKey
	 */
	public synchronized WebDriver doLogin(String tcKey, WebDriver driver) {

		// WebDriver driver = WebTool.initFirefoxDriver();

		String tcValue = new DBTool().getTcValueBytcKey(tcKey);

		try {

			driver.get(url);
			((JavascriptExecutor) driver).executeScript(tcValue);
			// ((JavascriptExecutor) driver).executeAsyncScript(tcValue);
			//			String xpathExpression = TCData.getString("Login.loginXPath"); //$NON-NLS-1$
			// driver.findElement(By.xpath(xpathExpression)).click();
			TimeTool.delayMilliSeconds(3000L);

			// return driver;

		} catch (Exception e) {
			e.printStackTrace();
			// return null;
		}

		return driver;

	}

}
