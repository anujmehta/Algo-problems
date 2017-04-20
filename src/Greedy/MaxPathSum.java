package Greedy;

/**
 * Created by AN039ME on 2/6/2016.
 */
public class MaxPathSum {
    public static void main(String[] args){
        int ar1[]  = {2, 3, 7, 10, 12, 15, 30, 34};
        int ar2[] =  {1, 5, 7, 8, 10, 15, 16, 19};
        System.out.println(maxPathSum(ar1, ar2, ar1.length, ar2.length));
    }

    private static int maxPathSum(int[] array1, int[] array2, int m, int n){
        int sum1 = 0, sum2 = 0, total = 0;
        int i = 0, j = 0;
        while (i < m && j < n){
            if(array1[i] < array2[j]){
                sum1 += array1[i++];
            }
            else if(array2[j] < array1[i]){
                sum2 += array2[j++];
            }
            else {
                total += Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;

                while (i < m && j < n && array1[i] == array2[j]){
                    total += array1[i++];
                    j++;
                }
            }
        }

        while(i < m){
            sum1 += array1[i++];
        }

        while (j< n){
            sum2 += array2[j++];
        }

        total += Math.max(sum1, sum2);
        return total;
    }
}

