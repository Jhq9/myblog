package may.i.jhq.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jinhuaquan on 2017/7/14.
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context="hello! I am RabbitMQ sender"+new Date();

        System.out.println("Sender sends context:"+context);

        this.amqpTemplate.convertAndSend("hello",context);
    }

}
