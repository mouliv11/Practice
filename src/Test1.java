import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test1 {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String formatDateTime = now.format(formatter);
        System.out.println(formatDateTime);

        String headerList = "INTCLNTAPPLID:MOE_CLIENT_APP";
        for (String header:headerList.split(",")) {
            System.out.println(header.split(":")[0]);
            System.out.println(header.split(":")[1]);
        }
    }
}
