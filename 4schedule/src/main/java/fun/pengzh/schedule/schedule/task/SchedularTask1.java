package fun.pengzh.schedule.schedule.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author fun.pengzh
 * @class fun.pengzh.schedule.schedule.task.SchedularTask1
 * @desc 定时任务
 * @since 2021-04-25
 */

@Component
public class SchedularTask1 {
    private int count=0;

    /**
     * cron 表达式  秒 分 时 日月 周 年
     * ?不指定 日和周
     * ,-/* 通配符
     *
     */
    @Scheduled(cron = "0/1 * * * * ? ")
    public void printNumber(){
        System.out.println("number printer task print count= "+ ++count);
    }
}
