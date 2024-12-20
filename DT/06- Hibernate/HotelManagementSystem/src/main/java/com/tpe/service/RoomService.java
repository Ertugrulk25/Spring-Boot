package com.tpe.service;

import com.tpe.domain.Hotel;
import com.tpe.domain.Room;
import com.tpe.repository.RoomRepository;

import java.util.Scanner;

//NOT:entitynin service classları kendi repository classları ile görüşür
//başka bir entity ile ilgili işlem gerekirse diğer entitynin service ile görüşür
public class RoomService {

    private Scanner scanner=new Scanner(System.in);
    private final RoomRepository roomRepository;

    private final HotelService hotelService;//new HotelService()

    public RoomService(RoomRepository roomRepository,HotelService hotelService) {
        this.roomRepository = roomRepository;
        this.hotelService=hotelService;
    }

    //4-b:alınan bilgiler ile odayı kaydetme
    public void saveRoom() {
        Room room=new Room();
        System.out.println("Enter room ID: ");
        room.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter room number: ");
        room.setNumber(scanner.next());

        System.out.println("Enter room capacity: ");
        room.setCapacity(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Enter hotel ID: ");
        Long hotelId= scanner.nextLong();
        scanner.nextLine();

        //idsi verilen oteli bulma
        //hotelrepository.findById(olmayanOtelin)=null
        //tekrar kontrol yapmaya gerek yok
        //hotelservice


        Hotel hotel =hotelService.findHotelById(hotelId);
        if (hotel!=null){
            room.setHotel(hotel);

           // hotel.getRooms().add(room);//mappedby tarafından yapıldı


            roomRepository.save(room);
            System.out.println("Room is saved successfully. Room id: "+room.getId());
        }else {
            System.out.println("Room couldn't saved!!!");
        }

    }
}
