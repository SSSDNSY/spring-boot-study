package fun.pengzh.rabbitmq.rabbit.object;

import fun.pengzh.rabbitmq.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fun.pengzh
 * @class fun.pengzh.rabbitmq.rabbit.object.ObjectReceiver
 * @desc
 * @since 2021-04-25
 */
@Component
public class ObjectReceiver {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user) {
        System.out.println("Sender object: " + user.toString());
        this.rabbitTemplate.convertAndSend("object", user);
    }

}
