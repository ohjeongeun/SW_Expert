package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_1256 {
	static int T;
	static int K;
	static String str;
	static int len;
	static String arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			K = Integer.parseInt(br.readLine());
			str = br.readLine();
			len = str.length();
			arr = new String[len];
			
			for(int i=0; i<len; i++) {
				arr[i] = str.substring(i, len);
			}
			
			Arrays.sort(arr);
			
			
			
			
			
			
			System.out.println("#"+t+" "+arr[K-1]);
		}
		
	}
}
