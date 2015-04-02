/**
 * 
 */
package ui.test.constant;

/**
 * @author chenguangjian
 *
 */
public enum TCResult {

	PASS("0", "PASS"), FAIL("1", "FAIL");

	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private TCResult(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

}
