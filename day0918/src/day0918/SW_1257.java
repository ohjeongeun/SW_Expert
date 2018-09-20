package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SW_1257 {
	static int T;
	static int K;
	static String str;
	static int len;
	static int visited[][];
	static ArrayList<String> arr;
	static String result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			K = Integer.parseInt(br.readLine());
			str = br.readLine();
			len = str.length();
			
			arr = new ArrayList<>();
			for(int i=0; i<=len; i++) {
				for(int j=i+1; j<=len; j++) {
					
					String token = str.substring(i, j);
					arr.add(token);
				}
			}
			
			List<String> unique = new ArrayList<String>(new HashSet<String>(arr));
			Collections.sort(unique);
			
			try {
				result = unique.get(K-1);
			}catch (Exception e) {
				result = "none";
			}
			
			System.out.println("#"+t+" "+result);
			
		}
	}
}
