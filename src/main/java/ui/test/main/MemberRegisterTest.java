/**
 * 
 */
package ui.test.main;

import java.io.IOException;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.test.cases.Login;
import ui.test.cases.MemberRegister;
import ui.test.constant.Const;
import ui.test.constant.TCResult;
import ui.test.tools.ReportTool;

/**
 * @author chenguangjian
 *
 */
public class MemberRegisterTest {
	private static Logger logger = LoggerFactory
			.getLogger(MemberRegisterTest.class);

	MemberRegister memberRegister = new MemberRegister();

	public void 解决方案测试() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.解决方案测试";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 公司名称3位中文() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.公司名称3位中文";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 公司名称26位中文() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.公司名称26位中文";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 公司名称英文() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.公司名称英文";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 公司名称非法字符() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.公司名称非法字符";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 办公地址空校验() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.办公地址空校验";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 工商注册号空校验() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.工商注册号空校验";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 工商注册号1位数字() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.工商注册号1位数字";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 工商注册号14位数字() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.工商注册号14位数字";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 办公地址20个字() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.办公地址20个字";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 办公地址51个字() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.办公地址51个字";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 办公地址3个字() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.办公地址3个字";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 法定代表人6个字() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.法定代表人6个字";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 法定代表人5个字() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.法定代表人5个字";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 法定代表人1个字() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.法定代表人1个字";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 法定代表人空校验() throws WebDriverException, IOException {

		String tcKey = "MemberRegister.法定代表人空校验";
		logger.info(tcKey);

		WebDriver driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

}
