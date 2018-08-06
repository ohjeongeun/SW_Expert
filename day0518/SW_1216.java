import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_1216 {
	static int N=100;
	static int T;
	static char mat[][];
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		for(int t=0; t<10; t++) {
			T = Integer.parseInt(br.readLine());		
			mat = new char[N][N];
			
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<N; j++) {
					mat[i][j] = s.charAt(j);
				}
			}
			
			boolean flag;
			max=0;
			//가로 회문
			for(int i=0; i<N; i++) {
				flag=false;
				
				for(int len=N; len>=0; len--) {	
					
					for(int j=0; j<N-len+1; j++) {
						for(int l=0; l<(len/2); l++) {
							if(mat[i][j+l]!=mat[i][j+(len-1)-l]) {
								flag=false;
								break;
							}else {
								flag=true;
							}
						}
						if(flag==true) {
							if(len>max) {
								max=len;	
							}
						}
					}	
				}
			}
			
			//세로 회문
			for(int j=0; j<N; j++) {
				flag=false;
				for(int len=N; len>=0; len--) {		
					for(int i=0; i<N-len+1; i++) {
						for(int l=0; l<(len/2); l++) {
							if(mat[i+l][j]!=mat[i+(len-1)-l][j]) {
								flag=false;
								break;
							}else {
								flag=true;
							}
						}
						if(flag==true) {
							if(len>max) {
								max=len;	
							}
						}
					}	
				}
			}
			System.out.println("#"+T+" "+max);
		}
	}
}