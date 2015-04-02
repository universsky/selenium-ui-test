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

	public RegisterData() {
		super();
	}

	private JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil
			.getBeanDev("jdbcTemplate");

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
		jdbcTemplate.query(sql, params, new RowCallbackHandler() {

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
