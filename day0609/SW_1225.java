package day0609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1225 {

	static String T;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<10; t++) {
			T = br.readLine();
			
			q = new LinkedList<Integer>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			solve();
			
			System.out.print("#"+T+" ");
			for(int i=0; i<8; i++) {
				System.out.print(q.remove()+" ");
			}
			System.out.println();
		}

	}
	
	public static void solve() {
		
		while(true) {
			
			for(int i=1; i<=5; i++) {
				
				int item = q.remove();
				
				if(item-i <=0) {
					item=0;
					q.add(item);
					return;
				}else {
					item -= i;
					q.add(item);
				}
	
			}
			
			
		}
	}
}
