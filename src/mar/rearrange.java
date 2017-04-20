package mar;

/**
 * Created by an039me on 3/31/2017.
 */
public class rearrange {

    public static void main(String[] args){
        int [] arr = {1,-3,0,4,-2};

        int i = -1;
        for(int j = 0; j < arr.length; j++){
            if(arr[j] < 0){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        for (int i1 : arr) {
            System.out.print(i1 + " ");
        }

    }
}
