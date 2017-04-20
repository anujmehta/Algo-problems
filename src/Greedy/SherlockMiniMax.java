package Greedy;

import java.io.IOException;
import java.util.*;

/**
 * Created by AN039ME on 2/12/2016.
 */
public class SherlockMiniMax {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];
        int idx = -1;
        //String[] split = bufferedReader.readLine().split("\\s+");
        for(int i = 0; i < N; i++){
            array[++idx] = scanner.nextInt();
        }
        //String[] strings = bufferedReader.readLine().split("\\s+");
        int P = scanner.nextInt();
        int Q = scanner.nextInt();

        Map<Integer, List<Integer>> details = new HashMap<>();
        int maxDiff = -1;
        for(int i = P; i <= Q; i++){
            int min = 999999;

            for(int num : array){
                int abs = Math.abs(i - num);
                if(min > abs)
                    min = abs;
            }
            if(min > maxDiff)
                maxDiff = min;
            if(details.containsKey(min)){
                details.get(min).add(i);
            }
            else {
                List<Integer> nums = new ArrayList<>();
                nums.add(i);
                details.put(min, nums);
            }
        }

        /*int maxDiff = -1;
        for (Integer integer : details.keySet()) {
            if(integer > maxDiff)
                maxDiff = integer;
        }*/

        int minNumber = 99999;
        for (Integer integer : details.get(maxDiff)) {
            if(integer < minNumber)
                minNumber = integer;
        }
        System.out.println(minNumber);
    }
}
