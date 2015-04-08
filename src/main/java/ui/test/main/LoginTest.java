/**
 * 
 */
package ui.test.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.test.cases.Login;
import ui.test.cases.TCData;
import ui.test.constant.TCResult;
import ui.test.tools.ReportTool;
import ui.test.tools.TimeTool;

/**
 * @author chenguangjian 2015年3月30日 下午5:29:39
 */
public class LoginTest {
	private static Logger logger = LoggerFactory.getLogger(LoginTest.class);

	private static final String url = TCData.getString("LoginTest.url");

	private Login login = new Login();

	public void testLoginUserNameIsEmpty() throws WebDriverException,
			IOException {

		login.init();

		// 1. userName is empty test
		String tcKey = "LoginTest.UserNameIsEmptyTest";
		logger.info(tcKey);

		WebDriver driver = login.doLogin(tcKey);
		String curUrl = driver.getCurrentUrl();

		String tcResult = url.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		ReportTool.record(tcKey, driver, tcResult);

	}

	public void testLoginPasswordIsEmpty() throws WebDriverException,
			IOException {
		login.init();

		String tcKey = "LoginTest.PasswordIsEmptyTest";
		logger.info(tcKey);
		WebDriver driver = login.doLogin(tcKey);

		String curUrl = driver.getCurrentUrl();

		String tcResult = url.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		ReportTool.record(tcKey, driver, tcResult);

	}

	public void testLoginPasswordIsWrong() throws WebDriverException,
			IOException {
		login.init();
		String tcKey = "LoginTest.PasswordIsWrongTest";
		logger.info(tcKey);
		WebDriver driver = login.doLogin(tcKey);

		String curUrl = driver.getCurrentUrl();

		String tcResult = url.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		ReportTool.record(tcKey, driver, tcResult);

	}

	public void testLoginUserNameNotExist() throws WebDriverException,
			IOException {
		login.init();
		// 4. UserNameNotExistTest
		String tcKey = "LoginTest.UserNameNotExistTest";
		logger.info(tcKey);

		WebDriver driver = login.doLogin(tcKey);

		String curUrl = driver.getCurrentUrl();

		String tcResult = url.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		ReportTool.record(tcKey, driver, tcResult);

	}

	public void testLoginSolutionTest() throws WebDriverException, IOException {
		login.init();

		// 5. solution test
		String tcKey = "LoginTest.SolutionTest";
		logger.info(tcKey);
		WebDriver driver = login.doLogin(tcKey);

		TimeTool.delayMilliSeconds(5000);
		String curUrl = driver.getCurrentUrl();
		String afterLoginUrl = "http://dev.qjdchina.com/front/member/apply.htm";

		String tcResult = afterLoginUrl.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		ReportTool.record(tcKey, driver, tcResult);

	}

}
