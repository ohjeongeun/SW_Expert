public class BruteForce {

	public static void main(String[] args) {
					// 0    1    2    3    4    5    6    7    8
		String S[] = {"A", "A", "A", "A", "B", "B", "C", "C", "B"};
		String P[] = {"A", "A", "B", "A", "A", "A", "C", "A", "B"};
		
		int j=0;
		for(int i=0; i<S.length; i++) {
			if(i==8) {
				System.out.println("문자열의 끝. 탐색 종료");
				break;
			}
			
			if(S[i].equals(P[j])) {
				System.out.println("S["+i+"]  = P["+j+"]. 한칸이동");
				j++;
				
			}else {
				System.out.println("S["+i+"] != P["+j+"]. 패턴 매칭 실패!");
				System.out.println();
				i -= j;	//i : 다음 시작점으로 이동	
				j = 0; //j : 원점으로 이동
			}
		}
	}
}
