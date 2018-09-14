package day0903;

import java.util.PriorityQueue;

public class ex {
	public static void main(String[] args) {
		PriorityQueue<Nodee> q = new PriorityQueue<>();
		// insert values in the queue
	      for ( int i = 9; i >=0; i-- ) {
	         q.add (new Nodee(0, i, 1)) ; 
	      }
	      System.out.println("Priority queue values are: " + q) ; 
	      
	      while (!q.isEmpty()) {
	          System.out.println(q.poll().x);
	      }
	}
}

class Nodee implements Comparable<Nodee> {
	int y; int x; int cost;
	
	Nodee(int y, int x, int cost) { //생성자
		this.y = y;
		this.x = x;
		this.cost = cost;
	}

	@Override
	public int compareTo(Nodee n) {

		
		//현재 멤버 변수의 값이 파라미터로 넘어온 값 보다 
		if(cost - n.cost<0) return -1; //작으면 음수 리턴(오름차순)
		else if(cost-n.cost>0) return 1; //크면 양수 리턴(내림차순)
		else return 0; //같으면 0리턴
	
		//return cost-n.cost;
		//return n.cost-cost;
	}
	
	
}
