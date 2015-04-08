/**
 * 
 */
package ui.test.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.test.cases.Register;
import ui.test.constant.TCResult;
import ui.test.jdbc.data.RegisterData;
import ui.test.tools.ReportTool;

/**
 * @author chenguangjian 2015年3月30日 下午5:22:15
 */
public class RegisterTest {
	Logger logger = LoggerFactory.getLogger(RegisterTest.class);
	// private RegisterData registerData = (RegisterData) SpringUtil
	// .getBean("registerData");

	private RegisterData registerData = new RegisterData();

	private Register register = new Register();

	public void testRegister() throws WebDriverException, IOException {
		register.init();
		String tcKey = "RegisterTest.RegisterTest";
		logger.info(tcKey);
		WebDriver driver = register.doRegister(tcKey);

		String tcResult = registerData.getLoginName("13291801306").size() > 0 ? TCResult.PASS
				.getMsg() : TCResult.FAIL.getMsg();

		ReportTool.record(tcKey, driver, tcResult);

	}
}
