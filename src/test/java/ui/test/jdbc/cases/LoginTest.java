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
	public void testLogin() {
		login.init();
		login.doLogin();
	}
}
