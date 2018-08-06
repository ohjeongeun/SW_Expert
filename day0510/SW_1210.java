package zDay0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1210 {
	static int T;
	static int map[][];
	static int N=100;
	static int visited[][];
					 // 좌  우   하 
	static int dx[] = {-1, 1, 0};//j
	static int dy[] = {0, 0, 1};//i
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t=0; t<10; t++) {
			T = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			flag=false;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.print("#"+T+" ");
			for(int p=0; p<N; p++) {
				visited = new int[N][N];
				flag=false;
				
				solve(0, p);
				
				if(flag==true) {
					System.out.println(p);
					break;
				}
				
			}
					
		}

	}

	static int curx; static int cury;
	public static void solve(int cury, int curx) {
		if(map[cury][curx]==0) { //출발지가 0이면 종료
			flag=false;
			return ;
		}
		
		for(int y=cury; y<N; y++) {
			for(int x=curx; x<N; x++) {
				if(map[y][x]==1 && visited[y][x]!=1) {//길이고 방문x면
					visited[cury][curx]=1; //방문
		
					}
				
				for(int d=0; d<3; d++) { //다음 방문 탐색
					//  하                                   우                                      좌                                   상
					if(cury+dy[d]<0 || cury+dy[d]>N-1 || curx+dx[d]<0 || curx+dx[d]>N-1) {//각 방향에서 경계선에 걸리면 다음방향으로 continue
						continue;
					}
					if(map[cury+dy[d]][curx+dx[d]]==0 || visited[cury+dy[d]][curx+dx[d]]==1) { //다음방향이 길이 아니거나 방문했었으면 continue
						continue;
					}
					if(map[cury+dy[d]][curx+dx[d]]==1 || map[cury+dy[d]][curx+dx[d]]==2) { //다음 방향이 길이면 or 목적지면
						cury += dy[d];
						curx += dx[d];	
						visited[cury][curx]=1;
						y=cury; 
						x=curx-1; //x=9일 경우 왼쪽길이 있어도 못찾고 y++로 넘어가버림
						break;
						}
					}
				
				if(cury==N-1 && map[cury][curx]!=2) { //실패
					flag=false;
					return ;
				}
				if(cury==N-1 && map[cury][curx]==2) { //성공
					flag=true;
					return ;
				}
			}
		}	
	}
}
