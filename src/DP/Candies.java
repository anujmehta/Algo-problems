package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by AN039ME on 2/5/2016.
 */
public class Candies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine().trim());
        int[] grades = new int[num];
        int[] candies = new int[num];
        Arrays.fill(candies, 1);

        for(int i = 0; i < num; i++){
            grades[i] = Integer.parseInt(bufferedReader.readLine().trim());
        }

        for(int i = 1; i < num; i++){
            if(grades[i] > grades[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }

        for(int i = num-1; i > 0; i--){
            if(grades[i-1] > grades[i]){
                candies[i-1] = Math.max(candies[i] + 1, candies[i-1]);
            }
        }

        int sum  = 0;
        for(int candy : candies){
            sum += candy;
        }
        System.out.println(sum);
    }
}
