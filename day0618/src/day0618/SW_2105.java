package day0618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//����Ʈ ī��
// Queue ��� dfs�� �غ��� ������ ����..
// �̿��� �� �ְ� �õ��غ��� ������ �ȵ�
// �ѹ��� ���� �������� ���� ������ ������ �ȵ�,,
public class SW_2105 {
					//����    ����   �»�   ���
	static int dx[] = { 1, -1, -1, 1};
	static int dy[] = { 1, 1, -1, -1};
	
	static int N;
	static int map[][];
	static int visited[][];
	
	static Queue<int[]> q;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String T = br.readLine();
		for(int t=1; t<=10; t++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			cnt=1;
			solve(0, 1);
			
			System.out.println("#"+t+" ");
		}
	}
	
	public static void solve(int y, int x) {
		//Queue ����
		q = new LinkedList<>();
		visited = new int[N][N];
		
		int cury=y;
		int curx=x;
		//������ q�� ���� && �湮 ǥ��
		int temp[] = {cury, curx};
		q.add(temp);
		visited[cury][curx] = 1;
		

		while(!q.isEmpty()) {
			//t�� Queue�� ù��° ���� ��ȯ
			int t[] = q.poll();
			cury = t[0];
			curx = t[1];
			
			//t�� �̿��� Ž��
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(cnt==4 && ny==y && nx==x) {
					System.out.println("����");
					return;
				}
				
				
				//��輱�̸� next
				if(ny>N-1 || nx>N-1 || ny<0 || nx<0) {
					cnt++;
					continue;
				}
				
				//�ߺ����Ը� next
/*				int z = map[ny][nx];
				if(q.contains(z)) {
					cnt++;
					continue;
				}*/
				
				//�湮 �ʾ�����
				if(visited[ny][nx]==0) {
					int tmp[] = {ny, nx};
					q.add(tmp);
					visited[ny][nx]=1;
					
					for(int p=0; p<N; p++) {
						for(int q=0; q<N; q++) {
							System.out.print(visited[p][q]+" ");
						}
						System.out.println();
					}
					System.out.println();
				}
				
				
			}
			
		}
		
	}

}
