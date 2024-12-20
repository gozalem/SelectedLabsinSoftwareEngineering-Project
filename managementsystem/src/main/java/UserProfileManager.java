public class UserProfileManager {
   
    private static UserProfileManager instance;
    private String name;
    private String email;
    private String preferences;
    private int loyaltyPoints;
    private String bookingHistory;

 
    private UserProfileManager() {
        name = "John Doe";
        email = "john@example.com";
        preferences = "Accommodation: Hotel\n" +
      "Package: Luxury";
        loyaltyPoints = 1200;
        bookingHistory = "Trip History:\n" +
           "1. Paris - 2024-05-12\n" +
           "2. London - 2023-12-25\n" +
           "3. Rome - 2023-11-15";
    }

    
    public static UserProfileManager getInstance() {
        if (instance == null) {
            instance = new UserProfileManager();
        }
        return instance;
    }

  
    public void updatePreferences(String newPreferences) {
        preferences = newPreferences;
    }

  
    public void addLoyaltyPoints(int points) {
        loyaltyPoints += points;
    }

   
    public void updateBookingHistory(String history) {
        bookingHistory = history;
    }

    
    public String getUserDetails() {
        return "Name: " + name + "\nEmail: " + email + "\nPreferences: " + preferences + 
               "\nLoyalty Points: " + loyaltyPoints + "\nBooking History: " + bookingHistory;
    }


    public void updateUserDetails(String newName, String newEmail) {
        this.name = newName;
        this.email = newEmail;
    }

   
    public String getProfileDetails() {
        return "Name: " + name + ", Email: " + email + ", Preferences: " + preferences + 
               ", Loyalty Points: " + loyaltyPoints + ", Booking History: " + bookingHistory;
    }
}
