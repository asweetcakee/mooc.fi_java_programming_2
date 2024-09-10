
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mefferio
 */
public class LiteracyDataManager {

    private List<Literacy> literacyData;

    public LiteracyDataManager() {
        this.literacyData = new ArrayList<>();
    }

    public void read(String file) {
        try {
            this.literacyData = Files.lines(Paths.get(file))
                    .map(row -> row.trim().split(","))
                    .filter(parts -> parts.length >= 2)
                    .map(parts -> new Literacy(
//                    sanitizedString(parts[0]),
//                    sanitizedString(parts[1]),
                    sanitizeGender(parts[2]),
                    sanitizedString(parts[3]),
                    Integer.valueOf(parts[4]),
                    Double.valueOf(parts[5])))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Literacy> sortByLiteracyPercentage() {
        return this.literacyData.stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

    }
//
//    public void sort() {
//        Collections.sort(this.literacyData, (lit1, lit2)
//                -> Double.compare(lit1.getLiteracyPercent(), lit2.getLiteracyPercent())
//        );
//    }

    public List<Literacy> getLiteracyData() {
        return this.literacyData;
    }

    private String sanitizedString(String string) {
        if (string == null) {
            string = "";
        }
        return string.trim();
    }

    private String sanitizeGender(String gender) {
        if (gender == null) {
            return "";
        }
        return gender.trim().replaceAll("%|\\(|\\)", "").trim();
    }
}
