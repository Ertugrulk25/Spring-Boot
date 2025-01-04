package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;
import java.util.Scanner;

@Component("slack_service")
@Scope("prototype")
public class SlackService implements MessageService{

    @Autowired
    private Random rnd;

    @Autowired
    private Scanner scanner;

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız slack ile gönderildi. Mesaj : "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
        //random değer üretelim
        //Random rnd=new Random();//bir tane
        System.out.println(rnd.nextInt(100));
        System.out.println("Spring Nasıl?");
        String str=scanner.nextLine();
        System.out.println(str);
    }

    @PostConstruct
    public void postContructor(){
        System.out.println("-----------Slack service objesi oluşturuldu");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("-----------Slack service objesi imha edildi");
    }
}
