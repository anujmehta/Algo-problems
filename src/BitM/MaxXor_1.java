package BitM;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by an039me on 12/7/2015.
 */
public class MaxXor_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(bufferedReader.readLine());
        int R = Integer.parseInt(bufferedReader.readLine());
        int xor = L ^ R;
        for(int i = L; i <= R; i++){
            for(int j = i; j <= R; j++){
                int tempXor = i ^ j;
                if(tempXor > xor){
                    xor = tempXor;
                }
            }
        }
        System.out.println(xor);
    }
}
