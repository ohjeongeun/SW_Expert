package day0816;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BOJ_1697_1 {

    static int N;                   
    static int K;                    
    
    static boolean visited[] = new boolean[100001]; 	   
    
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    
	    N = sc.nextInt();
	    K = sc.nextInt();
	    
	    bfs();
 }
	    
	public static void bfs() {
	     Queue<Node> q = new LinkedList<>();
	        
	     int depth = 0;
	     q.offer(new Node(N, depth));		// 1. 큐에 루트 노드 저장 
	       
	        		
	     while(true) {
	      	Node n = q.poll();			// 2. 큐에서 꺼냄 
	        if(n.x == K) {       // 도착위치일 경우 
	           System.out.println(n.depth);
	           return;
	        }
	        int x[] = {n.x+1, n.x-1, n.x*2};
	        for(int i=0; i<3; i++) {		// 2. 이동할 수 있는 노드 찾기, 3 조건    
	                int n_x = x[i];
	    
	                // 범위 확인, 방문했는지 확인 
	                if(n_x >= 0 && n_x <= 100000 && visited[n_x] == false )
	                {
	                    q.offer(new Node(n_x, n.depth+1));	// 3. 큐에 넣음 
	                    visited[n_x] = true;		// 3. 방문함 
	                }
	            }
	        }
	}
}

	class Node {
	    int x, depth;
	 
	    Node(int x, int depth)
	    {
	        this.x = x;
	        this.depth = depth;
	    }
	}
