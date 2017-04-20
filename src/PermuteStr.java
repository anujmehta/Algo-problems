import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AN039ME on 2/4/2016.
 */
public class PermuteStr {
    private static List<String> combinations = new ArrayList<>();
    private static int k;
    private static boolean missionComplete = false;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        k = Integer.parseInt(bufferedReader.readLine());
        permute(string);

    }

    private static void permute(String string) {
        performPermute(string, "");
    }

    private static void performPermute(String originalString, String permString) {
        if(missionComplete){
            return;
        }

        if(originalString.length() == 0){
            combinations.add(permString);
            if(combinations.size() == k){
                System.out.println(combinations.get(k-1));
                missionComplete = true;
            }
            return;
        }

        for(int i = 0; i < originalString.length(); i++){
            performPermute(originalString.substring(0, i) + originalString.substring(i + 1),
                    permString + originalString.charAt(i));
        }
    }
}
