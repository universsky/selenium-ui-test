/**
 * 
 */
package ui.test.constant;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenguangjian 2015年4月1日 下午4:47:17
 */
public class Const {
	public final static String timestamp = new SimpleDateFormat(
			"yyyyMMddHHmmss").format(new Date());
	public final static String uploadUrl = "http://localhost:8080/UploadFileToServer/upload/up";
}
