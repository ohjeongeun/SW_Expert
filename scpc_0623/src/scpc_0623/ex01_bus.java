package scpc_0623;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ex01_bus {
	static int Answer;
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt(); // 선수의 인원 수
			int K = sc.nextInt(); // 실력 범위
			
			//"선수A 실력 - 선수B실력 > k" => 같은 버스
			
			/*int arr[] = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				
			}
			Arrays.sort(arr);*/
			
			
			LinkedList<Integer> list = new LinkedList<>();
			
			for(int i=0; i<N; i++) {
				list.add(sc.nextInt()); 
			}
			Collections.sort(list);
			Answer = 0;
			
			int pivot = 0;
			
			while(!list.isEmpty()) {
				
				pivot = list.removeFirst();
				
				for(int j=0; j<list.size(); j++) {
					
					if(list.get(j) - pivot > K) {
						pivot = list.remove(j);
					}
					
					
				}
				
				Answer++;
	
				
			}
			
			System.out.println("Case #"+t);
			System.out.println(Answer);

			long end = System.currentTimeMillis();
			System.out.println( "실행 시간 : " + ( end - start )/1000.0 );

			
		}

	}

}
