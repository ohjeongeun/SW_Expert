import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// Flattern
public class SW_1208 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine()); //덤프 횟수
			
			int a[] = new int[100]; //상자들
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<100; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=0; j<N; j++) {// 덤프 횟수만큼 최고점에서 최저점으로 상자 옮김
				Arrays.sort(a); //오름차순 정렬
				a[99] -= 1; //최고점-1
				a[0] += 1;  //최저점+1
			}
			
			Arrays.sort(a);
			int result=a[99]-a[0];
		
			System.out.println("#"+t+" "+result);
		}

	}

}
