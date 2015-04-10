/**
 * 
 */
package ui.test.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.test.cases.PartnerManage;
import ui.test.cases.TCData;
import ui.test.constant.TCResult;
import ui.test.jdbc.data.PartnerData;
import ui.test.tools.ReportTool;

/**
 * @author chenguangjian
 *
 */
public class PartnerManageTest {
	private static Logger logger = LoggerFactory
			.getLogger(PartnerManageTest.class);

	PartnerManage PartnerManage = new PartnerManage();

	public void 新增合作厂家测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "PartnerManage.AddPartner";
		logger.info(tcKey);

		PartnerData partnerData = new PartnerData();

		String loginName = TCData.getString("PartnerManage.login_name");
		String partnerName = TCData.getString("PartnerManage.partner_name");

		// init db data
		partnerData.deletePartnerName(loginName, partnerName);

		// add partner
		driver = PartnerManage.doAddPartner(tcKey);

		// check db data
		String[] partners = partnerData.getPartnerNamesByLoginName(loginName);

		List partnerList = Arrays.asList(partners);

		String expected = partnerName;
		String actual = partnerList.contains(partnerName) == true ? partnerName
				: "NULL";

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = "";
		for (String p : partners) {
			log += p + "\n";
		}
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}
}
