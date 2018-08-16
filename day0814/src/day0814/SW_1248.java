package day0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_1248 {
	static int T;
	static int V; //정점의 총 수
	static int E; //간선의 총 수
	
	//공통 조상을 갖는 두개의 자식 번호
	static int C1;
	static int C2;
	
	static int tree[][];
	
	static int result;
	
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				V = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				C1 = Integer.parseInt(st.nextToken());
				C2 = Integer.parseInt(st.nextToken());
			}
			
			tree = new int[V+1][2];
			
			//tree데이터 삽입
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if(tree[p][0]==0) {
					tree[p][0] = c;
				}else {
					tree[p][1] = c;	
				}
				
			}

			
			LinkedList<Integer> c1Parents = new LinkedList<>();
			LinkedList<Integer> c2Parents = new LinkedList<>();
			
			//첫 부모 찾기
			int parent=findParent(C1);
			c1Parents.add(parent);
			
			//첫 부모가 자식이 되어 재귀
			while(true) {
				if(parent==1) {
					break;
				}
				
				parent = findParent(parent);
				c1Parents.add(parent);				
				
			}
			
			//첫 부모 찾기
			parent=findParent(C2);
			c2Parents.add(parent);
			
			//첫 부모가 자식이 되어 재귀
			while(true) {
				if(parent==1) {
					break;
				}
				
				parent = findParent(parent);
				c2Parents.add(parent);
				
			}
			
			//c1Parents 리스트와 c2Parents 리스트 원소들 비교하며
			//같은 조상 조사
			result=0;
			boolean flag = false;
			for(int i=0; i<c1Parents.size(); i++) {
				int pivot = c1Parents.get(i);

				for(int j=0; j<c2Parents.size(); j++) {
					if( pivot == c2Parents.get(j)) {
						result= pivot;
						flag = true;
						break;
					}
				}
				if(flag==true) {
					break;
				}
			}
			
			
			cnt=1;
						
			
			
			System.out.println("#"+t+" "+result+" "+countChild(result));
			System.out.println(c1Parents);
			System.out.println(c2Parents);
		}
		
		
	}
	
	public static int findParent(int child) {
		int parent = 0;
		
		for(int i=0; i<V+1; i++) {
			for(int j=0; j<2; j++) {
				if(tree[i][j]==child) {
					parent = i;
					break;
				}
				
			}
		}
		
		return parent;
		
	}
	
	public static int countChild(int parent) {
		
		for(int j=0; j<2; j++) {
			if(tree[parent][j]!=0) {
				cnt++;
				countChild(tree[parent][j]);
			}
		}
		
		return cnt;
	}
	

}
