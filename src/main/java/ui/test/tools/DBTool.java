/**
 * 
 */
package ui.test.tools;

import java.sql.*;

/**
 * @author chenguangjian 2015年4月1日 下午9:02:34
 */
public class DBTool {

	public static void main(String[] args) {
		String timestamp = "20150401203951";
		String imgName = "20150401203951_LoginTest.jslogin_UserNameNotExistTest.jpeg";
		insertImgName(timestamp, imgName);
	}

	/**
	 * 
	 * @param timestamp
	 * @param imgName
	 * @return
	 */
	public static boolean insertImgName(String timestamp, String imgName) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/ui_test", "root", "root");
			// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

			System.out.println("Success connect Mysql server!");
			Statement stmt = connect.createStatement();

			String insertCmd = "INSERT INTO t_ui_test(timestamp,img_name) VALUES ('"
					+ timestamp + "','" + imgName + "')";
			System.out.println(insertCmd);
			boolean rs = stmt.execute(insertCmd);
			return rs;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
