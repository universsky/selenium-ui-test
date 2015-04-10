/**
 * 
 */
package ui.test.jdbc.data;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import ui.test.tools.SpringUtil;

/**
 * @author chenguangjian
 *
 */
public class PartnerData {
	private JdbcTemplate jdbcTemplateCifFntDev = (JdbcTemplate) SpringUtil
			.getBean("jdbcTemplateCifFntDev");

	private JdbcTemplate jdbcTemplateCifDev = (JdbcTemplate) SpringUtil
			.getBean("jdbcTemplateCifDev");

	static PartnerData PartnerData = new PartnerData();

	public static void main(String[] args) {

		String loginName = "13291801308";

		String[] partnerNames = PartnerData
				.getPartnerNamesByLoginName(loginName);
		for (String name : partnerNames) {
			System.out.println(name);
		}

		String partnerName = "光剑电梯系统供应商";
		System.out.println(PartnerData
				.deletePartnerName(loginName, partnerName));
	}

	/**
	 * 
	 * @param loginName
	 * @return
	 */
	public String[] getPartnerNamesByLoginName(String loginName) {

		// get memberId from cif_member : loginName ---> cif_member.ID (
		// memberId )

		final String[] memberId = new String[] { "" };

		jdbcTemplateCifDev.query(
				" select ID from cif_member where login_name=? ",
				new Object[] { loginName }, new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						memberId[0] = rs.getString("ID");
					}
				});

		// memberId ---> cif_fnt_mem_app.member_id ---> cif_fnt_mem_app.ID (
		// cif_fnt_paterners.app_id )
		final String[] appId = new String[] { "" };
		jdbcTemplateCifFntDev.query(
				" select ID from cif_fnt_mem_app where member_id=? ",
				new Object[] { memberId[0] }, new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						String name = rs.getString("ID");
						appId[0] = name;
					}
				});

		// select the partner name

		// final String result = null;
		List rows = jdbcTemplateCifFntDev.queryForList(
				" select name from cif_fnt_paterners where app_id=? ",
				new Object[] { appId[0] });
		final String[] result = new String[rows.size()];
		for (int i = 0; i < rows.size(); i++) {

			Map resultMap = (Map) rows.get(i);
			result[i] = resultMap.get("name") + "";

		}

		return result;
	}

	/**
	 * 
	 * @param loginName
	 * @return
	 */
	public int deletePartnerName(String loginName, String partnerName) {

		// get memberId from cif_member : loginName ---> cif_member.ID (
		// memberId )

		final String[] memberId = new String[] { "" };

		jdbcTemplateCifDev.query(
				" select ID from cif_member where login_name=? ",
				new Object[] { loginName }, new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						memberId[0] = rs.getString("ID");
					}
				});

		// memberId ---> cif_fnt_mem_app.member_id ---> cif_fnt_mem_app.ID (
		// cif_fnt_paterners.app_id )
		final String[] appId = new String[] { "" };
		jdbcTemplateCifFntDev.query(
				" select ID from cif_fnt_mem_app where member_id=? ",
				new Object[] { memberId[0] }, new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						String name = rs.getString("ID");
						appId[0] = name;
					}
				});

		return jdbcTemplateCifFntDev.update(
				" delete from cif_fnt_paterners where app_id=? and name=? ",
				new Object[] { appId[0], partnerName });

	}
}
