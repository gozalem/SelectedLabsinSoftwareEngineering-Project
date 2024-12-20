/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class AccommodationFactory {
    
    public static Accommodation createAccommodation(String type) {
        switch (type.toLowerCase()) {
            case "hotel":
                return new Hotel();
            case "hostel":
                return new Hostel();
            case "resort":
                return new Resort();
            default:
                throw new IllegalArgumentException("Unknown Accommodation Type: " + type);
        }
    }
}


