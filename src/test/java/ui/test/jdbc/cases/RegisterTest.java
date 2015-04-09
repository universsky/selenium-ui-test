/**
 * 
 */
package ui.test.jdbc.cases;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ui.test.cases.TCData;
import ui.test.cases.Register;
import ui.test.constant.TCResult;
import ui.test.jdbc.data.RegisterData;
import ui.test.tools.ReportTool;
import ui.test.tools.SpringUtil;

/**
 * @author chenguangjian 2015年3月30日 下午5:22:15
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/resources/spring/spring-qjd-uitest.xml",
		"file:src/main/resources/spring/spring-qjd-uitest-bean.xml" })
public class RegisterTest {

	// private RegisterData registerData = (RegisterData) SpringUtil
	// .getBean("registerData");

	@Autowired
	private RegisterData registerData;

	@Autowired
	private Register register;

	@Test
	@Transactional
	public void testRegister() throws WebDriverException, IOException {
		String tcKey = "RegisterTest.RegisterTest";
		WebDriver driver = register.doRegister(tcKey);
		assertEquals(true, registerData.getLoginName("13291801306").size() > 0);

		String tcResult = registerData.getLoginName("13291801306").size() > 0 ? TCResult.PASS
				.getMsg() : TCResult.FAIL.getMsg();

		String expected = String.valueOf(registerData.getLoginName(
				"13291801306").size() > 0);
		String actual = String.valueOf(true);
		ReportTool.record(tcKey, driver, tcResult, expected, actual);
		assertEquals(true, registerData.getLoginName("13291801306").size() > 0);

	}
}
