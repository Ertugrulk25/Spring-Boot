package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;

public class MailService implements MessageService {

    //private DbRepository repo=new DbRepository();
    //private FileRepository repo=new FileRepository();

   // private Repository repo=new DbRepository();//sıkı bir bağımlılık
    private Repository repo;

    public MailService(Repository repo) {
        this.repo = repo;
    }

    public void sendMessage(Message message){
        System.out.println("Mesajınız mail ile gönderiliyor. Mesaj: "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
         //data ile ilgili işlemler:repo
        //DbRepository repo=new DbRepository();
        repo.save(message);
    }
}
