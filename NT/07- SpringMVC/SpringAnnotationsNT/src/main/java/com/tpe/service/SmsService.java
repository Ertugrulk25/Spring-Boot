package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component//bu classın objeleri spring tarafından olusturulur ve yonetilir
//spring bean adı verilir
public class SmsService implements MessageService{

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız sms ile gönderiliyor. Mesaj : "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {

    }
}
















