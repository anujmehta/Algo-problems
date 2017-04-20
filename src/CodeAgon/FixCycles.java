package CodeAgon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by AN039ME on 2/18/2016.
 */
public class FixCycles {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int f = scanner.nextInt();

        List<Integer> sums = new ArrayList<>();
        int sum1 = a + b +c +d;
        int sum2 = e + d + a;
        int sum3 = f + a + b;

        int maxNegative = Integer.MIN_VALUE;
        if(sum1 < 0) {
            sums.add(sum1);
            if(sum1 > maxNegative)
                maxNegative = sum1;
        }
        if(sum2 < 0) {
            sums.add(sum2);
            if(sum2  > maxNegative)
                maxNegative = sum2;
        }
        if(sum3 < 0) {
            sums.add(sum3);
            if(sum3 > maxNegative)
                maxNegative = sum3;
        }

        if(sums.size() == 0){
            System.out.println(-1);
        }
        else {
            System.out.println(Math.abs(maxNegative));
        }
    }
}
