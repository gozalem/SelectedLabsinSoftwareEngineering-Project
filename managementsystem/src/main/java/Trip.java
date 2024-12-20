class Trip {
    private String destination;
    private String date;
    private double price;
    private String accommodation;
    private String packageType;

    public Trip(String destination, String date, double price, String accommodation, String packageType) {
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.accommodation = accommodation;
        this.packageType = packageType;
    }

  public String showDetails() {
    return String.format(
        "Booking Details:\n\n" +
        "Destination: %s\n" +
        "Date: %s\n" +
        "Price: %.2f\n" +
        "Accommodation: %s\n" +
        "Package: %s\n" +
        "Additional Info: %s",  
        destination, 
        date, 
        price, 
        accommodation, 
        packageType, 
        "Some extra details here"  
    );
}

}



