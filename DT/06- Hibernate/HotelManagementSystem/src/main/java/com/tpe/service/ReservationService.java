package com.tpe.service;

import com.tpe.domain.Guest;
import com.tpe.domain.Reservation;
import com.tpe.domain.Room;
import com.tpe.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class ReservationService {

    private Scanner scanner=new Scanner(System.in);

    private final ReservationRepository reservationRepository;

    private final RoomService roomService;

    private final GuestService guestService;

    public ReservationService(ReservationRepository reservationRepository, RoomService roomService, GuestService guestService) {
        this.reservationRepository = reservationRepository;
        this.roomService = roomService;
        this.guestService = guestService;
    }

    //10-b
    public void createReservation() {

        Reservation reservation=new Reservation();

        System.out.println("Enter check-in date (yyyy-MM-dd):");
        String checkin= scanner.nextLine();
        reservation.setCheckInDate(LocalDate.parse(checkin));

        System.out.println("Enter check-out date (yyyy-MM-dd):");
        String checkout= scanner.nextLine();
        reservation.setCheckOutDate(LocalDate.parse(checkout));

        System.out.println("Enter room id : ");
        Long roomId= scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter guest id");
        Long guestId= scanner.nextLong();
        scanner.nextLine();

         Room room =roomService.findRoomById(roomId);
         Guest guest =guestService.findGuestById(guestId);

         if (room!=null && guest!=null) {
             reservation.setRoom(room);//objeler arasındaki ilişki kuruldu
             reservation.setGuest(guest);

             reservationRepository.save(reservation);
             System.out.println("Reservation is created successfully...");
         }else {
             System.out.println("Reservation is CANCELLED!!!");
         }

    }
}
