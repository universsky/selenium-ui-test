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

		String tcKey = "MemberRegister.解决方案测试";
		// tcKey = "LoginTest.PasswordIsEmptyTest";
		// String timestamp = "20150401203951";
		// String imgName =
		// "20150401203951_LoginTest.jslogin_UserNameNotExistTest.jpeg";
		// String tcResult = "PASS";
		// String expected = "TRUE";
		// String actual = "TRUE";
		// String log =
		// "Cookies===============[login_corpname=default; path=/; domain=dev.qjdchina.com, login_username=13291801308; path=/; domain=dev.qjdchina.com, JSESSIONID=BEDCF845F28ED0093B72347F3C0D2C08; path=/front/; domain=dev.qjdchina.com]";
		DBTool DBTool = new DBTool();
		// DBTool.insertTcResult(tcKey, timestamp, imgName, tcResult, expected,
		// actual, log);
		System.out.println(tcKey);
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
				// System.out.println(rs);
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
	public int insertTcResult(String tcKey, String timestamp, String imgName,
			String tcResult, String expected, String actual, String log) {

		String sql = " INSERT INTO t_uitest_result(tc_key,timestamp,img_name,tc_result,expected,actual,log) VALUES (?,?,?,?,?,?,?) ";
		Object params[] = new Object[] { tcKey, timestamp, imgName, tcResult,
				expected, actual, log };

		// System.out.println(jdbcTemplate);

		return jdbcTemplate.update(sql, params);

	}

}
