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
	
	Nodee(int y, int x, int cost) { //������
		this.y = y;
		this.x = x;
		this.cost = cost;
	}

	@Override
	public int compareTo(Nodee n) {

		
		//���� ��� ������ ���� �Ķ���ͷ� �Ѿ�� �� ���� 
		if(cost - n.cost<0) return -1; //������ ���� ����(��������)
		else if(cost-n.cost>0) return 1; //ũ�� ��� ����(��������)
		else return 0; //������ 0����
	
		//return cost-n.cost;
		//return n.cost-cost;
	}
	
	
}
