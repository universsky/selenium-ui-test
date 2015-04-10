/**
 * 
 */
package ui.test.tools;

import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.google.common.io.Files;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import ui.test.cases.TCData;
import ui.test.constant.Const;

/**
 * @author chenguangjian 2015年3月30日 下午3:21:16
 */
public class WebTool {

	public static void main(String[] args) {
		WebDriver driver = null;

		driver = WebTool.initInternetExplorerDriver();
		driver.get("http://www.baidu.com");

		driver = WebTool.initFirefoxDriver();
		driver.get("http://www.baidu.com");

		driver = WebTool.initChromeDriver();
		driver.get("http://www.baidu.com");

	}

	public static WebDriver initFirefoxDriver() {

		System.setProperty(TCData.getString("LoginTest.firefox_bin"), //$NON-NLS-1$
				TCData.getString("LoginTest.firefox_bin_path")); //$NON-NLS-1$
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxProfile firefoxprofile = new FirefoxProfile(new File(
				TCData.getString("LoginTest.firefox_profile_path"))); //$NON-NLS-1$
		capabilities.setCapability(FirefoxDriver.PROFILE, firefoxprofile);

		WebDriver driver = new FirefoxDriver(capabilities);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit()
				.getScreenSize();
		// set browser window size
		Dimension targetSize = new Dimension(screenSize.width,
				screenSize.height);
		driver.manage().window().setSize(targetSize);
		// set browser position

		// Point targetPosition = new Point(screenSize.width,
		// screenSize.height);
		Point targetPosition = new Point(0, 0);
		driver.manage().window().setPosition(targetPosition);
		// // WebDriver driver = new InternetExplorerDriver();
		return driver;

	}

	public static WebDriver initChromeDriver() {

		System.setProperty("webdriver.chrome.driver",
				TCData.getString("chrome_bin_path"));

		WebDriver driver = new ChromeDriver();
		ChromeOptions ChromeOptions = new ChromeOptions();

		return driver;

	}

	public static WebDriver initInternetExplorerDriver() {

		System.setProperty("webdriver.ie.driver",
				TCData.getString("ie_bin_path"));

		WebDriver driver = new InternetExplorerDriver();

		return driver;

	}

	/**
	 * 
	 * @param url
	 * @param file
	 * @return
	 * @throws IOException
	 */

	public static boolean upload(String url, File file) throws IOException {

		/**
		 * 第一部分
		 */
		URL urlObj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

		/**
		 * 设置关键值
		 */
		con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false); // post方式不能使用缓存

		// 设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");

		// 设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary="
				+ BOUNDARY);

		// 请求正文信息

		// 第一部分：
		StringBuilder sb = new StringBuilder();
		sb.append("--"); // ////////必须多两道线
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
				+ file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");

		byte[] head = sb.toString().getBytes("utf-8");

		// 获得输出流

		OutputStream out = new DataOutputStream(con.getOutputStream());
		out.write(head);

		// 文件正文部分
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();
		// 结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
		out.write(foot);
		out.flush();
		out.close();

		boolean isUploadSuccessfully = false;
		isUploadSuccessfully = (con.getResponseCode() == 200);
		/**
		 * 读取服务器响应，必须读取,否则提交不成功
		 */

		return isUploadSuccessfully;
	}

	/**
	 * 
	 * @param url
	 * @param filePath
	 * @return
	 * @throws IOException
	 */

	public static boolean upload(String url, String filePath)
			throws IOException {
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			return false;
		}

		/**
		 * 第一部分
		 */
		URL urlObj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

		/**
		 * 设置关键值
		 */
		con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false); // post方式不能使用缓存

		// 设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");

		// 设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary="
				+ BOUNDARY);

		// 请求正文信息

		// 第一部分：
		StringBuilder sb = new StringBuilder();
		sb.append("--"); // ////////必须多两道线
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
				+ file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");

		byte[] head = sb.toString().getBytes("utf-8");

		// 获得输出流

		OutputStream out = new DataOutputStream(con.getOutputStream());
		out.write(head);

		// 文件正文部分
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();
		// 结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
		out.write(foot);
		out.flush();
		out.close();

		boolean isUploadSuccessfully = false;
		isUploadSuccessfully = (con.getResponseCode() == 200);
		/**
		 * 读取服务器响应，必须读取,否则提交不成功
		 */

		return isUploadSuccessfully;
	}

	/**
	 * 
	 * @param driver
	 * @param tcKey
	 */
	public static File takeScreenShot(WebDriver driver, String tcKey) {
		File srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		try {
			File toPath = new File(Messages.getString("WebTool.img_save_pth")); //$NON-NLS-1$
			if (!toPath.exists()) {
				toPath.mkdirs();
			}

			File toFile = new File(Messages.getString("WebTool.img_save_pth") //$NON-NLS-1$
					+ Const.timestamp
					+ "_" + tcKey + Messages.getString("WebTool.img_suffix")); //$NON-NLS-1$ //$NON-NLS-2$
			Files.copy(srcFile, toFile); //$NON-NLS-1$ //$NON-NLS-2$
			return toFile;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}
