package day0821;

public class Permutation_dfs {
	
	public static void main(String[] args) {
		int n=6;
		int order[] = new int[n];
		int k=0;
		perm(order, k, n);
	}

	public static void perm(int order[], int k, int n) {
		//�ܸ���忡 ����
		if(k==n) {
			for(int i=0; i<n; i++) {
				System.out.print(order[i]);
			}
			System.out.println();
		
		}else {
			int check[] = new int[n];
			
			//������ ���Ҹ�ŭ(k��) check�迭 �湮 ǥ��
			for(int i=0; i<k; i++) {
				check[order[i]]=1;
			}
			
			// ���� ����ŭ check�迭 ����
			for(int i=0; i<n; i++) {
				
				//order[i]�� ���õ��� ���� �κ� ã�Ƽ�
				if(check[i]==0) {
					order[k]=i;
					//��� ȣ��
					perm(order, k+1, n);
				}
			}
			
			
		}
		
		
	}
	
}
