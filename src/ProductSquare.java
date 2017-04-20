import java.util.Scanner;

/**
 * Created by AN039ME on 2/28/2016.
 */
public class ProductSquare {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] numbers = new int[N];
        int idx = 0;
        int num = 1;
        while (num < N){
            numbers[idx++] = scanner.nextInt();
            num++;
        }

        int count = 0;
        long start = System.currentTimeMillis();
        for(int i = 0; i < N-1; i++){
            for(int j = i + 1; j < N; j++){
                if(isPerfectSquare(numbers[i] * numbers[j])) {
                    count++;
                }
            }
        }
        float probability = (float) count/( (N * (N-1))/2);
        System.out.printf("%.5f",probability);
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("\n" + diff);
    }

    private static boolean isPerfectSquare(int num){
        boolean isPerfectSquare = false;
        int start = 1;
        int sum = start;
        do {
            if(sum == num){
                isPerfectSquare = true;
                break;
            }
            start += 2;
            sum += start;
        }while (sum <= num);
        return isPerfectSquare;
    }
}
