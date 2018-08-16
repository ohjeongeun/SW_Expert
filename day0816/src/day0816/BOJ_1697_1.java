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
	     q.offer(new Node(N, depth));		// 1. ť�� ��Ʈ ��� ���� 
	       
	        		
	     while(true) {
	      	Node n = q.poll();			// 2. ť���� ���� 
	        if(n.x == K) {       // ������ġ�� ��� 
	           System.out.println(n.depth);
	           return;
	        }
	        int x[] = {n.x+1, n.x-1, n.x*2};
	        for(int i=0; i<3; i++) {		// 2. �̵��� �� �ִ� ��� ã��, 3 ����    
	                int n_x = x[i];
	    
	                // ���� Ȯ��, �湮�ߴ��� Ȯ�� 
	                if(n_x >= 0 && n_x <= 100000 && visited[n_x] == false )
	                {
	                    q.offer(new Node(n_x, n.depth+1));	// 3. ť�� ���� 
	                    visited[n_x] = true;		// 3. �湮�� 
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
