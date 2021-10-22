import java.io.BufferedReader;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, Integer> map = new HashMap<String, Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String[]> words = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int num = 9;

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            words.add(s);
            for (int j = 0; j < s.length; j++) {
                if (!map.containsKey(s[j])) {
                    map.put(s[j], (int) Math.pow(10, s.length - j - 1));
                } else {
                    map.put(s[j], map.get(s[j]) + (int) Math.pow(10, s.length - j - 1));
                }
            }
        }

        List<String> listKeySet = new ArrayList<>(map.keySet());
        Collections.sort(listKeySet, (a, b) -> (map.get(b).compareTo(map.get(a))));

        for (String key : listKeySet) {
            map.put(key, num--);
        }

        for (String[] item : words) {
            int sum = 0;
            for (String i : item) {
                sum = sum * 10 + map.get(i);
            }
            result += sum;
        }

        System.out.println(result);
    }
}
