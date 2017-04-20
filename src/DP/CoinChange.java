package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Recursive solution - Coin Change
 * Created by AN039ME on 2/5/2016.
 */
public class CoinChange {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split("\\s+");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int[] array = new int[M];
        int idx = 0;
        String[] strings = bufferedReader.readLine().split("\\s+");
        for(String str : strings){
            array[idx++] = Integer.parseInt(str);
        }
        System.out.println(count(N, array, M));
    }

    private static int count(int n, int[] array, int m) {
        if(n == 0){
            return 1;
        }
        if(m <= 0 || n < 0){
            return 0;
        }
        return count(n, array, m-1) + count(n-array[m-1], array, m);
    }
}
