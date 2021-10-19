import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int last = 0;

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            int stkTop = stk.isEmpty() ? 0 : stk.peek();
            if (stkTop < target) {
                for (int j = last + 1; j < target; j++) {
                    stk.push(j);
                    result.append("+\n");
                }
                last = target;
                result.append("+\n-\n");
            } else if (stk.peek() == target) {
                stk.pop();
                result.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(result);
    }   
}
