package day0709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1242_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N=0;int M=0;
			while(st.hasMoreTokens()) {
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
			}
			
			char arr[][] = new char[N][M];
			
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			
			
			String str="";
			for(int i=0; i<N; i++) {
				for(int j=0; j<arr[i].length; j++) {
					
					if(arr[i][j]!='0') {
						String s = "";
						while(j<arr[i].length) {
							s += arr[i][j];
							j++;
						}
						str = rmZero(s);
						String biStr="";
						for(int p=0; p<str.length(); p++) {
							biStr += getBinary(str.charAt(p));
						}
						System.out.println(rmZero(biStr));
					}
					
					
					
				}
			}
	
			System.out.println("#"+t);
		}
		
		
	}
	
	static String rmZero(String s) {
		
		int i=s.length()-1;
		while(s.endsWith("0")) {
			s = s.substring(0, i);
			i--;
		}
		
		return s;
	}
	
	static String getBinary(char n) {
		switch (n) {
		case '0':
			return "0000";
		case '1':
			return "0001";
		case '2':
			return "0010";
		case '3':
			return "0011";
		case '4':
			return "0100";
		case '5':
			return "0101";
		case '6':
			return "0110";
		case '7':
			return "0111";
		case '8':
			return "1000";
		case '9':
			return "1001";
		case 'A':
			return "1010";
		case 'B':
			return "1011";
		case 'C':
			return "1100";
		case 'D':
			return "1101";
		case 'E':
			return "1110";
		case 'F':
			return "1111";
		default:
			return null;
			
		}
		
		
	}

}
