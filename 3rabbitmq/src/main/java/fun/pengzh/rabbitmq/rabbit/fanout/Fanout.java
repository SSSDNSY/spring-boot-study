package fun.pengzh.rabbitmq.rabbit.fanout;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author fun.pengzh
 * @class fun.pengzh.rabbitmq.rabbit.fanout.Fanout
 * @desc
 * @since 2021-04-25
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class Fanout {

    @Autowired
    private FanoutSender sender;

    @Test
    public void fanoutSender() throws Exception {
        sender.send();
    }


}
