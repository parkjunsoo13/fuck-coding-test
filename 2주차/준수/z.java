import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int count = 0;

    public static void dq(int size, int r, int c) {
        // System.out.println(size + " " + r + " " + c);
        if (size == 1) {
            count += r * 2 + c * 1;
            return;
        } else {
            if (size > r && size > c) {
                dq(size / 2, r, c);
            } else if (size <= r && size > c) {
                count = count + size * size * 2;
                dq(size, r - size, c);
            } else if (size > r && size <= c) {
                count = count + size * size;
                dq(size / 2, r, c - size);
            } else if (size <= r && size <= c) {
                count = count + size * size * 3;
                dq(size / 2, r - size, c - size);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int size = (int) Math.pow(2, n);

        dq(size, r, c);

        System.out.println(count);
    }
}
