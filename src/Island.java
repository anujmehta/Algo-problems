import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by an039me on 1/15/2016.
 */
public class Island {
    public static void main(String[] arrgs) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numOfTestCases = Integer.parseInt(bufferedReader.readLine().trim());
        for(int num = 0;  num < numOfTestCases; num++){
            int N = Integer.parseInt(bufferedReader.readLine().trim());
            int [][] array = new int[N][N];
            int [][] statusArray = new int[N][N];
            for(int[] arr : statusArray){
                Arrays.fill(arr, -1);
            }
            for(int i = 0; i < N; i++){
                String[] strings = bufferedReader.readLine().trim().split("\\s+");
                int j = 0;
                for (String str:strings) {
                    array[i][j++] = Integer.parseInt(str);
                }
            }
            System.out.println(getPathCount(array, statusArray, N));
        }
    }

    private static int getPathCount(int[][] array, int[][] statusArray, int N) {
        int islandNum = 0;
        for(int i  = 0; i < N; i++){
            for(int j =0; j < N; j++){
                if(array[i][j] == 1 && statusArray[i][j] == -1){
                    getNeighbours(i,j, array, statusArray, N, ++islandNum);
                }
            }
        }
        /*for(int l = 0; l < N; l++){
            for(int m = 0; m < N; m++){
                System.out.print(statusArray[l][m] + " ");
            }
            System.out.println();
        }*/
        return islandNum;
    }

    private static void getNeighbours(int i, int j, int[][] array, int[][] statusArray, int N, int islandNum) {
        if(array[i][j] == 1){
            if(statusArray[i][j] == -1) {
                statusArray[i][j] = islandNum;
            }
            else {
                //this already belongs to some island
                return;
            }
        }
        else {
            //it's dangerous!
            return;
        }

        if(i - 1 >= 0 && j - 1 >= 0){
            getNeighbours(i-1,j-1, array, statusArray, N, islandNum);
        }

        if(j - 1 >= 0){
            getNeighbours(i, j-1, array,  statusArray, N, islandNum);
        }
        if(i - 1 >= 0){
            getNeighbours(i-1, j, array, statusArray, N, islandNum);
        }

        if(i - 1 >= 0 && j + 1 <= N - 1) {
            getNeighbours(i - 1, j + 1, array, statusArray, N, islandNum);
        }

        if(j + 1 <= N - 1){

            getNeighbours(i, j + 1, array, statusArray, N, islandNum);
        }

        if(i + 1 <= N - 1 && j - 1  >= 0) {
            getNeighbours(i + 1, j - 1, array, statusArray, N, islandNum);
        }

        if(i + 1 <= N - 1) {
            getNeighbours(i + 1, j, array, statusArray, N, islandNum);
        }

        if(i + 1 <= N - 1 && j + 1 <= N - 1) {
            getNeighbours(i + 1, j + 1, array, statusArray, N, islandNum);
        }
    }
}
