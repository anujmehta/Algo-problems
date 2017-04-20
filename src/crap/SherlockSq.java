package crap;

import java.util.Scanner;

/**
 * Created by an039me on 2/29/2016.
 */
public class SherlockSq {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while (N > 0){
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int sqrt = (int) Math.sqrt(num1);
            int sqrt1 = (int) Math.sqrt(num2);
            int count = sqrt1 - sqrt;
            if(sqrt * sqrt == num1 || sqrt1 * sqrt1 == num2)
                count++;
            System.out.println(count);
            /*int count = 0;
            for(int i = num1; i <= num2; i++){
                if(isPerfectSquare(i))
                    count++;
            }*/
            N--;
        }
    }

    private static boolean isPerfectSquare(int i) {
        boolean isPerfectSquare = false;
        int sqrt = (int) Math.sqrt(i);
        if(sqrt * sqrt == i){
            isPerfectSquare = true;
        }
        return isPerfectSquare;
    }
}
