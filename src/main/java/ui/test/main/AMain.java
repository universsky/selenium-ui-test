/**
 * 
 */
package ui.test.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import ui.test.constant.Const;
import ui.test.tools.TimeTool;
import ui.test.tools.WebTool;

/**
 * @author chenguangjian
 *
 */

public class AMain {

	/**
	 * @param args
	 * @throws IOException
	 * @throws WebDriverException
	 */
	public static void main(String[] args) throws WebDriverException,
			IOException {
		AMain m = new AMain();

		WebDriver driver = WebTool.initFirefoxDriver();

		m.goTest(driver);

		m.report();
	}

	private void goTest(WebDriver driver) throws WebDriverException,
			IOException {

		LoginTest loginTest = new LoginTest();
		loginTest.testLoginSolutionTest(driver);
		loginTest.testLoginPasswordIsEmpty(driver);
		loginTest.testLoginPasswordIsWrong(driver);
		loginTest.testLoginUserNameIsEmpty(driver);
		loginTest.testLoginUserNameNotExist(driver);

		RegisterTest registerTest = new RegisterTest();
		registerTest.testRegister(driver);

		MemberRegisterTest memberRegisterTest = new MemberRegisterTest();

		memberRegisterTest.解决方案测试(driver);
		memberRegisterTest.公司名称英文(driver);
		memberRegisterTest.公司名称3位中文(driver);
		memberRegisterTest.公司名称26位中文(driver);
		memberRegisterTest.公司名称非法字符(driver);
		memberRegisterTest.办公地址3个字(driver);
		memberRegisterTest.办公地址51个字(driver);
		memberRegisterTest.办公地址20个字(driver);
		memberRegisterTest.办公地址空校验(driver);
		memberRegisterTest.工商注册号14位数字(driver);
		memberRegisterTest.工商注册号1位数字(driver);
		memberRegisterTest.工商注册号空校验(driver);
		memberRegisterTest.法定代表人1个字(driver);
		memberRegisterTest.法定代表人5个字(driver);
		memberRegisterTest.法定代表人6个字(driver);
		memberRegisterTest.法定代表人空校验(driver);

		PartnerManageTest PartnerManageTest = new PartnerManageTest();
		PartnerManageTest.新增合作厂家测试(driver);

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
