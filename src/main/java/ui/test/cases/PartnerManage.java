/**
 * 
 */
package ui.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.test.constant.Const;
import ui.test.jdbc.data.PartnerData;
import ui.test.tools.DBTool;
import ui.test.tools.TimeTool;
import ui.test.tools.WebTool;

/**
 * @author chenguangjian
 *
 */
public class PartnerManage {

	private static Logger logger = LoggerFactory.getLogger(PartnerManage.class);

	public synchronized WebDriver doAddPartner(String tcKey) {

		WebDriver driver = WebTool.initFirefoxDriver();

		String tcValue = new DBTool().getTcValueBytcKey(tcKey);

		try {

			driver.get(Const.homeUrl);
			TimeTool.delayMilliSeconds(1000L);
			logger.info(tcValue);

			// 已注册会员用户，登陆
			((JavascriptExecutor) driver)
					.executeScript(new DBTool()
							.getTcValueBytcKey("LoginTest.SolutionTestMemberRegistered"));

			TimeTool.delayMilliSeconds(1000L);

			driver.findElement(
					By.xpath(TCData.getString("PartnerManage.partner_tab")))
					.click();

			((JavascriptExecutor) driver).executeScript(tcValue);

			TimeTool.delayMilliSeconds(1000L);

			return driver;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
