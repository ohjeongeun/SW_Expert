package day0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=0; int b=0; int sum=0;
			while(st.hasMoreTokens()) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());	
			}
			
			if(a==1) { //1
				sum+=5000000;
			}else if(2<=a && a<=3) { //2,3
				sum+=3000000;
			}else if(4<=a && a<=6) { //4, 5, 6
				sum+=2000000;
			}else if(7<=a && a<=10) {//7, 8, 9, 10
				sum+=500000;
			}else if(11<=a && a<=15) {//11, 12, 13, 14, 15
				sum+=300000;
			}else if(16<=a && a<=21) {//16, 17, 18, 19, 20, 21 
				sum+=100000;
			}
			
			if(b==1) { //1
				sum+=5120000;
			}else if(2<=b && b<=3) { //2,3
				sum+=2560000;
			}else if(4<=b && b<=7) { //4, 5, 6, 7
				sum+=1280000;
			}else if(8<=b && b<=15) {//8, 9, 10, 11, 12, 13, 14, 15
				sum+=640000;
			}else if(16<=b && b<=31) {//16, 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31
				sum+=320000;
			}
			
			System.out.println(sum);
		}
		
	}

}
