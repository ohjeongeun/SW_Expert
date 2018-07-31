package day0626;

public class Combination_Recur {

	static int an[]= {1, 2, 3, 4, 5}; //n개의 원소를 가지고 있는 배열
	static int tr[]; //r개의 크기의 배열, 조합 임시 저장될 배열
	public static void main(String[] args) {
		
		tr = new int[3];
		
		comb(5, 3);
		
	}
	
	public static void comb(int n, int r) { //n:전체 원소개수, r:선택해야할 원소개수
		
	
		if(r==0) { //(tr배열 다 참.)조합의 하나의 경우가 됨
			for(int i=0; i<3; i++) {
				System.out.print(tr[i]);
			}
			System.out.println();
			
		}else if(n<r) {
			return;
			
		}else {
			tr[r-1] = an[n-1];
			comb(n-1, r-1); //특정 문자 있을 때, 특정 문자 제외한 n-1개에서 r-1개만큼 뽑음
			comb(n-1, r);	//특정 문자 없을 때, 특정 문자 제외한 n-1개에서 r개 뽑음
		}
	}

}
