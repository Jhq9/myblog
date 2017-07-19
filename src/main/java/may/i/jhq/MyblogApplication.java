package may.i.jhq;

import may.i.jhq.stateMachine.StateAndEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
//@EnableCaching
@EnableScheduling //开启定时任务
@EnableStateMachine
public class MyblogApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}

	@Autowired
	private StateMachine<StateAndEvent.States,StateAndEvent.Events> stateMachine;

	@Override
	public void run(String... strings) throws Exception {

		stateMachine.start();
		stateMachine.sendEvent(StateAndEvent.Events.PAY);
		stateMachine.sendEvent(StateAndEvent.Events.RECEIVE);

	}
}
