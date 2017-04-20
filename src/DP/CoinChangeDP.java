package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Coin Change - DP Solution
 * Created by AN039ME on 2/5/2016.
 */
public class CoinChangeDP {
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
        int[] table = new int[n+1];
        table[0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = array[i]; j <= n; j++){
                table[j] += table[j-array[i]];
            }
        }

        return table[n];
    }
}
