package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by AN039ME on 2/12/2016.
 */
public class TwoArrays {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases > 0){
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] A = new int[N];
            Integer[] B = new Integer[N];
            for(int i = 0; i < N; i++){
                A[i] = scanner.nextInt();
            }
            for(int i = 0; i < N; i++){
                B[i] = scanner.nextInt();
            }
            Arrays.sort(A);
            Arrays.sort(B, Collections.reverseOrder());
            int i;
            for(i = 0; i < N; i++){
                if(A[i] + B[i] < K){
                    System.out.println("NO");
                    break;
                }
            }
            if(i == N){
                System.out.println("YES");
            }
            testCases--;
        }
    }
}
