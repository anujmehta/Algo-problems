package Easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by AN039ME on 9/23/2015.
 */
public class MaxR {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] rCounts = new int[N];
        for(int i = 0; i < N; i++){
            rCounts[i] = calculateR(bufferedReader.readLine(), i);
        }
        for(int i = 0; i < N; i++){
            System.out.println(rCounts[i]);
        }
    }

    private static int calculateR(String str, int idx) {
        if(str.length() == 1){
            if(str.equals("K")) {
                return 1;
            }
            else {
                return 0;
            }
        }

        int firstK = -1;
        int lastK = -1;
        int kCount = 0;
        int rCount = 0;

        int len = str.length();

        for(int i = 0; i < len; i++){
            if(str.charAt(i) == 'K'){
                firstK = i;
                kCount = 1;
                break;
            }
        }

        if(firstK != -1) {
            for (int i = firstK; i < len; i++) {
                if(str.charAt(i) == 'K'){
                    kCount++;
                    lastK = i;
                }
                else {
                    rCount++;
                }
            }

            str = flip(str, firstK, lastK);
            return str.length() - str.replace("R", "").length();

        }
        else{
            return str.length() - 1;
        }
    }

    private static String flip(String str, int firstK, int lastK) {
        char[] chars = str.toCharArray();
        for (int i = firstK; i <= lastK; i++) {
            if (chars[i] == 'K') {
                chars[i] = 'R';
            } else {
                chars[i] = 'K';
            }
        }
        return new String(chars);
    }
}
