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

import ui.test.cases.TCData;
import ui.test.constant.TCResult;
import ui.test.jdbc.data.LoanApplyData;
import ui.test.tools.ReportTool;

/**
 * @author chenguangjian
 *
 */
public class LoanApplyTest {

	private static Logger logger = LoggerFactory.getLogger(LoanApplyTest.class);

	ui.test.cases.LoanApply LoanApply = new ui.test.cases.LoanApply();

	public void 我要贷款测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.SolutionTest";
		logger.info(tcKey);

		LoanApplyData LoanApplyData = new LoanApplyData();

		String loginName = TCData.getString("LoanApply.login_name");

		// init db data
		// LoanApplyData.deleteLoanApply(LoanApplyCode);

		// add partner
		driver = LoanApply.doLoan(tcKey, driver);

		// check db data
		String[] loanApplys = LoanApplyData.getLoanApplyByLoginName(loginName);

		List loanApplysList = Arrays.asList(loanApplys);

		String expected = "TRUE";
		String actual = loanApplysList.size() > 0 ? "TRUE" : "FALSE";

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = "";
		for (String p : loanApplys) {
			log += p + "\n";
		}
		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}
}
