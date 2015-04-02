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
		String tcKey = "LoginTest.jslogin_UserNameIsEmptyTest";

		WebDriver driver = login.doLogin(tcKey);
		String curUrl = driver.getCurrentUrl();

		String tcResult = url.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		assertEquals(true, url.equals(curUrl));

		ReportTool.record(tcKey, driver, tcResult);

	}

	@Test
	public void testLoginPasswordIsEmpty() throws WebDriverException,
			IOException {
		login.init();

		String tcKey = "LoginTest.jslogin_PasswordIsEmptyTest";
		WebDriver driver = login.doLogin(tcKey);

		String curUrl = driver.getCurrentUrl();

		String tcResult = url.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		assertEquals(true, url.equals(curUrl));

		ReportTool.record(tcKey, driver, tcResult);

	}

	@Test
	public void testLoginPasswordIsWrong() throws WebDriverException,
			IOException {
		login.init();
		String tcKey = "LoginTest.jslogin_PasswordIsWrongTest";
		WebDriver driver = login.doLogin(tcKey);

		String curUrl = driver.getCurrentUrl();

		String tcResult = url.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		assertEquals(true, url.equals(curUrl));

		ReportTool.record(tcKey, driver, tcResult);

	}

	@Test
	public void testLoginUserNameNotExist() throws WebDriverException,
			IOException {
		login.init();
		// 4. UserNameNotExistTest
		String tcKey = "LoginTest.jslogin_UserNameNotExistTest";

		WebDriver driver = login.doLogin(tcKey);

		String curUrl = driver.getCurrentUrl();

		String tcResult = url.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		assertEquals(true, url.equals(curUrl));

		ReportTool.record(tcKey, driver, tcResult);

	}

	@Test
	public void testLoginSolutionTest() throws WebDriverException, IOException {
		login.init();

		// 5. solution test
		String tcKey = "LoginTest.jslogin_SolutionTest";
		WebDriver driver = login.doLogin(tcKey);

		String curUrl = driver.getCurrentUrl();
		String afterLoginUrl = "http://dev.qjdchina.com/front/member/apply.htm";
		String tcResult = afterLoginUrl.equals(curUrl) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		assertEquals(true, afterLoginUrl.equals(curUrl));

		ReportTool.record(tcKey, driver, tcResult);

	}

}
