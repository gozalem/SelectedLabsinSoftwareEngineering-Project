class BookingProxy implements BookingService {
    private RealBookingService realService;
    private final String destination;
    private final String date;
    private final double price;
    private final String accommodation;
    private final String packageType;

 
    public BookingProxy(String destination, String date, double price, String accommodation, String packageType) {
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.accommodation = accommodation;
        this.packageType = packageType;
    }

    @Override
    public String showBooking() {
        
        if (!checkAccess()) {
            return "Access Denied: You are not authorized to view booking details.";
        }

       
        if (realService == null) {
            System.out.println("Creating RealBookingService...");
           
            realService = new RealBookingService(destination, date, price, accommodation, packageType);
        }
       logAccess();

        return realService.showBooking();
    }

    private boolean checkAccess() {
      
        return true; 
    }

    private void logAccess() {
       
        System.out.println("Booking details accessed: " + destination);
    }

}
