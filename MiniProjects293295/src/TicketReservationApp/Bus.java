package TicketReservationApp;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    //2-plaka, koltuk sayısı, koltuk numaraları:özellik,alan,field

    private String numberPlate;//34 TPE 789

    private int numberOfSeat;

    private List<String> seats=new ArrayList<>();//"1","2",......,"33"


    //3-paramli constructor:otobüs objesini oluşturduğumda öz.leri belli olsun

    public Bus(String plaka,int koltukSayisi){
        this.numberPlate=plaka;//34 TPE 789
        this.numberOfSeat=koltukSayisi;//33
        for (int i=1;i<=numberOfSeat;i++){
           //this.seats.add(String.valueOf(i));
           this.seats.add(i+"");
        }

    }



    //getter:değerlerin okunmasını sağlar
    public String getNumberPlate() {
        return numberPlate;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public List<String> getSeats() {
        return seats;
    }

    //setter:değerlerin değiştirilmesini sağlar

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }
}
