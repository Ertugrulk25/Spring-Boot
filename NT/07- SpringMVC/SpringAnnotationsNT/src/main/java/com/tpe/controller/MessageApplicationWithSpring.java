package com.tpe.controller;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MessageService;
import com.tpe.service.SlackService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageApplicationWithSpring {
    public static void main(String[] args) {

        Message message=new Message();
        message.setBody("Welcome SPRİNG :)");

        //config classını okur ve componentscan ile componentlari(bizim olusturdugumuz classlarda) ve beanleri(bizim olusturmadigimiz classlarda) tarar
        //sadece 1 tane spring bean olusturur ve context atar ve hazır olarak bekletir
        //bean istendiginde gerekliyse icine bagimliginini enjekte ederek gonderir
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(AppConfiguration.class);

        //mesajı sms ile gönderelim obje'ye ihtiyacim var
        MessageService service1=context.getBean(SmsService.class);//new kullanmadık, getBean obje getirir misin
        service1.sendMessage(message);

        MessageService service2=context.getBean(MessageService.class);//sms service
        service2.sendMessage(message);

        //slack ile gonderelim.
        MessageService service3=context.getBean(SlackService.class);
        service3.sendMessage(message);




    }
}
