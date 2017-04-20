import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by AN039ME on 11/22/2015.
 */
public class Witch {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCases = Integer.parseInt(bufferedReader.readLine());
        for(int i = 1; i <= numOfTestCases; i++){
            String[] strings = bufferedReader.readLine().split("\\s+");
            if (strings.length == 3) {
                int[] heights = new int[strings.length];
                int idx = -1;
                for(String str : strings){
                    heights[++idx] = Integer.parseInt(str);
                }
                int maxValues = 0;
                maxValues = getValidMoves(heights, maxValues);
                System.out.println(maxValues);
            }
        }
    }

    private static int getValidMoves(int[] heights, int maxValues) {
        Arrays.sort(heights);
        if(heights[0] + 1 == heights[1] && heights[1] + 1 == heights[2])
        {
            return maxValues;
        }

        //try smallest one
        int firstPossibleHeight = getPossibleHeight(heights[0], heights[1], heights[2]);
        if(firstPossibleHeight != -1){
            maxValues++;
            heights[0] = firstPossibleHeight;
            return getValidMoves(heights, maxValues);
        }
        else {
            int lastPossibleHeight = getPossibleHeight(heights[2], heights[0], heights[1]);
            if(lastPossibleHeight != -1){
                maxValues++;
                heights[2] = lastPossibleHeight;
                return getValidMoves(heights, maxValues);
            }
            else {
                return maxValues;
            }
        }
    }

    private static int getPossibleHeight(int target, int start, int end) {
        for(int i = start + 1; i < end; i++){
            if(i != target){
                return i;
            }
        }
        return -1;
    }
}
