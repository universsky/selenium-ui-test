/**
 * 
 */
package ui.test.jdbc.cases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.aspectj.lang.annotation.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import ui.test.cases.Login;
import ui.test.cases.TCData;
import ui.test.constant.TCResult;
import ui.test.tools.ReportTool;

/**
 * @author chenguangjian 2015年3月30日 下午5:29:39
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/spring/spring-qjd-uitest-bean.xml" })
public class LoginTest {
	private static final String url = TCData.getString("LoginTest.url");

	@Autowired
	private Login login;

	@Test
	public void testLoginUserNameIsEmpty() throws WebDriverException,
			IOException {
		login.init();

		// 1. userName is empty test
		String tcKey = "LoginTest.UserNameIsEmptyTest";

		WebDriver driver = login.doLogin(tcKey);
		String curUrl = driver.getCurrentUrl();

		String tcResult = url.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String expected = url;
		String actual = curUrl;
		ReportTool.record(tcKey, driver, tcResult, expected, actual);
		assertEquals(true, url.equals(curUrl));

	}

	@Test
	public void testLoginPasswordIsEmpty() throws WebDriverException,
			IOException {
		login.init();

		String tcKey = "LoginTest.PasswordIsEmptyTest";
		WebDriver driver = login.doLogin(tcKey);

		String curUrl = driver.getCurrentUrl();

		String tcResult = url.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String expected = url;
		String actual = curUrl;
		ReportTool.record(tcKey, driver, tcResult, expected, actual);
		assertEquals(true, url.equals(curUrl));

	}

	@Test
	public void testLoginPasswordIsWrong() throws WebDriverException,
			IOException {
		login.init();
		String tcKey = "LoginTest.PasswordIsWrongTest";
		WebDriver driver = login.doLogin(tcKey);

		String curUrl = driver.getCurrentUrl();

		String tcResult = url.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String expected = url;
		String actual = curUrl;
		ReportTool.record(tcKey, driver, tcResult, expected, actual);
		assertEquals(true, url.equals(curUrl));

	}

	@Test
	public void testLoginUserNameNotExist() throws WebDriverException,
			IOException {
		login.init();
		// 4. UserNameNotExistTest
		String tcKey = "LoginTest.UserNameNotExistTest";

		WebDriver driver = login.doLogin(tcKey);

		String curUrl = driver.getCurrentUrl();

		String tcResult = url.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String expected = url;
		String actual = curUrl;
		ReportTool.record(tcKey, driver, tcResult, expected, actual);
		assertEquals(true, url.equals(curUrl));

	}

	@Test
	public void testLoginSolutionTest() throws WebDriverException, IOException {
		login.init();

		// 5. solution test
		String tcKey = "LoginTest.SolutionTest";
		WebDriver driver = login.doLogin(tcKey);

		String curUrl = driver.getCurrentUrl();
		String afterLoginUrl = TCData.getString("LoginTest.afterLoginUrl");
		String tcResult = afterLoginUrl.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String expected = afterLoginUrl;
		String actual = curUrl;
		ReportTool.record(tcKey, driver, tcResult, expected, actual);

		assertEquals(true, afterLoginUrl.equals(curUrl));

	}

}
