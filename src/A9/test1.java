package A9;

/**
 * Created by AN039ME on 2/14/2016.
 */
public class test1 {
    public static void main(String[] args){
        int[] arr = {2,3,5,9,10};
        System.out.println(findMin(arr, 0, arr.length-1));
    }

    static int findMin(int[] arr, int start, int end){
        int min = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    static int findMax(int[] arr, int start, int end){
        int max = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    int minRemovals(int arr[], int l, int h)
    {
        if (l >= h)
            return 0;

        int mn = findMin(arr, l, h);
        int mx = findMax(arr, l, h);

        //If the property is followed, no removals needed
        if (2*mn >= mx)
            return 0;

        return Math.min(minRemovals(arr, l+1, h),
                minRemovals(arr, l, h-1)) + 1;
    }
}
