package Search;

import java.util.Scanner;

/**
 * Created by AN039ME on 2/13/2016.
 */
public class SherlockNArray {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases > 0){
            int N = scanner.nextInt();
            boolean indexFound = false;
            if(N == 1){
                scanner.nextInt();
                System.out.println("YES");
                indexFound = true;
                testCases--;
                continue;
            }
            int[] array = new int[N];
            int sum = 0;
            for(int i = 0; i < N; i++){
                array[i] = scanner.nextInt();
                sum += array[i];
            }

            int left = 0;
            int previous = array[0];
            int right = sum-previous;
            for(int i = 1; i < N; i++){
                left += previous;
                right -= array[i];
                previous = array[i];
                if(left == right){
                    System.out.println("YES");
                    indexFound = true;
                    break;
                }
            }
            if(!indexFound)
                System.out.println("NO");

            testCases--;
        }
    }
}
