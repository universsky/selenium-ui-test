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
	public final static String homeUrl = "http://qjdchina.com/";
	public final static String 会员注册Url = "http://qjdchina.com/front/member/apply.htm";
	public final static String 会员中心Url = "http://qjdchina.com/front/member/corpinfo.htm";
	public final static String 新增合作厂家Url = "http://qjdchina.com/front/member/partners.htm";

	public final static String uploadUrl = "http://localhost:8080/UploadFileToServer/upload/up";
	public final static String reportPath = "http://localhost:8080/UploadFileToServer/up/report.html?timestamp=";
}
