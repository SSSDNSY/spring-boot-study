package fun.pengzh.schedule.schedule.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author fun.pengzh
 * @class fun.pengzh.schedule.schedule.task.SchedularTask2
 * @desc
 * @since 2021-04-25
 */
@Component
public class SchedularTask2 {

    /**
     * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
     * @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按 fixedRate 的规则每6秒执行一次
     */
    @Scheduled(fixedRate = 6000)
    public void printNumber() {
        System.out.println("print 666");
    }
}
