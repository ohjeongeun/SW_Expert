import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 최빈수 구하기
public class SW_1204 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<10; t++) {
			int T = Integer.parseInt(br.readLine());
			
			int cnt[] = new int[101]; // cnt배열의 index는 점수(0~100)
			StringTokenizer st = new StringTokenizer(br.readLine());
			int score=0;
			for(int i=0; i<1000; i++) {
				score = Integer.parseInt(st.nextToken());
				cnt[score]++;
			}
			
			int max=0;
			int maxscore=0;
			for(int j=0; j<101; j++) {
				if(cnt[j]>=max) { //최빈수 여러개 있을때에는 가장 큰 점수 출력해야하기 때문에 등호 필요
					max = cnt[j]; //score이 0부터 100일때까지 최빈수값 찾아 max변수에 저장
					maxscore = j; //그때의 score maxscore에 저장
				}
			}
			
			System.out.println("#"+T+" "+maxscore);
		}

	}

}
