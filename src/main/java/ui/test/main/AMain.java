/**
 * 
 */
package ui.test.main;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

		// chrome
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date());
		WebDriver driver = WebTool.initChromeDriver();

		m.goTest(driver, timestamp);

		// // internet explorer
		// driver = WebTool.initInternetExplorerDriver();
		// timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new
		// Date());
		// m.goTest(driver, timestamp);
		//
		// // firefox
		// driver = WebTool.initFirefoxDriver();
		// timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new
		// Date());
		// m.goTest(driver, timestamp);

		driver.close();
		driver.quit();

	}

	private synchronized void goTest(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		// 登陆测试
		LoginTest loginTest = new LoginTest();
		loginTest.testLoginSolutionTest(driver, timestamp);
		loginTest.testLoginPasswordIsEmpty(driver, timestamp);
		loginTest.testLoginPasswordIsWrong(driver, timestamp);
		loginTest.testLoginUserNameIsEmpty(driver, timestamp);
		loginTest.testLoginUserNameNotExist(driver, timestamp);

		// 注册测试
		RegisterTest registerTest = new RegisterTest();
		registerTest.testRegister(driver, timestamp);

		// 申请会员测试
		MemberRegisterTest memberRegisterTest = new MemberRegisterTest();

		memberRegisterTest.解决方案测试(driver, timestamp);
		memberRegisterTest.公司名称英文(driver, timestamp);
		memberRegisterTest.公司名称3位中文(driver, timestamp);
		memberRegisterTest.公司名称26位中文(driver, timestamp);
		memberRegisterTest.公司名称非法字符(driver, timestamp);
		memberRegisterTest.办公地址3个字(driver, timestamp);
		memberRegisterTest.办公地址51个字(driver, timestamp);
		memberRegisterTest.办公地址20个字(driver, timestamp);
		memberRegisterTest.办公地址空校验(driver, timestamp);
		memberRegisterTest.工商注册号14位数字(driver, timestamp);
		memberRegisterTest.工商注册号1位数字(driver, timestamp);
		memberRegisterTest.工商注册号空校验(driver, timestamp);
		memberRegisterTest.法定代表人1个字(driver, timestamp);
		memberRegisterTest.法定代表人5个字(driver, timestamp);
		memberRegisterTest.法定代表人6个字(driver, timestamp);
		memberRegisterTest.法定代表人空校验(driver, timestamp);

		// 新增合作厂家
		PartnerManageTest PartnerManageTest = new PartnerManageTest();
		PartnerManageTest.新增合作厂家测试(driver, timestamp);

		// 申请贷款测试
		LoanApplyTest LoanApplyTest = new LoanApplyTest();
		LoanApplyTest.我要贷款解决方案测试(driver, timestamp);

		// 生成报告
		report(timestamp);

	}

	private void report(String timestamp) {
		if (java.awt.Desktop.isDesktopSupported()) {
			try {
				String reportUriStr = Const.reportPath + timestamp;
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
