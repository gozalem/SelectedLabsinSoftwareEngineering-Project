import java.util.List;
import java.util.ArrayList;

/**
 * BookingManager is a Singleton class responsible for managing bookings.
 * It allows booking flights, hotels, and travel packages, and retrieves all bookings.
 */
public class BookingManager {

    private static BookingManager instance;

    static BookingManager getInstance(String destination, String date, double price, String description, String description0, String flight_Type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private final List<String> bookings; 

    private String destination;
    private String date;
    private double price;
    private String selectedPackage;
    private String selectedAccommodation;
    private String selectedFlightType;


    private BookingManager() {
        bookings = new ArrayList<>();
        System.out.println("Booking Manager Initialized!");
    }

    
    public static BookingManager getInstance() {
        if (instance == null) {
            instance = new BookingManager();
        }
        return instance;
    }

   
    public void setBookingDetails(String destination, String date, double price, 
                                   String selectedPackage, String selectedAccommodation, String selectedFlightType) {
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.selectedPackage = selectedPackage;
        this.selectedAccommodation = selectedAccommodation;
        this.selectedFlightType = selectedFlightType;
    }

    
    public String bookFlight(String flightDetails) {
        String booking = "Flight booked: " + flightDetails;
        bookings.add(booking);
        return booking;
    }

   
    public String bookHotel(String hotelDetails) {
        String booking = "Hotel booked: " + hotelDetails;
        bookings.add(booking);
        return booking;
    }

   
    public String bookPackage(String packageDetails) {
        String booking = "Package booked: " + packageDetails;
        bookings.add(booking);
        return booking;
    }

   
    public List<String> getAllBookings() {
        return bookings;
    }

   
    @Override
    public String toString() {
        return "Bookings: " + bookings;
    }

    String bookTrip(String destination, String date, double price, Accommodation accommodation, TravelPackage travelPackage) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}