package day0626;

public class Combination_Recur {

	static int an[]= {1, 2, 3, 4, 5}; //n���� ���Ҹ� ������ �ִ� �迭
	static int tr[]; //r���� ũ���� �迭, ���� �ӽ� ����� �迭
	public static void main(String[] args) {
		
		tr = new int[3];
		
		comb(5, 3);
		
	}
	
	public static void comb(int n, int r) { //n:��ü ���Ұ���, r:�����ؾ��� ���Ұ���
		
	
		if(r==0) { //(tr�迭 �� ��.)������ �ϳ��� ��찡 ��
			for(int i=0; i<3; i++) {
				System.out.print(tr[i]);
			}
			System.out.println();
			
		}else if(n<r) {
			return;
			
		}else {
			tr[r-1] = an[n-1];
			comb(n-1, r-1); //Ư�� ���� ���� ��, Ư�� ���� ������ n-1������ r-1����ŭ ����
			comb(n-1, r);	//Ư�� ���� ���� ��, Ư�� ���� ������ n-1������ r�� ����
		}
	}

}
