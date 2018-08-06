package day0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy_Babygin {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input=Integer.parseInt(br.readLine());
		
		int arr[] = new int[10];

		int i=0;
		int cnt=0;
		while(true) {
			if(cnt==6)
				break;
			i=input%10;
			arr[i]++;
			cnt++;
			input /= 10;
			
		}
		
		int index=0;
		int triple=0;
		int run=0;
		while(index<10) {
			
			if(arr[index]>=1 && arr[index+1]>=1 && arr[index+2]>=1) {
				arr[index] -=1;
				arr[index+1] -=1;
				arr[index+2] -=1;
				run=1;
				continue;
			}
			
			if(arr[index]>=3) {
				arr[index] -= 3;
				triple=1;
				continue;
			}
			
			index++;
			
		}
		
		if(run+triple==2) {
			System.out.println("Baby-Gin");
		}else  {
			System.out.println("Lose");
		}
		
		
	}

}
