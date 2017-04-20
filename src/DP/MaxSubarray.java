package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by AN039ME on 2/5/2016.
 */
public class MaxSubarray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().trim());
        while(testCases > 0){
            long N = Long.parseLong(bufferedReader.readLine().trim());
            String[] strings = bufferedReader.readLine().split("\\s+");
            long [] array  = new long[(int)N];
            int idx = 0;
            long nonContinousSum = 0;
            for(String str : strings){
                int value = Integer.parseInt(str);
                array[idx++] = value;
                if(value > 0)
                    nonContinousSum += value;
            }
            if(nonContinousSum == 0){
                if(N > 0){
                    long max = array[0];
                    for(int i = 1; i < N; i++){
                        if(array[i] > max)
                            max = array[i];
                    }
                    nonContinousSum = max;
                }
            }
            long continousMaxSum = getContinousMaxSum(array, N);
            if(continousMaxSum == 0 && nonContinousSum != 0){
                continousMaxSum = nonContinousSum;
            }
            System.out.println(continousMaxSum + " " + nonContinousSum);
            testCases--;
        }
    }

    private static int getContinousMaxSum(long[] array, long N) {
        int maxSum = 0;
        int maxSoFar = 0;

        for(int i = 0; i < N; i++){
            maxSoFar += array[i];

            if(maxSoFar < 0)
                maxSoFar = 0;

            if(maxSum < maxSoFar)
                maxSum = maxSoFar;
        }
        return maxSum;
    }
}
