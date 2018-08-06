package day0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Array 5Â÷½Ã 3:21
public class Bubblesort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a[] = new int[st.countTokens()];
		
		for(int i=0; st.hasMoreTokens(); i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int tmp=0;
		for(int p=a.length-1; p>=0; p--) {
			for(int q=0; q<p; q++) {
				if(a[q]>a[q+1]) {
					tmp = a[q];
					a[q]=a[q+1];
					a[q+1]=tmp;
				}
			}
		}
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}
