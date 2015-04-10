/**
 * 
 */
package ui.test.jdbc.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import ui.test.tools.SpringUtil;

/**
 * @author chenguangjian 2015年3月30日 下午4:34:14
 */

public class RegisterData {

	private JdbcTemplate jdbcTemplateCifDev = (JdbcTemplate) SpringUtil
			.getBean("jdbcTemplateCifDev");

	public static void main(String[] args) {
		RegisterData RegisterData = new RegisterData();
		String loginName = "13262505677";

		System.out.println(RegisterData.getLoginName(loginName));
	}

	/**
	 * 
	 * @param loginName
	 * @return
	 */
	public List<String> getLoginName(String loginName) {
		// public String getLoginName(String loginName) {
		String sql = " select login_name from cif_member where login_name=? ";
		Object[] params = new Object[] { loginName };
		final List<String> result = new ArrayList<String>();
		// final String result = null;
		jdbcTemplateCifDev.query(sql, params, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				String name = rs.getString("login_name");
				result.add(name);
				// result = name;
			}

		});
		return result;
	}

}
