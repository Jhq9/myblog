package may.i.jhq.stateMachine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * Created by jinhuaquan on 2017/7/16.
 */
@Configuration
@EnableStateMachine
//@OnTransition
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<StateAndEvent.States,StateAndEvent.Events>{

    public static final Logger logger = LoggerFactory.getLogger(StateMachineConfig.class);

    @Override
    public void configure(StateMachineStateConfigurer<StateAndEvent.States,StateAndEvent.Events> states) throws Exception {
        // 定义状态机中的状态
        states
                .withStates()
                .initial(StateAndEvent.States.UNPAID) //初始状态
                .states(EnumSet.allOf(StateAndEvent.States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<StateAndEvent.States,StateAndEvent.Events> transtitions) throws Exception {

        transtitions
                .withExternal()
                .source(StateAndEvent.States.UNPAID)
                .target(StateAndEvent.States.WAITING_FOR_RECEIVE)
                .event(StateAndEvent.Events.PAY)
                .and()
                .withExternal()
                .source(StateAndEvent.States.WAITING_FOR_RECEIVE)
                .target(StateAndEvent.States.DONE)
                .event(StateAndEvent.Events.RECEIVE);

    }

//    @Override
//    public void configure(StateMachineConfigurationConfigurer<StateAndEvent.States,StateAndEvent.Events> config) throws Exception {
//
//        config
//                .withConfiguration()
//                .listener(listener());
//
//    }
//
//    @Bean
//    public StateMachineListener<StateAndEvent.States,StateAndEvent.Events> listener(){
//        return new StateMachineListenerAdapter<StateAndEvent.States,StateAndEvent.Events>(){
//            public void transition(Transition<StateAndEvent.States,StateAndEvent.Events> transition){
//                if (transition.getSource().getId() == StateAndEvent.States.UNPAID){
//                    logger.info("订单创建，待支付");
//                    return;
//                }
//
//                if (transition.getSource().getId() == StateAndEvent.States.WAITING_FOR_RECEIVE){
//                    logger.info("用户完成支付，待收货");
//                    return;
//                }
//
//                if (transition.getSource().getId() == StateAndEvent.States.DONE){
//                    logger.info("用户已收货,订单交易完成");
//                    return;
//                }
//            }
//
//
//
//        };
//    }


}
