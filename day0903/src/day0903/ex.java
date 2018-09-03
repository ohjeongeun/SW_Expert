package day0903;

import java.util.PriorityQueue;

public class ex {
	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		// insert values in the queue
	      for ( int i = 9; i >=0; i-- ) {
	         q.add (i) ; 
	      }
	      System.out.println("Priority queue values are: " + q) ; 
	      
	      while (!q.isEmpty()) {
	            System.out.println(q.poll());
	      }
	}
}


