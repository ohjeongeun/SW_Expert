package day0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_1244 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int N = Integer.parseInt(st.nextToken()); //±³È¯È½¼ö
			
			int len = s.length();
			
			LinkedList<Integer> list = new LinkedList<>();
			for(int i=0; i<len; i++) {
				list.add(s.charAt(i)-'0');
			}
			
			
			int cycle=0;
			
			while(N!=0) {
				int max=0;
				int maxindex=0;
				int min=10000;
				int minindex=0;
				
				for(int j=cycle; j<list.size(); j++) {
					if(max<list.get(j)) {
						maxindex = j;
						max = list.get(j);
					}
					if(min>list.get(j)) {
						minindex=j;
						min = list.get(j);
					}
				
				}
				list.remove(maxindex);
				list.add(cycle, max);
				System.out.println(max+" "+maxindex+" "+cycle+"  min"+min+" "+minindex);
				
				N--;
				cycle++;
			}
			
			System.out.println("#"+t+" "+list);
		}
		
	}
	
	

}
