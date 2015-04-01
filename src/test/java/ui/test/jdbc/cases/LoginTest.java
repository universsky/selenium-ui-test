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
import ui.test.cases.Messages;

/**
 * @author chenguangjian 2015年3月30日 下午5:29:39
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/spring/spring-qjd-uitest.xml" })
public class LoginTest {
	@Autowired
	private Login login;

	@Test
	public void testLogin() {
		login.init();

		// 1. userName is empty test
		String tc = Messages.getString("LoginTest.jslogin_UserNameIsEmptyTest");
		login.doLogin(tc);

		// 2. password is empty test
		tc = Messages.getString("LoginTest.jslogin_PasswordIsEmptyTest");
		login.doLogin(tc);

		// 3. PasswordIsWrongTest
		tc = Messages.getString("LoginTest.jslogin_PasswordIsWrongTest");
		login.doLogin(tc);

		// 4. UserNameNotExistTest
		tc = Messages.getString("LoginTest.jslogin_UserNameNotExistTest");
		login.doLogin(tc);

		// 5. solution test
		tc = Messages.getString("LoginTest.jslogin_SolutionTest");
		login.doLogin(tc);

	}
}
