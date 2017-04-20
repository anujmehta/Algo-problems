package mar;

/**
 * Created by an039me on 3/31/2017.
 */
public class SmallSubArr {

    public static void main(String[] args){
        int[] arr = {10,2,25,7,22};
        int n = 30;

        for(int i = 0; i < arr.length-1; i++){
            int sum = arr[i];
            for(int j = i+1; j <= arr.length-1; j++){
                sum += arr[j];
                if(sum >= n){
                    for(int k = i; k <= j; k++){
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println();
                    break;
                }
            }
        }
    }
}
