package may.i.jhq;

/**
 * Created by jinhuaquan on 2017/7/13.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DataSourceAutoConfiguration.class,MyblogApplication.class})
public class MailSendTest {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 最简单的文本邮件发送
     */
    @Test
    public void mailSendTest(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("1044038055@qq.com");
        simpleMailMessage.setTo("1044038055@qq.com");
        simpleMailMessage.setSubject("Mail Send Test");
        simpleMailMessage.setText("Hello World!");

        javaMailSender.send(simpleMailMessage);

    }

    /**
     * 带附件的邮件发送
     * @throws MessagingException
     */
    @Test
    public void sendAttachmentMail() throws MessagingException {

        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage,true);
        mimeMessageHelper.setFrom("1044038055@qq.com");
        mimeMessageHelper.setTo("1044038055@qq.com");
        mimeMessageHelper.setSubject("SB");

        mimeMessageHelper.setText("<html><body><h1>jjjjjjjjjjjjj</h1><img src=\"cid:weixin\" ></body></html>",true);

        FileSystemResource fileSystemResource = new FileSystemResource(new File("/Users/jinhuaquan/Pictures/夏目.jpg"));

        mimeMessageHelper.addAttachment("cat.jpg",fileSystemResource);
        mimeMessageHelper.addInline("weixin",fileSystemResource);
        javaMailSender.send(mimeMailMessage);
    }
}
