package Search;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by AN039ME on 2/13/2016.
 */
public class IceCreamParlor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases > 0){
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            HashMap<String, Integer> diffMap = new HashMap<>();
            int i;
            for(i = 1; i <= N; i++){
                int num = scanner.nextInt();
                int diff = M - num;
                if(diff < 0){
                    continue;
                }
                String str1 = num + ":" + diff;

                if(diffMap.containsKey(str1)){
                    Integer index = diffMap.get(str1);
                    System.out.println(index + " " + i);
                    break;
                }
                else {
                    String str2 = diff + ":" + num;
                    diffMap.put(str2, i);
                }
            }
            while (i < N){
                scanner.nextInt();
                i++;
            }
            testCases--;
        }
    }
}
