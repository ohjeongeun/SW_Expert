import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1219 {

	static int T;
	static int len;
	static int arr1[];
	static int arr2[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=0; t<10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				T = Integer.parseInt(st.nextToken());
				len = Integer.parseInt(st.nextToken());	
			}
			arr1 = new int[100];
			arr2 = new int[100];
			
			st = new StringTokenizer(br.readLine());
			/*while(st.hasMoreElements()) {
				arr1[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
				arr2[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
				
			}*/
			for(int i=0; i<len; i+=4) {
				
				arr1[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
				if(!st.hasMoreTokens()) {
					break;
				}
				arr2[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}
			
			
			int result = search(0);
			System.out.println("#"+T+" "+result);
			
		}

	}
	static int next1, next2;
	public static int search(int cur) {
		next1 = arr1[cur];
		next2 = arr2[cur];
		
		if(next1==99 || next2==99) {
			return 1;
		}
		if(next1==0 && next2==0) {
			return 0;
		}
		
		if(next1==0) {
			return search(next2);
		}
		else if(next2==0) {
			return search(next1);
		}else {
			return search(next2);
		}
		
		
		
	}
	


}
