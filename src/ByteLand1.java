import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by an039me on 1/19/2016.
 */
public class ByteLand1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = bufferedReader.readLine().split("\\s+");
        int M = Integer.parseInt(dimensions[0]);
        int N = Integer.parseInt(dimensions[1]);
        int[][] array = new int[M][N];
        for(int i = 0; i < M; i++){
            String[] strings = bufferedReader.readLine().split("\\s+");
            for(int j = 0; j < N; j++){
                array[i][j] = Integer.parseInt(strings[j]);
            }
        }
        getWays(array, M, N);
    }

    private static void getWays(int[][] array, int M, int N){
        int[][] numOfWays = new int[M][N];
        for(int i  = 1; i < M; i++){
            for (int j = 1; j < N; j++){
                numOfWays[i][j] += array[i-1][j-1] + array[i-1][j] + array[i][j-1];
            }
        }
        System.out.println(numOfWays[M-1][N-1]);
    }
}