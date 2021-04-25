package fun.pengzh.rabbitmq.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author fun.pengzh
 * @class fun.pengzh.rabbitmq.rabbit.fanout.FanoutRecieveC
 * @desc
 * @since 2021-04-25
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverC {

    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver C  : " + message);
    }

}
