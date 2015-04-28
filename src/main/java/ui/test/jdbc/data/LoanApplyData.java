/**
 * 
 */
package ui.test.jdbc.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import ui.test.tools.SpringUtil;

/**
 * @author chenguangjian
 *
 */
public class LoanApplyData {

	private JdbcTemplate jdbcTemplateClmsDev = (JdbcTemplate) SpringUtil
			.getBean("jdbcTemplateClmsDev");

	private JdbcTemplate jdbcTemplateCifDev = (JdbcTemplate) SpringUtil
			.getBean("jdbcTemplateCifDev");

	static LoanApplyData LoanApplyData = new LoanApplyData();

	public static void main(String[] args) {

		String loginName = "13291801306";

		String[] LoanApply = LoanApplyData.getLoanApplyByLoginName(loginName);
		for (String id : LoanApply) {
			System.out.println(id);
		}

		// String LoanApplyCode = "2015042815008";
		// System.out.println(LoanApplyData.deleteLoanApply(LoanApplyCode));
	}

	/**
	 * 
	 * @param loginName
	 * @return
	 */
	public String[] getLoanApplyByLoginName(String loginName) {

		// get memberId from cif_member : loginName ---> cif_member.ID (
		// memberId )

		final String[] memberId = new String[] { "" };

		// select the member_id
		jdbcTemplateCifDev.query(
				" select ID from cif_member where login_name=? ",
				new Object[] { loginName }, new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						memberId[0] = rs.getString("ID");
					}
				});

		// cif_member.id = memberId ---> clms_loan_apply.member_id
		// final String[] applyCode = new String[] { "" };
		// jdbcTemplateCifFntDev.query(
		// " select apply_code from clms_loan_apply where member_id=? ",
		// new Object[] { memberId[0] }, new RowCallbackHandler() {
		// @Override
		// public void processRow(ResultSet rs) throws SQLException {
		// String code = rs.getString("apply_code");
		// applyCode[0] = code;
		// }
		// });

		// select the loan apply list

		List rows = jdbcTemplateClmsDev.queryForList(
				" select apply_code from clms_loan_apply where member_id=? ",
				new Object[] { memberId[0] });

		final String[] result = new String[rows.size()];

		for (int i = 0; i < rows.size(); i++) {

			Map resultMap = (Map) rows.get(i);
			result[i] = resultMap.get("apply_code") + "";

		}

		return result;
	}

	/**
	 * 
	 * @param loginName
	 * @return
	 */
	public int deleteLoanApply(String LoanApplyCode) {

		return jdbcTemplateClmsDev.update(
				" delete from clms_loan_apply where apply_code=? ",
				new Object[] { LoanApplyCode });

	}

}
