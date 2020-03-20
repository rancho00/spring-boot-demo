package spring.boot.demo.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    public void contextLoads() throws MessagingException {
//        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
//        simpleMailMessage.setSubject("通知");
//        simpleMailMessage.setText("今晚8点沙城不见不散！");
//        simpleMailMessage.setTo("291549571@qq.com");
//        simpleMailMessage.setFrom("191405738@qq.com");
//        javaMailSender.send(simpleMailMessage);

        for(int i=0;i<50;i++){
            MimeMessage mimeMessage=javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setSubject("通知");
            mimeMessageHelper.setText("充满鲜花的世界在哪里！"+i,false);
            mimeMessageHelper.setTo("136859659@qq.com");
            mimeMessageHelper.setFrom("191405738@qq.com");
            //mimeMessageHelper.addAttachment("111.jpg",new File(""));
            javaMailSender.send(mimeMessage);
        }

    }

}
