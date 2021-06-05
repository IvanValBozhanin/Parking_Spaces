package com.company;

// Importing the necessary to use classes and static variables.

import java.util.Arrays;
import java.util.Scanner;

import static com.company.ParkingSpace.numberOfParkPlaces;
import static com.company.ParkingSpace.parkingPlaces;

public class Main {

    public static void main(String[] args) {
//        generateRandomData();
        inputDataForTheParkPlaces();
        new ShowListPanel();
    }

    // Using Scanner and the terminal the user enters the number, area, name of the person who is using the park place, and the description of the park place.
    private static void inputDataForTheParkPlaces() {
        Scanner in = new Scanner(System.in);
        for(int i=0;i<numberOfParkPlaces; ++i){
            // Prompted to insert the number of the park place.
            System.out.println("Park Place Number: ");
            int parkPlaceNumber = in.nextInt();

            // Prompted to insert the area of the park place.
            System.out.println("Park Place Area: ");
            double parkPlaceArea = in.nextDouble();

            // Prompted to insert the user's name of the park place.
            System.out.println("Name of the User of the Park Place: ");
            in.nextLine();
            String parkPlaceUser = in.next();

            // Prompted to insert the description of the park place.
            System.out.println("Description of the Parking Place: ");
            in.nextLine();
            String parkPlaceDescription = in.nextLine();

            // Prompted to insert data for next place if hasn't reached the end.
            if(i < numberOfParkPlaces - 1) {
                System.out.println("=====Next Place=====");
            }

            parkingPlaces[i] = new ParkingSpace(parkPlaceNumber, parkPlaceArea, parkPlaceUser, parkPlaceDescription);
        }
    }


    // Method for generating and filling the table with random information. Used for testing and debugging.
    public static void generateRandomData() {
        for(int i=0;i<numberOfParkPlaces;++i){
            StringBuilder name = new StringBuilder();
            StringBuilder des = new StringBuilder();
            for(int j=0;j<7; ++j){
                name.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((int) (Math.random()*26)));
            }
            name.append(" ");
            for(int j=0;j<10; ++j){
                name.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((int) (Math.random()*26)));
            }

            for(int j = 0 ;j<10;++j){
                for(int k = 0;k<10;++k){
                    des.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase().charAt((int) (Math.random()*26)));
                }
                des.append(" ");
            }
            parkingPlaces[i] = new ParkingSpace(i+1, Math.random()*100, name.toString(), des.toString());
        }
        Arrays.stream(parkingPlaces).forEach(System.out::println);
    }
}
