package Greedy;

import java.util.Scanner;

/**
 * Created by AN039ME on 2/12/2016.
 */
public class GridChallenge {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int i = 0; i < testCases; i++){
            int N = scanner.nextInt();
            char[][] chars = new char[N][N];
            for(int j = 0; j < N; j++){
                chars[j] = sort(scanner.next().toCharArray());
            }

            char[] columnArray = new char[N];
            int l = 0;
            for(l = 0;  l < N; l++){
                for(int k = 0; k < N; k++){
                  columnArray[k] = chars[k][l];
                }
                if(!isSorted(columnArray)){
                    System.out.println("NO");
                    break;
                }
            }
            if(l == N){
                System.out.println("YES");
            }
        }
    }

    private static boolean isSorted(char[] chars){
        for(int i = 0; i < chars.length-1; i++){
            if(chars[i] > chars[i+1]){
                return false;
            }
        }
        return true;
    }

    private static char[] sort(char[] array){
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    swap(array, i - 1, i);
                    swapped = true;
                }
            }
        }while (swapped);
        return array;
    }

    static void swap(char[] array, int from, int to){
        char temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
