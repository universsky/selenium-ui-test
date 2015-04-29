/**
 * 
 */
package ui.test.tools;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import ui.test.constant.Const;

/**
 * @author chenguangjian 2015年4月1日 下午9:15:49
 */

public class ReportTool {

	/**
	 * 
	 * @param tcKey
	 * @param driver
	 * @param tcResult
	 * @param expected
	 * @param actual
	 * @param log
	 * @param timestamp
	 * @throws WebDriverException
	 * @throws IOException
	 */

	public static void record(String tcKey, WebDriver driver, String tcResult,
			String expected, String actual, String log, String timestamp)
			throws WebDriverException, IOException {

		File f = WebTool.takeScreenShot(driver, tcKey);
		String imgName = f.getName();
		// System.out.println(imgName);

		DBTool DBTool = new DBTool();
		DBTool.insertTcResult(tcKey, timestamp, imgName, tcResult, expected,
				actual, log);

		WebTool.upload(Const.uploadUrl, f);

		// driver.close();

	}

	/**
	 * 
	 * @param tcKey
	 * @param driver
	 * @param tcResult
	 * @param expected
	 * @param actual
	 * @param log
	 * @throws WebDriverException
	 * @throws IOException
	 */
	public static void record(String tcKey, WebDriver driver, String tcResult,
			String expected, String actual, String log)
			throws WebDriverException, IOException {

		File f = WebTool.takeScreenShot(driver, tcKey);
		String imgName = f.getName();
		// System.out.println(imgName);

		DBTool DBTool = new DBTool();
		DBTool.insertTcResult(tcKey, Const.timestamp, imgName, tcResult,
				expected, actual, log);

		WebTool.upload(Const.uploadUrl, f);

		driver.close();

	}

}
