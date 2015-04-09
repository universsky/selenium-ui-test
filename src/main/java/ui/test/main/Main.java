/**
 * 
 */
package ui.test.main;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;

import ui.test.constant.Const;

/**
 * @author chenguangjian
 *
 */

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 * @throws WebDriverException
	 */
	public static void main(String[] args) throws WebDriverException,
			IOException {
		Main m = new Main();
		m.goTest();

		m.report();
	}

	private void goTest() throws WebDriverException, IOException {

		LoginTest loginTest = new LoginTest();
		loginTest.testLoginSolutionTest();
		loginTest.testLoginPasswordIsEmpty();
		loginTest.testLoginPasswordIsWrong();
		loginTest.testLoginUserNameIsEmpty();
		loginTest.testLoginUserNameNotExist();

		RegisterTest registerTest = new RegisterTest();
		registerTest.testRegister();

	}

	private void report() {
		if (java.awt.Desktop.isDesktopSupported()) {
			try {
				String reportUriStr = Const.reportPath + Const.timestamp;
				// 创建一个URI实例
				java.net.URI reportUri = java.net.URI.create(reportUriStr);

				// 获取当前系统桌面扩展
				java.awt.Desktop dp = java.awt.Desktop.getDesktop();
				// 判断系统桌面是否支持要执行的功能
				if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
					// 获取系统默认浏览器打开链接
					dp.browse(reportUri);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
