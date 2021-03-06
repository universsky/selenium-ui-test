/**
 * 
 */
package ui.test.main;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.test.cases.Login;
import ui.test.constant.TCResult;
import ui.test.tools.ReportTool;

/**
 * @author chenguangjian 2015年3月30日 下午5:29:39
 */
public class LoginTest {
	private static Logger logger = LoggerFactory.getLogger(LoginTest.class);

	public void testLoginUserNameIsEmpty(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		// 1. userName is empty test
		String tcKey = "LoginTest.UserNameIsEmptyTest";
		logger.info(tcKey);
		Login login = new Login();
		driver = login.doLogin(tcKey, driver);

		Set<Cookie> cookies = driver.manage().getCookies();
		logger.info("Cookies===============" + cookies);
		String log = "Cookies===============" + cookies;
		Cookie c = driver.manage().getCookieNamed("login_corpname");

		String expected = "Null";
		String actual = c == null ? "Null" : "NotNull";
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void testLoginPasswordIsEmpty(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoginTest.PasswordIsEmptyTest";
		logger.info(tcKey);
		Login login = new Login();
		driver = login.doLogin(tcKey, driver);

		Set<Cookie> cookies = null;
		try {
			cookies = driver.manage().getCookies();
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Cookies===============" + cookies);
		String log = "Cookies===============" + cookies;
		Cookie c = driver.manage().getCookieNamed("login_corpname");

		String expected = "Null";
		String actual = c == null ? "Null" : "NotNull";
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void testLoginPasswordIsWrong(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoginTest.PasswordIsWrongTest";
		logger.info(tcKey);
		Login login = new Login();
		driver = login.doLogin(tcKey, driver);

		// Set<Cookie> cookies = driver.manage().getCookies();
		Set<Cookie> cookies = null;
		try {
			cookies = driver.manage().getCookies();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Cookies===============" + cookies);
		String log = "Cookies===============" + cookies;
		Cookie c = driver.manage().getCookieNamed("login_corpname");

		String expected = "Null";
		String actual = c == null ? "Null" : "NotNull";
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void testLoginUserNameNotExist(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		// 4. UserNameNotExistTest
		String tcKey = "LoginTest.UserNameNotExistTest";
		logger.info(tcKey);
		Login login = new Login();
		driver = login.doLogin(tcKey, driver);

		// Set<Cookie> cookies = driver.manage().getCookies();
		Set<Cookie> cookies = null;
		try {
			cookies = driver.manage().getCookies();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Cookies===============" + cookies);
		String log = "Cookies===============" + cookies;
		Cookie c = driver.manage().getCookieNamed("login_corpname");

		String expected = "Null";
		String actual = c == null ? "Null" : "NotNull";
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void testLoginSolutionTest(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		// 5. solution test
		String tcKey = "LoginTest.SolutionTest";
		logger.info(tcKey);
		Login login = new Login();
		driver = login.doLogin(tcKey, driver);

		logger.info("Cookies===============" + driver.manage().getCookies());
		String log = "Cookies===============" + driver.manage().getCookies();
		Cookie c = driver.manage().getCookieNamed("login_corpname");

		String expected = "NOT_EMPTY";
		String actual = c.getValue().isEmpty() ? "EMPTY" : "NOT_EMPTY";
		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

		// String curUrl = driver.getCurrentUrl();
		// String afterLoginUrl = TCData.getString("LoginTest.afterLoginUrl");
		//
		// String tcResult = afterLoginUrl.equals(curUrl) ?
		// TCResult.PASS.getMsg()
		// : TCResult.FAIL.getMsg();

	}
}
