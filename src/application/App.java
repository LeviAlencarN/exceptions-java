package application;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model_entities.Reservation;

public class App {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Room number: ");
        int room = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date!");
        }
        else{
            Reservation reservation = new Reservation(room, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Room number: ");
            room = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            Date now = new Date();

            if(checkIn.before(now) || checkOut.before(now)){
                System.out.println("The dates must be in the future");
            }
            else if(!checkOut.after(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date!");
            }
        }

        sc.close();
    }
}
