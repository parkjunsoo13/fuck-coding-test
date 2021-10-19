import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] temp = new int[26];
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            temp[arr[i] - 'a']++;
        }

        for (int j = 0; j < temp.length; j++) {
            System.out.print(temp[j] + " ");
        }
    }
}
