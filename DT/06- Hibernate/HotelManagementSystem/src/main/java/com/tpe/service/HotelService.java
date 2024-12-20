package com.tpe.service;

import com.tpe.domain.Hotel;
import com.tpe.exceptions.HotelNotFoundException;
import com.tpe.repository.HotelRepository;

import java.util.List;
import java.util.Scanner;

public class HotelService {

    private Scanner scanner=new Scanner(System.in);

    private final HotelRepository hotelRepository;

    //paramli const
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    //1-c:save hotel
    public void saveHotel(){
        Hotel hotel=new Hotel();
        System.out.println("Enter hotel ID: ");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter hotel name: ");
        hotel.setName(scanner.nextLine());

        System.out.println("Enter hotel location: ");
        hotel.setLocation(scanner.nextLine());

        hotelRepository.save(hotel);

        System.out.println("Hotel is saved successfully. Hotel ID:"+hotel.getId());

    }

    //2-b:idsi verilen otelin konsolda yazılması
    public Hotel findHotelById(Long id) {

        Hotel foundHotel=hotelRepository.findById(id);//idsi verilen hotel
        try {

            if (foundHotel != null) {
                System.out.println("---------------------------------------");
                System.out.println(foundHotel);
                System.out.println("---------------------------------------");
                return foundHotel;
            } else {
                throw new HotelNotFoundException("Hotel not found by ID : " + id);
            }
        }catch (HotelNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    //3-b:tüm otelleri yazdırma
    public void getAllHotels() {

        List<Hotel> allHotels=hotelRepository.findAll();//select * from t_hotel

        if (allHotels.isEmpty()){
            System.out.println("Hotel list is EMPTY!");
        }else {
            System.out.println("---------------------- ALL HOTELS ---------------------");
            for (Hotel hotel:allHotels){
                System.out.println(hotel);
            }
            System.out.println("---------------------- ALL HOTELS ---------------------");
        }
    }
}
