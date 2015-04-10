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

import ui.test.constant.Const;
import ui.test.constant.TCResult;
import ui.test.tools.ReportTool;
import ui.test.cases.*;

/**
 * @author chenguangjian
 *
 */
public class MemberRegisterTest {
	private static Logger logger = LoggerFactory
			.getLogger(MemberRegisterTest.class);

	MemberRegister memberRegister = new MemberRegister();

	public void 解决方案测试(WebDriver driver) throws WebDriverException, IOException {

		String tcKey = "MemberRegister.SolutionTest";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 公司名称3位中文(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.Company3Words";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 公司名称26位中文(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.Company26Words";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 公司名称英文(WebDriver driver) throws WebDriverException, IOException {

		String tcKey = "MemberRegister.CompanyEnglishName";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 公司名称非法字符(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.CompanyIllegalChars";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 办公地址空校验(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.AddressNull";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 工商注册号空校验(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.RegCodeNull";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 工商注册号1位数字(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.RegCode1Digits";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 工商注册号14位数字(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.RegCode14Digits";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 办公地址20个字(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.Address20Words";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 办公地址51个字(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.Address51Words";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 办公地址3个字(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.Address3Words";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 法定代表人6个字(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.Legal6Words";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 法定代表人5个字(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.Legal5Words";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 法定代表人1个字(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.Legal1Words";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

	public void 法定代表人空校验(WebDriver driver) throws WebDriverException,
			IOException {

		String tcKey = "MemberRegister.LegalNull";
		logger.info(tcKey);

		driver = memberRegister.doMemberRegister(tcKey);

		String log = "Current url===============" + driver.getCurrentUrl();

		String expected = Const.会员注册Url;
		String actual = driver.getCurrentUrl();
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log);

	}

}
