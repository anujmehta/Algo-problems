import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static final int M = 1000000007;
    public static long countWays(int[][] a, int rows, int cols) {
        long[] v = new long[cols];
        long[] d = new long[rows + cols - 1];
        long[] h = new long[rows];

        long ways = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int dindex = diagId(i, j, rows);
                ways = i == 0 & j == 0 ? a[0][0] : (a[i][j] * (v[j] + h[i] + d[dindex])) % M;
                h[i] = (h[i] + ways) % M;
                v[j] = (v[j] + ways) % M;
                d[dindex] = (d[dindex] + ways) % M;
            }
        }
        return ways;
    }
    private static int diagId(int i, int j, int rows) {
        if (i > j) return rows - 1 - (i - j);
        return rows - 1 + j - i;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int rows = s.nextInt();
        int cols = s.nextInt();
        int[][] a = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = s.nextInt();
            }
        }
        System.out.println(countWays(a, rows, cols));
    }
}