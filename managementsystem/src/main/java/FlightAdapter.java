interface FlightBooking {
    String bookFlight();
}

class ExternalFlightSystem {
    public String reserveFlight() {
        return "Flight booked through System.";
    }
}
class FlightAdapter implements FlightBooking {
    private ExternalFlightSystem externalSystem = new ExternalFlightSystem();

    @Override
    public String bookFlight() {
        return externalSystem.reserveFlight();
    }
}
