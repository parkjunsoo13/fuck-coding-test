import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static String checkVPS(String input) {
        int balance = 0;
        List<String> targets = Arrays.asList(input.split(""));
        if (targets.size() % 2 != 0 
            && targets.get(0).equals(")") 
            && targets.get(targets.size() - 1).equals("(")) {
            return "NO";
        }

        for (String t : targets) {
            if (t.equals("(")) {
                balance++;
            } else if (t.equals(")") && balance > 0) {
                balance--;
            } else {
                return "NO";
            }
        }

        return balance == 0 ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println(checkVPS(br.readLine()));
        }
    }
}
