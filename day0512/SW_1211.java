import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1211 {

	static int T;
	static int N=100;
	static int map[][];
	static int visited[][];
					// 좌, 우, 하
	static int dx[] = {-1, 1, 0};
	static int dy[] = {0, 0, 1};
	static int cnt;
	static boolean flag;
	static int min;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<10; t++) {
			T = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			

			min=100000;
			result=0;
			System.out.print("#"+T+" ");
			
			for(int j=0; j<N; j++) {
				flag=false;
				solve(0, j);
				if(flag==true) {
					if(min>cnt) {
						min=cnt;
						result=j;
					}			
				}	
			}
			System.out.println(result);
			
			}
		}
	
	
	public static void solve(int cury, int curx) {
		visited = new int[N][N];
		cnt=0;
		if(map[cury][curx]==0) {
			flag=false;
			return ;
		}

		for(int y=cury; y<N; y++) {
			for(int x=curx; x<N; x++) {
				if(visited[y][x]!=1 && map[y][x]==1) { //갔던길 아니고 길(1)이면
					cury = y;
					curx = x;
					//System.out.println(cury+" "+curx);
					visited[cury][curx]=1; //방문
					cnt++;
				}
				
				for(int m=0; m<3; m++) {
					if(cury+dy[m]<0 || cury+dy[m]>N-1 || curx+dx[m]<0 || curx+dx[m]>N-1) { //경계선넘어가는지 판단
						continue;
					}
					if(visited[cury+dy[m]][curx+dx[m]]==1 || map[cury+dy[m]][curx+dx[m]]==0) { //갔던길인지 , 길(1)인지 판단
						continue;
					}
					if(map[cury+dy[m]][curx+dx[m]]==1) {
						cury += dy[m];
						curx += dx[m];
						//System.out.println(cury+"  "+curx);
						visited[cury][curx]=1; //방문
						cnt++;
						y=cury;
						x=curx-1;
						break;
					}	
				}
				
				if(cury==N-1 && map[cury][curx]==1) {
					flag=true;
					return ;
				}		
			}
		}	
	}
}
