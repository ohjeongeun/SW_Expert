package day0903;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ex1 {
	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
	    
		for ( int i = 9; i >=0; i-- ) {
	         q.add(i) ; 
	      }
	      System.out.println("Priority queue values are: " + q) ; 
	      
	      while (!q.isEmpty()) {
	          System.out.println(q.poll());
	      }
	}
}

	
	
