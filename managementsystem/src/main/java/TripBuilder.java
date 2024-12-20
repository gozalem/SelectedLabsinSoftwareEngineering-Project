class TripBuilder {
    private String destination;
    private String date;
    private double price;
    private String accommodation;
    private String packageType;

    public TripBuilder(String destination, String date, double price) {
        this.destination = destination;
        this.date = date;
        this.price = price;
    }

    public TripBuilder withAccommodation(String accommodation) {
        this.accommodation = accommodation;
        return this;
    }

    public TripBuilder withPackage(String packageType) {
        this.packageType = packageType;
        return this;
    }

    public Trip build() {
        return new Trip(destination, date, price, accommodation, packageType);
    }
}
