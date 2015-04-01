/**
 * 
 */
package ui.test.jdbc.cases;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ui.test.cases.TCData;
import ui.test.cases.Register;
import ui.test.jdbc.data.RegisterData;

/**
 * @author chenguangjian 2015年3月30日 下午5:22:15
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/spring/spring-qjd-uitest.xml" })
public class RegisterTest {

	@Autowired
	private RegisterData registerData;
	@Autowired
	private Register register;

	@Test
	@Transactional
	public void testRegister() {
		register.init();
		String tc = TCData.getString("LoginTest.jsregister");
		register.doRegister(tc);
		assertEquals(true, registerData.getLoginName("13291801306").size() > 0);

	}
}
