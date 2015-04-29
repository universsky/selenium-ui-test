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
import ui.test.tools.DBTool;
import ui.test.tools.TimeTool;
import ui.test.tools.WebTool;

/**
 * @author chenguangjian
 *
 */
public class LoanApply {

	private static Logger logger = LoggerFactory.getLogger(LoanApply.class);

	public synchronized WebDriver doLoan(String tcKey, WebDriver driver) {

		// WebDriver driver = WebTool.initFirefoxDriver();

		String tcValue = new DBTool().getTcValueBytcKey(tcKey);

		try {

			// 打开首页
			driver.get(Const.homeUrl);
			TimeTool.delayMilliSeconds(1000L);
			logger.info(tcValue);

			// 已注册会员用户，登陆
			((JavascriptExecutor) driver)
					.executeScript(new DBTool()
							.getTcValueBytcKey("LoginTest.SolutionTestMemberRegistered"));

			TimeTool.delayMilliSeconds(1000L);

			// click the add partner tab

			// driver.findElement(
			// By.xpath(TCData.getString("PartnerManage.partner_tab")))
			// .click();

			// 点击 tab：我的贷款
			// String className =
			// TCData.getString("LoanApply.myloan_tab_class");
			// driver.findElement(By.className(className));

			// (1) click the loan tab , (2) toloanApply

			((JavascriptExecutor) driver)
					.executeScript("$('.toLoanApply')[0].click();");
			((JavascriptExecutor) driver)
					.executeScript("$('.toLoanApply')[1].click();");

			TimeTool.delayMilliSeconds(1000L);

			((JavascriptExecutor) driver).executeScript(tcValue);

			TimeTool.delayMilliSeconds(1000L);

			// return driver;

		} catch (Exception e) {
			e.printStackTrace();
			// return null;
		}

		return driver;

	}

}
