import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// View
public class SW_1206 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine()); //Testcase 길이
			
			StringTokenizer st = new StringTokenizer(br.readLine()); //Testcase 받아서 공백단위로 쪼갬
			int a[] = new int[N]; //Testcase 받을 배열
			
			for(int i=0; i<a.length; i++) { //Testcase 배열에 data 삽입
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			int view=0; //조망권 
			for(int i=2; i<a.length-2; i++) { //건물이 지어지지 않은 맨왼쪽 두칸, 맨오른쪽 두칸은 비교에서 제외
				
				int left=0; 
				int right=0; 
				
				//좌 조망권
				if(a[i]>a[i-2] && a[i]>a[i-1]) {
					left= a[i] - Math.max(a[i-1], a[i-2]);
					//System.out.print(left+"좌 ");
				}
				
				//우 조망권
				if(a[i]>a[i+2] && a[i]>a[i+1]) {
					right = a[i] - Math.max(a[i+1], a[i+2]);
					//System.out.print(right+"우 ");
				}
				
				if(left>right) { //좌, 우 조망권 중 "작은 조망권"쪽이 살아남음
					view += right; //살아남은 조망권이 조망권변수 view에 더해줌
				}else {
					view += left;
				}
			}
			//System.out.println();
			System.out.println("#"+t+" "+view);
			
		}
	}
}
