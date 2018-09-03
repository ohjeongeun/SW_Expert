package day0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex {
	static int n;
	static String input[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			input = new String[n+1][3];

			for (int i=1; i<=n; i++) {
				int j = 0;
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				while (st.hasMoreTokens()) {
					input[i][j] = st.nextToken();
					j++;
				}
			}
			System.out.println("#"+t+" " + dfs(1));
		}
	}
	
	public static int dfs(int k) {
		String node = input[k][0];
		
		try {
			
			int c1Index = Integer.parseInt(input[k][1]); 
			int c2Index = Integer.parseInt(input[k][2]); 
			
			if (node.equals("-")) {
				return dfs(c1Index)-dfs(c2Index);

			} else if (node.equals("+")) {
				return dfs(c1Index)+dfs(c2Index);

			} else if (node.equals("*")) {
				return dfs(c1Index)*dfs(c2Index);

			} else {
				return dfs(c1Index)/dfs(c2Index);
			}
			
		}catch (Exception e) {
			return Integer.parseInt(node);
		}
		
	}

}