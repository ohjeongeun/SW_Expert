package day0821;

public class Permutation_dfs {
	
	public static void main(String[] args) {
		int n=6;
		int order[] = new int[n];
		int k=0;
		perm(order, k, n);
	}

	public static void perm(int order[], int k, int n) {
		//단말노드에 도달
		if(k==n) {
			for(int i=0; i<n; i++) {
				System.out.print(order[i]);
			}
			System.out.println();
		
		}else {
			int check[] = new int[n];
			
			//선택한 원소만큼(k개) check배열 방문 표시
			for(int i=0; i<k; i++) {
				check[order[i]]=1;
			}
			
			// 원소 수만큼 check배열 조사
			for(int i=0; i<n; i++) {
				
				//order[i]가 선택되지 않은 부분 찾아서
				if(check[i]==0) {
					order[k]=i;
					//재귀 호출
					perm(order, k+1, n);
				}
			}
			
			
		}
		
		
	}
	
}
