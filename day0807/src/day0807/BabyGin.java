package day0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BabyGin {
	/*
	run : 연속된 숫자 3개
	triplet : 동일한 숫자 3개
	baby-gin : run, triplet으로 구성된 문자열
	*/
	static int counts[];//0~9까지의 숫자의 빈도수 저장 
						//각원소를 체크하며 run, triplet, baby-gin 여부 판단
	
	static int tri;
	static int r;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		counts = new int[10]; //0,1,2,3, .. ~ 9
		
		for(int i=0; i<s.length(); i++) {
			int index = s.charAt(i)-'0';
			counts[index]++;
		}
		
		
		tri=0;
		r=0;
		triplet(counts);
		run(counts);
		
		if(tri+r==2) {
			System.out.println("Baby Gin!");
		}else {
			System.out.println("not Baby Gin");
		}
		
	}
	
	public static void triplet(int counts[]) {
		for(int i=0; i<counts.length; i++) {
			//counts[i] 3이상인것 찾으면
			if(counts[i]>=3) {
				//3차감해주고
				counts[i] -= 3;
				//triplet 표시
				tri++;
				i-=1;
			}
		}
	}
	
	public static void run(int counts[]) {
		for(int i=0; i<counts.length ;i++) {
			//counts[i] 1이상인것 찾으면
			if(counts[i]>=1) {
				boolean flag=false;
				
				//counts[i], counts[i+1], counts[i+2] 1이상인지 조사
				for(int j=0; j<3; j++) {
					//중간에 1미만인것 발견되면 break
					if(counts[i+j]<1) {
						flag=false;
						break;
					}
					
					flag=true;
				}
				
				//counts[i], counts[i+1], counts[i+2] 모두 1이상이면
				if(flag==true) {
					//1씩 차감해주고, run표시
					for(int k=0;k<3; k++) {
						counts[i+k]-=1;
					}
					r++;
				}
			}
		}
	}

}
