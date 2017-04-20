package crap;

import java.util.Scanner;

/**
 * Created by AN039ME on 2/15/2016.
 */
public class Chillar {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = scanner.nextInt();
        }
        int sum = scanner.nextInt();
        System.out.println(getMin(array, sum));
    }

    private static int getMin(int[] array, int sum) {
        if(sum == 0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++){
            if(array[i] <= sum)
                min = Math.min(min, getMin(array, sum-array[i]));
        }
        if(min == Integer.MAX_VALUE)
            return min;
        else
            return min + 1;
    }


}
