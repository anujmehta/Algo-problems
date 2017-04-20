package crap;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by AN039ME on 2/15/2016.
 */
public class MinMax {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);
        System.out.println(getMinMax(array, 0, N-1));
    }

    private static int getMinMax(int[] array, int start, int end) {
        if(start == end)
            return 0;

        int min = array[start];
        int max = array[end];

        if(2 * min >= max)
            return 0;

        return Math.min(getMinMax(array, start+1, end), getMinMax(array, start, end-1)) + 1;
    }


}
