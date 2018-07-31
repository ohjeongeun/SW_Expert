package day0618;

import java.util.ArrayList;
import java.util.Stack;

public class DFSalgo {

	static ArrayList<int[]> adj;
	public static void main(String[] args) {
		
		adj = new ArrayList<>();
		
		int a0[] = {};
		int a1[] = {2, 3};
		int a2[] = {1, 4, 5};
		int a3[] = {1, 5};
		int a4[] = {2, 6};
		int a5[] = {2, 3, 6};
		int a6[] = {4, 5, 7};
		int a7[] = {6};
		
		adj.add(0, a0);
		adj.add(1, a1);
		adj.add(2, a2);
		adj.add(3, a3);
		adj.add(4, a4);
		adj.add(5, a5);
		adj.add(6, a6);
		adj.add(7, a7);
		
		dfs(1);
		
	}
	
	public static void dfs(int v) {
		//Stack, visited �ʱ�ȭ
		Stack<Integer> stack = new Stack<>();
		int visited[] = new int[9];
		
		//������ �湮
		System.out.print(v+" ");
		visited[v]=1;
		stack.push(v);
		
		while(!stack.isEmpty()) {
			
			//v�� ������ ����
			for(int j=0; j<adj.get(v).length; j++) {
				
				//v�� ������
				int w = adj.get(v)[j];
				
				//2-1. �湮���� ���� ���� w�� ������
				if(visited[w]==0) {
					
					//w�湮
					System.out.println(w+" ");
					visited[w]=1;
					stack.push(w);
		
					v=w;
					//�̿��� ã�����ϱ� j�ʱ�ȭ (������ ��θ� Ž���ϱ�����)
					j=0;
					
				}
				
			}
			
			//2-2. �湮���� ���� ������ ������
			v = stack.pop();
			//System.out.println(stack);
			
		}

		
	}
	

}
