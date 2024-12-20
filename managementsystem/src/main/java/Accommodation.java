public interface Accommodation {
    String getDetails();
    String getDescription(); 
}

class Hotel implements Accommodation {
    public String getDetails() {
        return "Hotel: Comfortable rooms with premium services.";
    }

    @Override
    public String getDescription() {
        return "A hotel offering comfortable rooms with luxury services like room service, gyms, and restaurants.";
    }
}

class Hostel implements Accommodation {
    public String getDetails() {
        return "Hostel: Shared rooms with basic facilities.";
    }

    @Override
    public String getDescription() {
        return "A budget-friendly accommodation with shared rooms, ideal for solo travelers or groups.";
    }
}

class Resort implements Accommodation {
    public String getDetails() {
        return "Resort: Luxurious accommodations with access to pools and beaches.";
    }

    @Override
    public String getDescription() {
        return "A resort offering a luxurious experience with pools, private beaches, and a variety of recreational activities.";
    }
}
