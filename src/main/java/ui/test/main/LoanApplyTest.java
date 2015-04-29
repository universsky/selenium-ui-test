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
import ui.test.constant.Const;
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

	public void 我要贷款解决方案测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.SolutionTest";
		logger.info(tcKey);

		LoanApplyData LoanApplyData = new LoanApplyData();

		String loginName = TCData.getString("LoanApply.login_name");

		// init db data
		// LoanApplyData.deleteLoanApply(LoanApplyCode);

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

	public void 我要贷款项目名称空校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.ProjectNameIsEmptyTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.我要贷款Url;
		String actual = driver.getCurrentUrl();

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void 我要贷款项目名称3位校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.ProjectName3WordsTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.我要贷款Url;
		String actual = driver.getCurrentUrl();

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void 我要贷款项目名称16位校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.ProjectName16WordsTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.我要贷款Url;
		String actual = driver.getCurrentUrl();

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void 我要贷款开发商空校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.propertyDeveloperNameIsEmptyTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.我要贷款Url;
		String actual = driver.getCurrentUrl();

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void 我要贷款开发商3位校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.propertyDeveloperName3WordsTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.我要贷款Url;
		String actual = driver.getCurrentUrl();

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void 我要贷款开发商16位校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.propertyDeveloperName16WordsTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.我要贷款Url;
		String actual = driver.getCurrentUrl();

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void 我要贷款合同金额空校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.contractAmountIsEmptyTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.我要贷款Url;
		String actual = driver.getCurrentUrl();

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void 我要贷款合同金额0校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.contractAmountIsZeroTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.我要贷款Url;
		String actual = driver.getCurrentUrl();

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void 我要贷款合同金额5位校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.contractAmount5WordsTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.我要贷款Url;
		String actual = driver.getCurrentUrl();

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void 我要贷款贷款金额空校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.loanAmountIsEmptyTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.我要贷款Url;
		String actual = driver.getCurrentUrl();

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void 我要贷款贷款金额0校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.loanAmountIsZeroTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.贷款成功前缀Url;
		String actual = driver.getCurrentUrl();

		String tcResult = actual.contains(expected) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void 我要贷款贷款金额5位校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.loanAmount5WordsTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.我要贷款Url;
		String actual = driver.getCurrentUrl();

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void 我要贷款贷款金额大于合同金额校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.loanAmountGreaterThanContractAmountTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.我要贷款Url;
		String actual = driver.getCurrentUrl();

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

	public void 我要贷款贷款期限12个月校验测试(WebDriver driver, String timestamp)
			throws WebDriverException, IOException {

		String tcKey = "LoanApply.doLoanApply.loanLimit12MonthsTest";
		logger.info(tcKey);

		driver = LoanApply.doLoan(tcKey, driver);

		String expected = Const.我要贷款Url;
		String actual = driver.getCurrentUrl();

		String tcResult = expected.equals(actual) ? TCResult.PASS.getMsg()
				: TCResult.FAIL.getMsg();

		String log = actual;

		ReportTool.record(tcKey, driver, tcResult, expected, actual, log,
				timestamp);

	}

}
