package day0620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//����Ʈ ī��
public class SW_2105 {
	static int T;
	static int N;
	static int map[][];
	static int visited[][];
	static Stack<int[]> stack;
                     //����  ����  �»�  ���
	static int dx[] = { 1, -1, -1, 1};
	static int dy[] = { 1, 1, -1, -1};
	
	static int dessert[];
	
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int j=0;
				while(st.hasMoreTokens()) {
					map[i][j] = Integer.parseInt(st.nextToken());
					j++;
				}
			}
			
			dessert = new int[101];
			
			cnt=1;
			solve(0, 1);
			
			System.out.println("#"+t+" ");
			
			for(int i=1; i<101; i++) {
				System.out.print(dessert[i]);
			}
			for(int k=0; k<N; k++) {
				for(int j=0; j<N; j++) {
					System.out.print(visited[k][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
	}
	
	public static void solve(int cury, int curx) {
		stack = new Stack<>();
		visited = new int[N][N];
		
		//������ ����
		int starty = cury;
		int startx = curx;
		
		//������ �湮
		int tmp[] = {cury, curx};
		stack.push(tmp);
		visited[cury][curx]=1;
		dessert[map[cury][curx]]=1;
		
		//�̿��� ã�Ƴ���
		while(!stack.isEmpty()) {
			
			//������ġ(����) ���ϱ�
			for(int i=0; i<4; i++) {
				int ny = cury+dy[i];
				int nx = curx+dx[i];
				
				if(ny==starty && nx==startx) {
					System.out.println("����");
					return;
				}
				
				//��輱�̸� next
				if(ny > N-1 || nx > N-1 || nx < 0 || ny < 0) {
					cnt++;
					continue;
				}
				
				
				//�������Ը� next				
/*				boolean flag = true;
				for(int index=0; index<stack.size(); index++) {
					int tmp4[] = stack.get(index);
					
					if(map[ny][nx]==map[tmp4[0]][tmp4[1]]) {
						flag = false;
						break;
					}
				}
				
				if(flag==false) {
					cnt++;
					//i=0;
					continue;
				}*/
				
				//�ߺ����Ը�
				if(dessert[map[ny][nx]]==1) {
					cnt++;
					continue;
				}
				
				
				//�湮�ʾҸ� push
				if(visited[ny][nx]==0) {
					
					int tmp2[] = {ny, nx};
					stack.push(tmp2);
					visited[ny][nx]=1;
					dessert[map[ny][nx]]=1;
					
					for(int k=0; k<N; k++) {
						for(int j=0; j<N; j++) {
							System.out.print(visited[k][j]+" ");
						}
						System.out.println();
					}
					System.out.println();
					
					cury = ny;
					curx = nx;
					
					//������⿡�� �̾���� ������ i--;
					i--;
					//System.out.println(i);
					
				}
				
			}
			
			int tmp3[] = stack.pop();
			cury = tmp3[0];
			curx = tmp3[1];
			System.out.println(cury+" "+curx);
		}
		
	}

}
