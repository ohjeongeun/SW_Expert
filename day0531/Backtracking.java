import java.util.Stack;

public class Backtracking {
	
	static boolean flag;
	// 2 : 입구, 0 : 길, 1 : 벽, 3 : 출구
	
/*	static int map[][] = {
				{1,1,1,1},
				{0,0,0,0},
				{1,0,1,0},
				{1,3,1,0}
				};*/
					// 우   하     좌    상
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static Stack<Integer> xpoint = new Stack<Integer>();
	static Stack<Integer> ypoint = new Stack<Integer>();
	
	public static void main(String[] args) {
		int map[][] = {
				{1,1,1,1},
				{0,0,0,0},
				{1,0,1,0},
				{1,3,1,0}
				};
		flag=true;
		backtracking(1, 0);
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
	public static void backtracking(int y, int x) {
		int map[][] = {
				{1,1,1,1},
				{0,0,0,0},
				{1,0,1,0},
				{1,3,1,0}
				};
		int cury; int curx;
		cury = y;
		curx = x;
		
		int i=0;
		while(true) {
			//for(int i=0; i<4; i++) {
				if(i>3) {
					i=0;
				}
				/*if(map[cury][curx]==3) {
					System.out.println("최종"+cury+" "+curx);
					return;
				}*/
				
				

				if(cury+dy[i]>3 || cury+dy[i]<0 ||curx+dx[i]>3 || curx+dx[i]<0 ) {
					while(true) {
						
						curx = xpoint.pop();
						cury = ypoint.pop();
						flag=false;
						System.out.println("2 "+curx+"   "+cury+" /"+map[cury][curx]);
						if(xpoint.isEmpty() && ypoint.isEmpty()) {
							break;
						}
					}
					i++;
					
				}
				
				else if(map[cury+dy[i]][curx+dx[i]]==1) {
					while(true) {
						
						curx = xpoint.pop();
						cury = ypoint.pop();
						flag=false;
						System.out.println("3 "+curx+"   "+cury+" /"+map[cury][curx]);
						if(xpoint.isEmpty() && ypoint.isEmpty()) {
							break;
						}
					}
					i++;
					
				}
				else if(map[cury+dy[i]][curx+dx[i]]==0) {
					/*if(map[cury+dy[i]][curx+dx[i]]==3) {
						System.out.println("최종 "+cury+" "+curx);
						return;
					}*/
					curx += dx[i];
					cury += dy[i];
					System.out.println("1 "+curx+"   "+cury+" /"+map[cury][curx]);
					xpoint.push(curx);
					ypoint.push(cury);
					
					/*if(map[cury][curx]==3) {
						System.out.println("최종 "+cury+" "+curx);
						return;
					}*/
					
									
				}
				
				
			//}	
		}
		
		
		
	}

}
