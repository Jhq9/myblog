package may.i.jhq;

import may.i.jhq.rabbitMQ.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jinhuaquan on 2017/7/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DataSourceAutoConfiguration.class,MyblogApplication.class})
public class RabbitmqTest {

    @Autowired
    private Sender sender;

    @Test
    public void rabbitTest(){
        sender.send();
    }

}
