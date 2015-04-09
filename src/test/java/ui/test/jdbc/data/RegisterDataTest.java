package ui.test.jdbc.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/spring/spring-qjd-uitest.xml" })
public class RegisterDataTest {

	private RegisterData registerData = new RegisterData();

	@Test
	public void testGetLoginName() {
		String loginName = "13262505677";

		List<String> names = registerData.getLoginName(loginName);
		System.out.println(names);
		assertEquals(true, names.size() > 0);
	}

}
