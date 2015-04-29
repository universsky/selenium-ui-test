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
	public final static String homeUrl = "https://qjdchina.com/";
	public final static String 会员注册Url = "https://qjdchina.com/front/member/apply.htm";
	public final static String 会员中心Url = "https://qjdchina.com/front/member/corpinfo.htm";
	public final static String 新增合作厂家Url = "https://qjdchina.com/front/member/partners.htm";

	public final static String 我要贷款Url = "https://qjdchina.com/loan/loanApply";

	public final static String uploadUrl = "http://test.qjdchina.com:8080/UploadFileToServer/upload/up";
	public final static String reportPath = "http://test.qjdchina.com:8080/UploadFileToServer/up/report.html?timestamp=";
}
