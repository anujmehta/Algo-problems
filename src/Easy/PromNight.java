package Easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by an039me on 9/30/2015.
 */
public class PromNight {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0; i < N; i++){
            String[] split = bufferedReader.readLine().split("\\s+");
            int m = Integer.parseInt(split[0]);
            int f = Integer.parseInt(split[1]);

            String[] males = bufferedReader.readLine().split("\\s+");
            String[] females = bufferedReader.readLine().split("\\s+");
            int[] mArr = new int[m];
            int[] fArr = new int[f];

            for(int idx = 0; idx < m; idx++){
                mArr[idx] = Integer.parseInt(males[idx]);
            }

            for(int idx = 0; idx < f; idx++){
                fArr[idx] = Integer.parseInt(females[idx]);
            }
            if(isPossible(mArr, fArr))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean isPossible(int[] males, int[] females) {
        Arrays.sort(males);
        Arrays.sort(females);
        int count = 0;
        int len = males.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < females.length; j++){
                if(males[i] > females[j]){
                    count++;
                    break;
                }

                if(males[i] < females[j]){
                    return false;
                }
            }
        }
        if(count == len)
            return true;
        return false;
    }
}
