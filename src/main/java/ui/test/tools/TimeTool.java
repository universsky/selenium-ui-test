/**
 * 
 */
package ui.test.tools;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author chenguangjian
 *
 */
public class TimeTool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long milliseconds = 3000L;
		delayMilliSeconds(milliseconds);

	}

	/**
	 * 
	 * @param milliseconds
	 */
	public static void delayMilliSeconds(long milliseconds) {
		Timer timer = new Timer();// 实例化Timer类
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("退出");
				this.cancel();
			}
		}, milliseconds);// 毫秒
	}

}
