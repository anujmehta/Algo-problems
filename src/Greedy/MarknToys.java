package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by AN039ME on 2/12/2016.
 */
public class MarknToys {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bufferedReader.readLine().split("\\s+");
        int Num = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int[] array = new int[Num];
        String[] strings = bufferedReader.readLine().split("\\s+");
        int i = 0;
        for(String string : strings){
            array[i++] = Integer.parseInt(string);
        }
        sort(array);
        int count = 0;
        int sum = 0;
        for(int num : array){
            int tempSum = sum + num;
            if(tempSum < K){
                sum = tempSum;
                count++;
            }
            else if(tempSum == K){
                count++;
                System.out.println(count);
                break;
            }
            else if(tempSum > K){
                System.out.println(count);
                break;
            }
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
