package may.i.jhq;

import may.i.jhq.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DataSourceAutoConfiguration.class,MyblogApplication.class})
public class MyblogApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {

		userService.findUserByEmail("1044038055@qq.com");

	}

}
