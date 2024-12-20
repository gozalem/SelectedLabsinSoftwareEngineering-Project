/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author DELL
 */
interface BookingService {
    String showBooking(); 
}

class RealBookingService implements BookingService {
    private final String destination;
    private final String date;
    private final double price;
    private final String accommodation;
    private final String packageType;

    public RealBookingService(String destination, String date, double price, String accommodation, String packageType) {
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.accommodation = accommodation;
        this.packageType = packageType;
    }

    @Override
    public String showBooking() {
       
        return String.format(
            "Booking Details:\n\n" +
            "Destination: %s\n" +
            "Date: %s\n" +
            "Price: %.2f\n" +
            "Accommodation: %s\n" +
            "Package: %s",
            destination, date, price, accommodation, packageType
        );
    }
}

