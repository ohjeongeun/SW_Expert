package day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2105 {
	static int T;
	static int N;
	static int map[][];
	static int visited[][];
					//����  ����  �»�  ���
	static int dx[] = {1, -1, -1, 1};
	static int dy[] = {1, 1, -1, -1};
	
	static int dessert[];
	static int max;
	static int startY;
	static int startX;
	static int flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			max = -1;
			for(int i=0; i<N-2; i++) {
				for(int j=1; j<N-1; j++) {
					startY = i;
					startX = j;
					visited = new int[N][N];
					dessert = new int[101];
					
									//ī���  ����   ȸ��
					dfs(startY, startX, 1, 100, 0);
				}
			}
			
			System.out.println("#"+(t+1)+" "+max);
			
		}
		
	}
	
	public static void dfs(int y, int x, int num, int direct, int c) {
		if(c>=5) return;
		
		visited[y][x]=1;
		dessert[map[y][x]]=1;
		
		
		System.out.println(startY+" " +startX+"  num:"+num+"  d:"+direct+" c:"+c);
		for(int ii=0; ii<N; ii++) {
			for(int jj=0; jj<N; jj++) {
				System.out.print(visited[ii][jj]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
									//�ּ� ī�� 4�� �̻�, ������ 4����������
			if(ny==startY && nx==startX && num>=4 && c>=3) {
				if(max<num) {
					max = num;
					return;
				}
			}
			
			
			//������� �Ѵ���?
			if(ny<0 || nx<0 || ny>=N || nx>=N) continue;

			//�̹� ���� ����Ʈ ������?
			if(dessert[map[ny][nx]]==1) continue;
			
			//�湮��������?
			if(visited[ny][nx]==1) continue;
			
			
			//�� ���� �����̸�
			if(i==direct) {
				dfs(ny, nx, num+1, i, c);
			
			//���� �ٲٸ� c++;
			}else {
				dfs(ny, nx, num+1, i, c+1);
			}
			visited[ny][nx]=0;
			dessert[map[ny][nx]]=0;
		
		}
		
		
		
	}
	

}
