/**
 * 
 */
package ui.test.tools;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ui.test.constant.Const;

/**
 * @author chenguangjian 2015年3月30日 下午3:21:16
 */
public class WebTool {

	public static void takeScreenShot(WebDriver driver, String tcKey) {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		try {
			File toPath = new File(Messages.getString("WebTool.img_save_pth") //$NON-NLS-1$
					+ Const.timestamp
					+ Messages.getString("WebTool.path_separator")); //$NON-NLS-1$
			if (!toPath.exists()) {
				toPath.mkdirs();
			}

			File toFile = new File(
					Messages.getString("WebTool.img_save_pth") //$NON-NLS-1$
							+ Const.timestamp
							+ Messages.getString("WebTool.path_separator") + tcKey + Messages.getString("WebTool.img_suffix")); //$NON-NLS-1$ //$NON-NLS-2$
			Files.copy(scrFile, toFile); //$NON-NLS-1$ //$NON-NLS-2$

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
