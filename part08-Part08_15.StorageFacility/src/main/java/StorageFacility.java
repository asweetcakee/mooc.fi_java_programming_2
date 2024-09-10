
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
public class StorageFacility {

    private HashMap<String, ArrayList<String>> storageMap;

    public StorageFacility() {
        this.storageMap = new HashMap<>();
    }

    public void add(String unit, String item) {
        unit = sanitizedString(unit);
        item = sanitizedString(item);

        this.storageMap.putIfAbsent(unit, new ArrayList<>());
        ArrayList<String> items = this.storageMap.get(unit);
        items.add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        storageUnit = sanitizedString(storageUnit);
        return this.storageMap.getOrDefault(storageUnit, new ArrayList<>());
    }

    public void remove(String storageUnit, String item) {
        storageUnit = sanitizedString(storageUnit);
        item = sanitizedString(item);
        ArrayList<String> items = this.storageMap.get(storageUnit);
        if (items != null) {
            items.remove(item);
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> units = new ArrayList<>();
        for (String key : this.storageMap.keySet()) {
            if (this.storageMap.get(key).isEmpty()) {
                continue;
            }
            units.add(key);
        }
        return units;
    }

    private String sanitizedString(String string) {
        if (string == null) {
            string = "";
        }
        return string.trim().toLowerCase();
    }
}
