/**
 * 
 */
package ui.test.tools;

import java.awt.Toolkit;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author chenguangjian 2015年3月30日 下午3:21:16
 */
public class WebTool {
	public static void main(String[] args) {
		String url = "http://10.1.1.182/Front/CIF_FNT/index.html";
		driverGet(url);
	}

	public static String driverGet(String url) {

		String html = null;

		System.setProperty(
				"webdriver.firefox.bin",
				"D:\\XMLRPC\\Firefox_Portable_33.1.1\\FirefoxPortable\\App\\Firefox\\firefox.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxProfile firefoxprofile = new FirefoxProfile(
				new File(
						"D:\\XMLRPC\\Firefox_Portable_33.1.1\\FirefoxPortable\\Data\\profile\\"));
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

		try {

			driver.get(url);
			// ((JavascriptExecutor) driver).executeScript("scrollTo(0,10000)");
			Thread.sleep(5000);
			// ��ȡ��ǰ��ҳԴ��
			html = driver.getPageSource();// ��ӡ��ҳԴ��

		} catch (Exception e) {// ��ӡ��ջ��Ϣ
			e.printStackTrace();
		} finally {
			try {// �رղ��˳�
				driver.close();
				driver.quit();
			} catch (Exception e) {
			}
		}
		return html;
	}

}
