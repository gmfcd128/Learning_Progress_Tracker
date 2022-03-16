import java.util.List;
import java.util.Comparator;

class Utils {

    public static void sortStrings(List<String> strings) {
        // your code here
        strings.sort(Comparator.reverseOrder());
    }
}
