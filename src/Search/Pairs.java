package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by AN039ME on 2/13/2016.
 */
public class Pairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split("\\s+");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        String[] strings = bufferedReader.readLine().split("\\s+");
        int[] array = new int[N];
        for(int i =  0; i < N; i++){
            array[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(array);
        int count = 0;
        int j = 1;
        int i = 0;
        while(i < N && j < N){
            int diff = array[j] - array[i];
            if(diff == K){
                count++;
                j++;
            }
            if(diff < K){
                j++;
            }
            if(diff > K){
                i++;
            }
        }
        System.out.println(count);
    }
}
