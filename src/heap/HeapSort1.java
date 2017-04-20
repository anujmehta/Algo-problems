package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by AN039ME on 2/12/2016.
 */
public class HeapSort1 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[N];
        String[] strings = bufferedReader.readLine().split("\\s+");
        int i = 0;
        for(String string : strings){
            array[i++] = Integer.parseInt(string);
        }
        sort(array);
        for(int num : array){
            System.out.print(num + " ");
        }
    }

    static void sort(int[] array){
        heapify(array);
        for(int i = N; i >= 0; i--){
            swap(array, 0, i);
            N--;
            maxHeap(array, 0);
        }
    }

    static void heapify(int[] array){
        N = array.length - 1;
        for(int i = N/2; i >= 0; i--){
            maxHeap(array, i);
        }
    }

    static void maxHeap(int[] array, int index){
        int max = index;
        int left = 2 * index;
        int right = 2 * index + 1;

        if(left <= N && array[left] > array[index]){
            max = left;
        }

        if(right <= N && array[right] > array[max]){
            max = right;
        }

        if(max != index){
            swap(array, max, index);
            maxHeap(array, max);
        }
    }

    private static void swap(int[] array, int max, int index) {
        int temp = array[max];
        array[max] = array[index];
        array[index] = temp;
    }

}
