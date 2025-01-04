package com.tpe.task.controller;

import com.tpe.task.AppConfig;
import com.tpe.task.service.TaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner scanner=context.getBean(Scanner.class);
        TaskService service=context.getBean(TaskService.class);
        int choice;

        do {
            System.out.println("===Görev Yönetimi===");
            System.out.println("1. Görev Ekle");
            System.out.println("2. Tüm Görevleri listele");
            System.out.println("3. Görevi sil");
            System.out.println("4. Görevi güncelle");
            System.out.println("Seçimini Yapınız : ");
            choice= scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Görev Başlığı girin");
                    String title= scanner.nextLine();
                    service.addTask(title);
                    System.out.println("Görev Eklendi.");
                    break;
                case 2:
                    System.out.println("Tüm görevler : ");
                    service.getAllTask().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Silmek istediğiniz görevin id'sini giriniz");
                    int id= scanner.nextInt();
                    scanner.nextLine();
                    service.deleteTaskById(id);
                    break;
                case 4:
                    System.out.println("Güncellemek istediğiniz görevin id'sini giriniz");
                    int updateId= scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Güncellemek istediğiniz görevin başlığını giriniz");
                    title= scanner.nextLine();
                    service.update(updateId,title);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir değer giriniz.");
                    break;
            }

        }while (choice!=0);


    }
}
