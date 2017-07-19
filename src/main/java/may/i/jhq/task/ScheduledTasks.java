package may.i.jhq.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jinhuaquan on 2017/7/13.
 */
@Component
public class ScheduledTasks {

    public static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    /**
     * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     */
    @Scheduled(cron = "0 0/1 * * * ?") //每分钟执行一次
    public void reportCurrentTime(){
        logger.info("Current Time :"+new Date());
    }

}
