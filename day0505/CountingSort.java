import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingSort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int data[] = new int[8];
		for(int i=0; i<data.length; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
	
		//cnt[]의 배열의 길이는 data[i]값 중 최댓값.
		int max=0;
		for(int i=0; i<data.length; i++) {
			if(data[i]>max) {
				max = data[i];
			}
		}
		
		int cnt[] = new int[max+1]; 
		int tmp[] = new int[8]; //정렬된 array
		
		//data[i]의 갯수 cnt[]배열에 저장
		for(int i=0; i<data.length; i++) {
			cnt[data[i]]++;
		}
		
		//cnt[i]는 각 항목의 앞에 위치할 항목의 개수 반영하기 위해 
		//각 원소 누적하여 표현.
		for(int i=1; i<cnt.length; i++) {
			cnt[i] += cnt[i-1];
		}
		
		//정렬
		for(int i=data.length-1; i>=0; i--) {
			cnt[data[i]] -= 1;
			tmp[cnt[data[i]]] = data[i];
		}
		
		//정렬 후 data배열
		System.out.println();
		for(int i=0; i<tmp.length; i++) {
			System.out.print(tmp[i]+" ");
		}
	
	}
}
