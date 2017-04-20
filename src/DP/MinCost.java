package DP;

/**
 * Created by AN039ME on 2/6/2016.
 */
public class MinCost {
    public static void main(String[] args){
        int cost[][] = { {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3} };
        System.out.println(minCost(cost, 2, 2));
    }

    private static int minCost(int[][] cost, int m, int n){
        int[][] array = new int[m+1][n+1];
        array[0][0] = cost[0][0];

        //initialize 1st column
        for(int i = 1; i <= m; i++){
            array[i][0] = array[i-1][0] + cost[i][0];
        }

        //initialize 1st row
        for(int i = 1; i <= n; i++){
            array[0][i] = array[0][i-1] + cost[0][i];
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <=n; j++){
                array[i][j] = cost[i][j] + min(array[i-1][j], array[i][j-1], array[i-1][j-1]);
            }
        }
        return array[m][n];
    }

    static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }
}
