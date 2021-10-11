package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week1_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int[] array = new int[26];
		
		char[] cArray = str.toCharArray();
		
		for(char c : cArray) array[c - 'a']++;
		
		for(int i : array) System.out.print(i + " ");

	}

}
