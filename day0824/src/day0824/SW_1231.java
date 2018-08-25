package day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1231 {
	static int N;
	static String tree[];
	static String result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		for(int t=1; t<=10; t++) {
			N = Integer.parseInt(br.readLine());
			tree = new String[N+1];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					int index = Integer.parseInt(st.nextToken());
					tree[index] = st.nextToken();
					
					//자식시끼들 담는곳
					while(st.hasMoreTokens()) {
						st.nextToken();
					}
				}
			}
			result = "";
			recursive(1);
			System.out.println("#"+t+" "+result);
		}
		
	}
	

	
	
	public static void recursive(int node) {
		if(node>N) {
			return;
		}
		recursive(2*node);
		result += tree[node];
		recursive(2*node+1);
		
	}
	

}
