    package Easy;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.*;

    /**
     * Created by an039me on 9/1/2015.
     */
    public class PandaXor {

        private static int count = 0;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
            m1(arr);
            System.out.println(count%1000000007);
        }

        public static void m1(int[] arr){
            Map<Integer, Integer> counterMap = new HashMap<>();
            Set<List<Integer>> setSet = new HashSet<>();
            int arrSize = arr.length;
            double totalSize = Math.pow(2.0, arrSize);
            for(int i = 0; i < totalSize; i++){
                List<Integer> subset = new ArrayList<>();
                for(int j = 0; j  < arrSize; j++){
                    if( (i & (1<<j)) > 0){
                        subset.add(arr[j]);
                    }
                }
                if(!subset.isEmpty()) {
                    setSet.add(subset);
                }
            }

            for(List<Integer> subset : setSet){
                int xorResult = 0;
                for(int num : subset){
                    xorResult ^= num;
                }

                if(xorResult > 0) {
                    if (counterMap.containsKey(xorResult)) {
                        count++;
                        counterMap.remove(xorResult);
                    } else {
                        counterMap.put(xorResult, 1);
                    }
                }
            }
        }
    }
