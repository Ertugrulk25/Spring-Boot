package com.tpe.controller;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SlackService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

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
//
        MessageService service2=context.getBean("slack_service",MessageService.class);//sms service,slack service
        service2.sendMessage(message);
        //getBean methoduna parametre olaran parenti verirsek ve eğer birden fazla child component edilmiş ise
        //beanin ismini belirtmeliyiz
//
//        //slack ile gonderelim.
        MessageService service3=context.getBean(SlackService.class);
        service3.sendMessage(message);
//
        MessageService service4=context.getBean(SmsService.class);
        service4.sendMessage(message);
        service4.saveMessage(message);//file
//        //smsService'i newlemedim
//        //service repoya bağımlı ama biz enjekte etmedik
//        //repo objesini de olusturmadık
//        //spring SAĞOLSUN


        //random bir değer üretelim ve yazdırılım
        //Random rnd=new Random();//bir kere
        Random rnd=context.getBean(Random.class);
        System.out.println("random değer : "+rnd.nextInt(100));

        MessageService service5=context.getBean(SlackService.class);
        service5.saveMessage(message);

        MessageService service6=context.getBean(SlackService.class);
        MessageService service7=context.getBean(SlackService.class);





        if (service6==service7){
            System.out.println("Aynı objeler");
            System.out.println(service6);
            System.out.println(service7);
        }else {
            System.out.println("Farklı objeler");
            System.out.println(service6);
            System.out.println(service7);
        }

        SlackService service8=context.getBean(SlackService.class);
        service8.printContact();
        System.out.println("---------------------------");
        service8.getContact();

        //prototype olan beani yok etme işlemi
        context.getBeanFactory().destroyBean(service6);

        context.close();

  //      MessageService service8=context.getBean(SlackService.class);
  //      service8.saveMessage(message);

        //default olarak singleton oluyor : bu classtan sadece bir tane bean uretiyor ve her seferinde bu beani cagiriyor!!!
        //bu olusturulan bean'in life cycle'ini Spxring yonetir ve Spring Sorumludur!!!

        //prototype olarak degistirebiliriz : bu ise classtan her cagrildiginda farkli bir obje uretmeyi saglar!!!
        //Beanlerin imhasından Spring sorumlu degildir
    }
}
