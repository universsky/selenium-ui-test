/**
 * 
 */
package ui.test.tools;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

/**
 * @author chenguangjian 2015年4月1日 下午9:02:34
 */

public class DBTool {

	private JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil
			.getBean("jdbcTemplate");

	public static void main(String[] args) {

		String tcKey = "LoginTest.jslogin_UserNameIsEmptyTest";
		String timestamp = "20150401203951";
		String imgName = "20150401203951_LoginTest.jslogin_UserNameNotExistTest.jpeg";
		String tcResult = "PASS";

		DBTool DBTool = new DBTool();
		DBTool.insertImgName(tcKey, timestamp, imgName, tcResult);

		String v = DBTool.getTcValueBytcKey(tcKey);
		System.out.println(v);
	}

	public String getTcValueBytcKey(String tcKey) {
		String sql = " select tc_value from t_uitest_cases where tc_key=? ";
		Object params[] = new Object[] { tcKey };
		String[] tcValue = { "" };
		// System.out.println(jdbcTemplate);
		jdbcTemplate.query(sql, params, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {

				tcValue[0] = rs.getString("tc_value");
			}
		});

		return tcValue[0];

	}

	/**
	 * 
	 * @param timestamp
	 * @param imgName
	 * @return
	 */
	public int insertImgName(String tcKey, String timestamp, String imgName,
			String tcResult) {

		String sql = " INSERT INTO t_uitest_result(tc_key,timestamp,img_name,tc_result) VALUES (?,?,?,?) ";
		Object params[] = new Object[] { tcKey, timestamp, imgName, tcResult };

		// System.out.println(jdbcTemplate);

		return jdbcTemplate.update(sql, params);

	}

}
