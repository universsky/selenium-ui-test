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

import ui.test.tools.DBTool;
import ui.test.tools.ReportTool;
import ui.test.tools.WebTool;

/**
 * @author chenguangjian 2015年3月30日 下午5:24:21
 */
public class Register {

	private static final String url = TCData.getString("LoginTest.url"); //$NON-NLS-1$

	public synchronized WebDriver doRegister(String tcKey) {
		WebDriver driver = WebTool.initFirefoxDriver();

		String tcValue = new DBTool().getTcValueBytcKey(tcKey);

		try {

			driver.get(url);

			// click free register
			driver.findElement(
					By.xpath(TCData.getString("Register.free_register"))) //$NON-NLS-1$
					.click();

			((JavascriptExecutor) driver).executeScript(tcValue); //$NON-NLS-1$

			// register
			// driver.findElement(
			//					By.xpath(TCData.getString("Register.register_button"))) //$NON-NLS-1$
			// .click();

			// // check the agree box
			// driver.findElement(
			//					By.xpath(TCData.getString("Register.agree_check"))).click(); //$NON-NLS-1$
			//
			// // click button register
			// driver.findElement(
			//					By.xpath(TCData.getString("Register.register_button"))) //$NON-NLS-1$
			// .click();

			return driver;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
