package DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by an039me on 1/27/2016.
 */
public class SNS {
    private static int N;
    private static int K;
    private static int count;
    private static List<String> finalList = new ArrayList<>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int i = 0; i < testCases; i++) {
            N = scanner.nextInt();
            K = scanner.nextInt();
            List<Integer> numbers = new ArrayList<>();
            numbers.add(K);
            count = 0;
            partition(K, 0, numbers);
            System.out.println(finalList);
        }
    }

    private static void partition(int currentNum, int curSum, List<Integer> numbers) {
        curSum += currentNum;
        int diff = N - curSum;
        if(diff == 0){
            String str = "";
            for(Integer num : numbers){
                str += num;
            }
            List<String> permutation = permutation(str);
            boolean permPresent = false;
            for(String perm : permutation){
                if(finalList.contains(perm)){
                    permPresent = true;
                    break;
                }
            }

            if(!permPresent)
                finalList.add(str);

            curSum = 0;
            int firstNum  = numbers.get(0);
            numbers.clear();
            if(firstNum < N){
                firstNum += 1;
                numbers.add(firstNum);
                curSum = 0;
                partition(firstNum, curSum, numbers);
            }
            else  {
                return;//the end point
            }
        }
        else if(diff == K){
            numbers.add(K);
            partition(K, curSum, numbers);
        }
        else if(diff > K){
            if(diff == currentNum){
                numbers.add(currentNum);
                partition(currentNum, curSum, numbers);
            }
            if(diff < N) {
                numbers.add(diff);
                partition(diff, curSum, numbers);
            }
        }
        else {
            numbers.remove((Object)currentNum);
            curSum -= currentNum;
            if (currentNum < N) {
                numbers.add(currentNum + 1);
                partition(currentNum + 1, curSum, numbers);
            }
        }
    }

    private static List<String> permutation(String originalString){
        List<String> permutations = new ArrayList<>();
        performWork(originalString, "", permutations);
        return permutations;
    }

    private static void performWork(String originalString, String permString, List<String> permutations) {
        if(originalString.length() == 0){
            permutations.add(permString);
            return;
        }

        for(int i =0; i < originalString.length(); i++){
            char selectedChar = originalString.charAt(i);
            String remaining = originalString.substring(0, i) + originalString.substring(i+1);
            performWork(remaining, permString + selectedChar, permutations);
        }
    }
}
