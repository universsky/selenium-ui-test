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
	 * @param tcKey
	 * @throws WebDriverException
	 * @throws IOException
	 */
	public static void record(String tcKey, WebDriver driver, String tcResult)
			throws WebDriverException, IOException {

		File srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		// String img_name = srcFile.getName();
		// DBTool.insertImgName(img_name);

		File f = WebTool.takeScreenShot(driver, tcKey);
		WebTool.upload(Const.uploadUrl, f);

		String imgName = f.getName();
		System.out.println(imgName);
		DBTool DBTool = new DBTool();
		DBTool.insertImgName(tcKey, Const.timestamp, imgName, tcResult);

	}

}
