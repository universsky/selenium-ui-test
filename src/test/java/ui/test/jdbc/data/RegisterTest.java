/**
 * 
 */
package ui.test.jdbc.data;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ui.test.cases.Register;

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
		register.doRegister();
		assertEquals(true, registerData.getLoginName("13291801306").size() > 0);
	}
}
