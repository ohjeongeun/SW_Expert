package day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex1 {
	public static int startMoney = 20000;
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      	StringTokenizer st = new StringTokenizer(br.readLine());
      	int size = st.countTokens();
      	int arr[] = new int[size];
      	for(int i=0; i<size; i++) {
    	  arr[i] = Integer.parseInt(st.nextToken());
      	}
      	
      	for (int i = 0; i < arr.length; i++) {
			if(arr[i] < 4 || arr[i] > 178) break;
			
			if(arr[i] <= 40) startMoney -= 720;
			else {
				startMoney -= 720;
				int restCnt = (arr[i] - 41)/8 + 1;
				startMoney -= restCnt*80;
				
			}
		}
      	System.out.println(startMoney);
	}
}