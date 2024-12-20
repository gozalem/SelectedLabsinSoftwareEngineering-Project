public interface TravelPackage {
    String getDetails();
    String getDescription();
}

class LuxuryPackage implements TravelPackage {
    public String getDetails() {
        return "Luxury Package: Includes 5-star hotels, premium flights, and VIP services.";
    }

    @Override
    public String getDescription() {
        return "This is a luxury travel package, perfect for those who want to experience the finest accommodations and exclusive services.";
    }
}

class AdventurePackage implements TravelPackage {
    public String getDetails() {
        return "Adventure Package: Includes hiking, camping, and extreme sports.";
    }

    @Override
    public String getDescription() {
        return "This adventure travel package is designed for thrill-seekers who want to explore nature and engage in outdoor activities like hiking, camping, and more.";
    }
}

class CulturalPackage implements TravelPackage {
    public String getDetails() {
        return "Cultural Package: Includes museums, historical sites, and cultural events.";
    }

    @Override
    public String getDescription() {
        return "This cultural package offers an immersive experience in history, art, and traditions, perfect for those interested in learning more about different cultures.";
    }
}
