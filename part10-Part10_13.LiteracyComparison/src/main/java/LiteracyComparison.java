
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LiteracyComparison {

    public static void main(String[] args) {
        List<Literacy> literacyData = new ArrayList<>();
        try {
            literacyData = Files.lines(Paths.get("literacy.csv"))
                    .map(row -> row.trim().split(","))
                    .filter(parts -> parts.length >= 2)
                    .map(parts -> new Literacy(
                    sanitizeGender(parts[2]),
                    sanitizedString(parts[3]),
                    Integer.valueOf(parts[4]),
                    Double.valueOf(parts[5])))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        literacyData.stream()
                .sorted((a, b) -> {
                    if (a.getLiteracyPercent() > b.getLiteracyPercent()){
                        return 1;
                    }
                    if (a.getLiteracyPercent() == b.getLiteracyPercent()){
                        return 0;
                    } else {
                      return -1;  
                    }
                })
                .forEach(el -> System.out.println(el));  
    }

    private static String sanitizedString(String string) {
        if (string == null) {
            string = "";
        }
        return string.trim();
    }

    private static String sanitizeGender(String gender) {
        if (gender == null) {
            return "";
        }
        return gender.trim().replaceAll("%|\\(|\\)", "").trim();
    }
}