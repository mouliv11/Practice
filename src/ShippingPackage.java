import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShippingPackage {

    private static boolean feasible(List<Integer> weights, int maxWt, int d) {
        int reqDays = 1;
        int capacity = maxWt;
        int i=0;
        while (i < weights.size()) {
            if (weights.get(i) <= capacity) {
                capacity = capacity - weights.get(i);
                i++;
            } else {
                reqDays++;
                capacity = maxWt;
            }
        }
        return reqDays <= d;
    }

    public static int minMaxWeight(List<Integer> weights, int d) {
        int minPtr = Collections.max(weights);
        int maxPtr = 0;
        for (int weight : weights)
            maxPtr = maxPtr + weight;
        int index = maxPtr;
        while (minPtr <= maxPtr) {
            int mid = (minPtr + maxPtr)/2;
            if (feasible(weights, mid, d)) {
                index = mid;
                maxPtr = mid - 1;
            } else {
                minPtr = mid + 1;
            }
        }
        return index;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? Stream.of("").collect(Collectors.toList()) :
                Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> weights = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int d = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = minMaxWeight(weights, d);
        System.out.println(res);
    }
}
