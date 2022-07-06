import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Duplicates {

    // [2,1,2] [2,-1,2] [-2,-1,2] [-2,-1,2]

    //result [2]
    public List<Integer> findAllDups(int[] arr) {
        Set<Integer> resultSet = new HashSet<>();

        for (int i=0; i<arr.length; i++) {
            int index = Math.abs(arr[i]) - 1; //1
            if (arr[index] < 0) {
                resultSet.add(arr[i]);
            } else {
                arr[index] = -arr[index];
            }
        }

        return new ArrayList<>(resultSet);
    }
}
