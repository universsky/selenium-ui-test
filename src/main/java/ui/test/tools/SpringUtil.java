/**
 * 
 */
package ui.test.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author chenguangjian
 *
 */
public final class SpringUtil {

	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"/spring/spring-qjd-uitest.xml");

	public static Object getBean(String beanName) {
		return ctx.getBean(beanName);
	}

	public static void main(String[] args) {
		System.out.println(getBean("jdbcTemplate"));
	}
}
