import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1217 {
	
	static int T;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<10; t++) {
			T = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			result = square_recur(N, M);
	
			System.out.println("#"+T+" "+result);
			
		}
	}
	
	
	public static int square_recur(int N, int M) {
		if(M==0) {
			return 1;
		}
		
		return  N * square_recur(N, M-1);
	}
}
