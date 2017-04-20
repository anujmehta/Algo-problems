import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by an039me on 2/9/2016.
 */
public class MysNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine().trim());
        Set<Integer> setA = new HashSet<>();
        String[] split = bufferedReader.readLine().split("\\s+");
        if(split.length > 0) {
            for (String str : split) {
                setA.add(Integer.parseInt(str));
            }
        }

        String[] strings = bufferedReader.readLine().split("\\s+");
        if(strings.length > 0) {
            for (String str : strings) {
                int val = Integer.parseInt(str);
                if (!setA.contains(val)) {
                    System.out.println(val);
                    break;
                }
            }
        }
    }
}
