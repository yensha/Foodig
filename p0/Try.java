package p0;
import java.time.LocalDate;


public class Try {
    public static void main(String[] args) {
        // // Get today's date
        // LocalDate today = LocalDate.now();
        // LocalDate expirationDate = LocalDate.of(2024, 05, 15);

        // System.out.println(today.isAfter(expirationDate));
        // // Display today's date
        // System.out.println("Today's date (using java.time.LocalDate): " + today);

        // LocalDate today1 = today.plusDays(3);
        // System.out.println("Today's date (using java.time.LocalDate): " + today1);
        // boolean expired = today1.isAfter(expirationDate);
        // System.out.println(expired);

        LocalDate expirationDate = LocalDate.of(2024, 05, 15);
        LocalDate manufacturedDate = LocalDate.of(2024, 05, 12);
        Food beef = new Food("beef", "proteins", expirationDate, manufacturedDate);
        System.out.println(beef.isExpiring());
    }
}