package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;

public class WhatsappService implements MessageService {

    //private FileRepository repo=new FileRepository();

    // private Repository repo=new DbRepository();//sıkı bir bağımlılık
    private Repository repo;

    public WhatsappService(Repository repo) {//bağımlılığı başlangıçta vermeyip daha sonra enjekte ediyoruz
        this.repo = repo;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız whatsapp ile gönderiliyor. Mesaj: "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
       repo.save(message);
    }
}
