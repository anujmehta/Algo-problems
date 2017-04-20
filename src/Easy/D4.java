package Easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by an039me on 10/5/2015.
 */
public class D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split("\\s+");
        int myKey = Integer.parseInt(split[0]);
        int lockKey = Integer.parseInt(split[1]);

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] numbers = bufferedReader.readLine().split("\\s+");
        int[] numArr = new int[N];
        int i = 0;
        for(String number : numbers){
            numArr[i++] = Integer.parseInt(number);
        }
        System.out.println(findMin(myKey, lockKey, numArr));
    }

    private static int findMin(int mKey, int lockKey, int[] numArr) {
        int size = numArr.length;
        int[] flag = new int[100005];
        Arrays.fill(flag, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(mKey);
        while(!queue.isEmpty()){
            Integer element = queue.remove();
            if(element == lockKey){
                break;
            }
            for(int i = 0; i < size; i++){
                long value = element * numArr[i];
                value %= 100000;
                //int value = (element * numArr[i]) % 100000;
                if(flag[((int) value)] == -1){
                    flag[((int) value)] = flag[element] + 1;
                    queue.add((int) value);
                }
                /*if(value == lockKey){
                    return flag[i] + 1;
                }
                else
                {
                    flag[i] = flag[i] + 1;
                    queue.add(value);
                }*/
            }
        }
        return flag[lockKey];
    }
}
