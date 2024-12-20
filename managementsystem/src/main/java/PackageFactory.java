/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class PackageFactory {
    public static TravelPackage createPackage(String type) {
        switch (type.toLowerCase()) {
            case "luxury":
                return new LuxuryPackage();
            case "adventure":
                return new AdventurePackage();
            case "cultural":
                return new CulturalPackage();
            default:
                throw new IllegalArgumentException("Unknown Package Type: " + type);
        }
    }
}



