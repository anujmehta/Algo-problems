package Easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by an039me on 9/30/2015.
 */
public class MaxRImproved {

    public static void main(String []args)throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] rCounts = new int[N];
        for(int i = 0; i < N; i++){
            rCounts[i] = calculateR(bufferedReader.readLine());
        }
        for(int i = 0; i < N; i++){
            System.out.println(rCounts[i]);
        }
    }

    private static int calculateR(String str) {
        if(str.length() == 1){
            if(str.equals("K")) {
                return 1;
            }
            else {
                return 0;
            }
        }

        int count = 0;
        int len = str.length();
        int[] arr = new int[len];
        for(int i =0; i < len; i++){
            if(str.charAt(i) == 'K'){
                arr[i] = 1;
            }
            else {
                count++;
                arr[i] = -1;
            }
        }

        if(count == len){
            return count - 1;
        }
        return count + maxSum(arr);
    }

    private static int maxSum(int[] arr) {
        int maxSoFar = 0;
        int maxEnding = 0;
        for(int i = 0; i < arr.length; i++){
            maxEnding = maxEnding + arr[i];

            if(maxEnding < 0){
                maxEnding = 0;
            }

            if(maxSoFar < maxEnding){
                maxSoFar = maxEnding;
            }
        }
        return maxSoFar;
    }
}