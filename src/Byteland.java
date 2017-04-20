import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by an039me on 1/18/2016.
 */
public class Byteland {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = bufferedReader.readLine().split("\\s+");
        int M = Integer.parseInt(dimensions[0]);
        int N = Integer.parseInt(dimensions[1]);
        int[][] array = new int[M][N];
        int[][] visitArray = new int[M][N];
        for(int[] visits : visitArray){
            Arrays.fill(visits, 0);
        }
        for(int i = 0; i < M; i++){
            String[] strings = bufferedReader.readLine().split("\\s+");
            for(int j = 0; j < N; j++){
                array[i][j] = Integer.parseInt(strings[j]);
            }
        }

        int total = 0;
        System.out.println(getTotal(array, visitArray, 0, 0, total, M, N));
    }

    private static int getTotal(int[][] array, int[][] visitedArray, int i, int j, int total, int M, int N) {
        if(i == M -1 && j == N - 1){
            total++;
            return total;
        }
        else {
            if(array[i][j] > 0 && visitedArray[i][j] < array[i][j]){
                visitedArray[i][j] = visitedArray[i][j] + 1;
            }
            else {
                return total;
            }
        }

        if(j + 1 < N){
            getTotal(array, visitedArray, i, j + 1, total, M, N);
        }

        if(i + 1 < M){
            getTotal(array, visitedArray, i + 1, j, total, M, N);
        }

        if(i + 1 < M  && j + 1 < N){
            getTotal(array, visitedArray, i + 1, j + 1, total, M, N);
        }
        return total;
    }
}
