package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
	static int R;//����
	static int C;//����
	static String board[][];
	static int alphabet[];
	
					//�� �� �� ��
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
		}
		
		board = new String[R][C];
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j] = s.charAt(j)+"";
			}
		}
		
		//1~26��
		alphabet = new int [27];
		alphabet[board[0][0].charAt(0)-64]=1;
		ans=0;
		dfs(0, 0, 1);
		System.out.println(ans);
		
	} 
	
	public static void dfs(int y, int x, int cnt) {

		ans = Math.max(ans, cnt);
		
		//next���� Ž��
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			//board �����
			if(ny<0 || nx<0 || ny>=R || nx>=C) continue;
			
			//nex���� ���ĺ��� �ε���
			int p = board[ny][nx].charAt(0)-64;
			
			//�ߺ��� ���ĺ��̸�
			if(alphabet[p]==1) continue;
			
			alphabet[p]=1;
			dfs(ny, nx, cnt+1);
			
			// dfs ȣ�� �� 
			// ȣ�� �� �湮�� ������ ���ĺ��� �湮���� ���������� ó�� 
			// => �ٸ� ��η� ���� ��쵵 ��� ���ϱ� ����
			alphabet[p]=0;
			
		}
		
		
	}

}
