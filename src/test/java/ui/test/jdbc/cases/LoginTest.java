/**
 * 
 */
package ui.test.jdbc.cases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import ui.test.cases.Login;

/**
 * @author chenguangjian 2015年3月30日 下午5:29:39
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/spring/spring-qjd-uitest.xml" })
public class LoginTest {
	@Autowired
	private Login login;

	@Test
	public void testLoginUserNameIsEmpty() {
		login.init();

		// 1. userName is empty test
		String tcKey = "LoginTest.jslogin_UserNameIsEmptyTest";
		login.doLogin(tcKey);

	}

	@Test
	public void testLoginPasswordIsEmpty() {
		login.init();

		String tcKey = "LoginTest.jslogin_PasswordIsEmptyTest";
		login.doLogin(tcKey);

	}

	@Test
	public void testLoginPasswordIsWrong() {
		login.init();
		String tcKey = "LoginTest.jslogin_PasswordIsWrongTest";
		login.doLogin(tcKey);

	}

	@Test
	public void testLoginUserNameNotExist() {
		login.init();
		// 4. UserNameNotExistTest
		String tcKey = "LoginTest.jslogin_UserNameNotExistTest";
		login.doLogin(tcKey);

	}

	@Test
	public void testLoginSolutionTest() {
		login.init();

		// 5. solution test
		String tcKey = "LoginTest.jslogin_SolutionTest";
		login.doLogin(tcKey);

	}
}
