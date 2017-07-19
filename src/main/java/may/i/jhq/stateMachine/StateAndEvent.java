package may.i.jhq.stateMachine;

/**
 * Created by jinhuaquan on 2017/7/16.
 */
public class StateAndEvent {

    public enum States {
        UNPAID,                 // 待支付
        WAITING_FOR_RECEIVE,    // 待收货
        DONE                    // 结束
    }
    public enum Events {
        PAY,        // 支付
        RECEIVE     // 收货
    }

}
