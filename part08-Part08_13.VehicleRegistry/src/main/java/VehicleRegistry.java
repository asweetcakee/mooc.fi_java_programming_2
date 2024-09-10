
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mefferio
 */
public class VehicleRegistry {

    private final HashMap<LicensePlate, String> licensePlates;

    public VehicleRegistry() {
        this.licensePlates = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        owner = sanitizedString(owner);
        boolean doesKeyExist = this.licensePlates.containsKey(licensePlate);
        if (doesKeyExist) {
            return false;
        } else {
            this.licensePlates.put(licensePlate, owner);
            return true;
        }
    }

    public String get(LicensePlate licensePlate) {
        String keyValue = this.licensePlates.get(licensePlate);
        return keyValue;
    }

    public boolean remove(LicensePlate licensePlate) {
        if (this.licensePlates.containsKey(licensePlate)) {
            this.licensePlates.remove(licensePlate);
            return true;
        }
        return false;
    }

    private String sanitizedString(String string) {
        if (string == null) {
            string = "";
        }
        return string.trim();
    }

    public void printLicensePlates() {
        for (LicensePlate licensePlate : this.licensePlates.keySet()) {
            System.out.println(licensePlate);
        }
    }

    public void printOwners() {
        ArrayList<String> noDoubleOwners = new ArrayList<>();
        for (String owner : this.licensePlates.values()) {
            if (!(noDoubleOwners.contains(owner))) {
                noDoubleOwners.add(owner);
                System.out.println(owner);
            }
        }
    }
}
