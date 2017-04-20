package DP;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by AN039ME on 2/5/2016.
 */
public class ModifiedFibo {
    private static BigInteger A;
    private static BigInteger B;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextBigInteger();
        B = scanner.nextBigInteger();
        int N = scanner.nextInt();
        System.out.println(getNth(N));
    }

    private static BigInteger getNth(int n) {
        if(n == 1){
            return A;
        }
        if(n == 2){
            return B;
        }

        BigInteger nth = getNth(n - 1);
        return nth.multiply(nth).add(getNth(n-2));
    }
}
