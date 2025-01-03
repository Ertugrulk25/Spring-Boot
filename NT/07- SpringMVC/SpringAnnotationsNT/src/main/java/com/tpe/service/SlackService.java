package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component
public class SlackService implements MessageService{
    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız slack ile gönderildi. Mesaj : "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {

    }
}
