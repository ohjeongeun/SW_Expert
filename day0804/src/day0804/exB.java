package day0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class exB {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=0; int K=0;
		while(st.hasMoreTokens()) {
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());	
		}
		
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		int i=0;
		while(st.hasMoreTokens()) {
			arr[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		/*for(int j=0; j<arr.length; j++) {
			System.out.println(arr[j]);
		}*/
		
		int p=0;
		int m=0;
		int sum=0;
		int sum1=0;
		for(int j=0; j<arr.length-(K-1); j++) {
			//System.out.println(j);
			int k=j;
			sum=0;
			while(k<j+K) {
				//System.out.print(arr[k]);
				sum+=k;
				k++;
			}
			m=sum/k;
			
			k=j;
			while(k<j+K) {
				//System.out.print(arr[k]);
				sum1 += Math.pow(k-m, 2);
				k++;
			}
			double result = sum1/K;
			
			System.out.println(result);
		}
		
		
		
		
		
	}

}
