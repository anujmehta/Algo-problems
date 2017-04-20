package BitM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AN039ME on 11/30/2015.
 */
public class Xoring {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCases = Integer.parseInt(bufferedReader.readLine());
        for(int i =1; i <= numOfTestCases; i++){
            int numOfElements = Integer.parseInt(bufferedReader.readLine());
            String[] split = bufferedReader.readLine().split("\\s+");
            int[] ints = new int[numOfElements];
            int idx= 0;
            for(String str : split){
                ints[idx++] = Integer.parseInt(str);
            }
            System.out.println(getXorSum(ints, numOfElements));
        }
    }

    private static int getXorSum(int[] ints, int numOfElements) {
        return getAllSubsets(ints, numOfElements);
    }

    private static int getXor(List<Integer> subset) {
        if(subset.size() == 1)
        {
            return subset.get(0);
        }
        else {
            int xorValue = 0;
            for(Integer num : subset){
                xorValue ^= num;
            }
            return xorValue;
        }
    }

    private static int getAllSubsets(int[] ints, int numOfElements) {
        int xorSum = 0;
        double totalSize = Math.pow(2.0, numOfElements);
        for(int i = 0; i < totalSize; i++){
            List<Integer> subList = new ArrayList<>();
            for(int j = 0; j < numOfElements; j++){
                if( (i & (1<<j)) > 0){
                    subList.add(ints[j]);
                }
            }
            if(!subList.isEmpty()) {
                xorSum += getXor(subList);
            }
        }
        return (int) (xorSum%(Math.pow(10.0, 9.0) + 7));
    }
}
