package fun.pengzh.mail;

import fun.pengzh.mail.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private MailService mailService;


    @Test
    void contextLoads() {
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        context.setVariable("name", "SSSDNSY");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("ityouknow@126.com", "主题：这是模板邮件", emailContent);
    }
}
