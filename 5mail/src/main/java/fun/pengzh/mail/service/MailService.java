package fun.pengzh.mail.service;

/**
 * @author fun.pengzh
 * @class fun.pengzh.mail.service.MailService
 * @desc
 * @since 2021-04-25
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);

    void sendHtmlMail(String to, String subject, String content);

    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
