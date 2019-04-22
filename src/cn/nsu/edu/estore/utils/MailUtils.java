package cn.nsu.edu.estore.utils;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {

    public static void sendMail(String email,String emailInfo)
            throws AddressException, MessagingException, GeneralSecurityException {
        Properties prop=new Properties();
        prop.put("mail.host","smtp.163.com" );
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.auth", true);
        //1.创建sesssion
        Session session=Session.getInstance(prop);
        //开启session的调试模式，可以查看当前邮件发送状态
        session.setDebug(true);

        //2.通过session获取Transport对象（发送邮件的核心API）
        Transport ts=session.getTransport();
        //3.通过邮件用户名密码（授权码 ）链接
        ts.connect("17780713604@163.com", "hslzym1314");

        //4.创建邮件
        Message msg=createSimpleMail(session,email,emailInfo);

        //5.发送电子邮件
        ts.sendMessage(msg, msg.getAllRecipients());
    }
    private static Message createSimpleMail(Session session, String email, String emailInfo) throws AddressException, MessagingException {
        MimeMessage mm=new MimeMessage(session);
        //设置发件人
        mm.setFrom(new InternetAddress("17780713604@163.com"));
        //设置收件人
        mm.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        mm.setSubject("测试邮件");
        mm.setContent(emailInfo, "text/html;charset=gbk");
        return mm;
    }
}

