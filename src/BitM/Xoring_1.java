package BitM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by an039me on 12/7/2015.
 */
public class Xoring_1 {
    private static int MAX = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCases = Integer.parseInt(bufferedReader.readLine());
        for (int i = 1; i <= numOfTestCases; i++) {
            int numOfElements = Integer.parseInt(bufferedReader.readLine());
            String[] split = bufferedReader.readLine().split("\\s+");
            int Ors = Integer.parseInt(split[0]);
            for (int idx = 1; idx < numOfElements; idx++) {
                Ors |= Integer.parseInt(split[idx]);
            }
            for(int j = 0; j < numOfElements -1; j++){
                Ors = checkVal(Ors * 2);
            }
            System.out.println(Ors);
        }

    }


    private static int checkVal(int sum) {
           if(sum >= MAX){
               sum %= MAX;
           }
        return sum;
    }
}
