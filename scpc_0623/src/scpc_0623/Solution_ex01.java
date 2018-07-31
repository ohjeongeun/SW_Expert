package scpc_0623;

/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.Scanner;
import java.util.LinkedList;
/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution_ex01 {
	static int Answer;
	static Scanner sc;

	public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer=0;
			int N = sc.nextInt(); // 선수의 인원 수
			int K = sc.nextInt(); // 실력 범위
			
			//"선수A 실력 - 선수B실력 > k" => 같은 버스
			
			int arr[] = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				
			}
			sort(arr, 0, N-1);
			
			LinkedList<Integer> list = new LinkedList<>();
			
			for(int i=0; i<arr.length; i++) {
				list.add(arr[i]); 
			}
			
			
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
			
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
	
	public static void sort(int a[], int begin, int end) {

		if(begin < end) {
			int p = partition(a, begin, end);
			sort(a, begin, p-1);
			sort(a, p+1, end);
		}
	}
	
	public static int partition(int a[], int begin, int end) {
		
		int pivot = (begin + end) /2;
		int low = begin;
		int high = end;
		
		while(low<high) {
			while(a[low] < a[pivot] && low<high) {
				low++;
			}
			
			while(a[high] >= a[pivot] && low<high) {
				high--;
			}
			
			if(low<high) {
				
				if(low == pivot) {
					pivot = high;
				}
				int tmp = a[high];
				a[high] = a[low];
				a[low] = tmp;
			}
			
		}
		int tmp = a[high];
		a[high] = a[pivot];
		a[pivot] = tmp;
		
		return high;
		
	}
	
	
	
}