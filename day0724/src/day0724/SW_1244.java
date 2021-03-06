package day0724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.sound.midi.Synthesizer;

public class SW_1244 {
	static int arr[];
	static int maxI;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
			
			String str="";
			int s = 0;
			int N = 0; //교환횟수
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				str = st.nextToken();
				N = Integer.parseInt(st.nextToken());
			}
			
			s = Integer.parseInt(str);
			
			arr = new int[str.length()];
			
			
			for(int i=str.length()-1; i>=0; i--) {
				
				arr[i] = s%10;
				s/=10;
			}
			
			
			boolean flag=false;
			
			for(int i=0; i<arr.length-1; i++) {
				maxI = i; //78466-> 8"7"466
				
				for(int j=i+1; j<arr.length; j++) {//arr[i]보다 큰 수 탐색
					
					if(arr[maxI]<=arr[j]) {
						maxI=j;

					}
				}
				//arr[i]보다 큰 수 없을 경우 다음 회전으로 넘어감
				if(maxI==i) {
					continue;
				}
				

				int tmp = arr[i];
				arr[i] = arr[maxI];
				arr[maxI] = tmp;
				
				
				N--;

				
				
				while(i==arr.length-2 && N!=0) {
					int tmp1 = arr[i+1];
					arr[i+1] = arr[i]; 
					arr[i] = tmp1;
					
					N--;

				}
				
				if(N==0) {
					break;
				}


			}

			
			
			
			System.out.print("#"+t+" ");
			for(int p=0; p<arr.length; p++) {
				System.out.print(arr[p]);	
			}
			System.out.println();
		
			
		}
		
	}
	

	
	
	

}
