package A9;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by AN039ME on 2/14/2016.
 */
public class MinCoin {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        /*final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));*/
        int res;

        int _A_size = 0;
        _A_size = Integer.parseInt(in.nextLine());
        int[] _A = new int[_A_size];
        int _A_item;
        for(int _A_i = 0; _A_i < _A_size; _A_i++) {
            _A_item = Integer.parseInt(in.nextLine());
            _A[_A_i] = _A_item;
        }

        int _S;
        _S = Integer.parseInt(in.nextLine());

        res = getCount(_A, _S);
        System.out.println(res);
        /*bw.write(String.valueOf(res));
        bw.newLine();*/

        //bw.close();
    }

    static int getCount(int[] A, int S) {
       return getMinCount(A, A.length, S);
    }

    static int getMinCount(int coins[], int m, int V)
    {
        if (V == 0) return 0;

        int res = Integer.MAX_VALUE;

        for (int i=0; i<m; i++)
        {
            if (coins[i] <= V)
            {
                int sub_res = getMinCount(coins, m, V-coins[i]);
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        return res;
    }
}
