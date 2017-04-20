package CodeAgon;

import java.util.Scanner;

/**
 * Created by AN039ME on 2/18/2016.
 */
public class JesseRocks {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int jesseStrength = scanner.nextInt();
        int[] array = new int[N];
        int rockCount = 0;
        boolean rockSkipped = false;
        for(int i = 0; i < N; i++){
            array[i] = scanner.nextInt();
            if(array[i]  <= jesseStrength){
                rockCount++;
            }
            else {
                if(!rockSkipped)
                    rockSkipped = true;
                else
                    break;
            }
        }
        System.out.println(rockCount);
    }
}
