import java.util.ArrayList;

public class KMP {

	static char s[] = {'a', 'b', 'c', 'd', 'a', 'b', 'c', 'd', 'a', 'b', 'c', 'e', 'f'};
	static char p[] = {'a', 'b', 'c', 'd', 'a', 'b', 'c', 'e', 'f'};
	
	public static int[] getNext() {
		int next[] = new int[p.length];
		int j=0;						
		for(int i=1; i<p.length; i++) {
			while(j>0 && p[i]!=p[j]) {
				j = next[j-1];			

			}
			if(p[i] == p[j]) { 
				j++;
				next[i] = j;

			}
		}
		return next;
	}
	
	public static ArrayList<Integer> kmp () {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int j=0;
		
		int next[] = getNext();
		for(int i=0; i<s.length; i++) {
			while(j>0 && s[i] != p[j]) {
				j = next[j-1];
			}
			if(s[i]== p[j]) {
				if(j==p.length-1) {
					list.add(i-p.length+1);
					j = next[j];
				}else {
					j++;
				}
			}
		}
		
		
		return list;
	}
	
	public static void main(String[] args) {
		
		System.out.println("s"+kmp()+"에서 pattern 찾음");
	}

}
