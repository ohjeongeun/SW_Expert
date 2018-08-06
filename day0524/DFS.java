import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

	
	static class Node { //노드 클래스
		int data; //노드 인덱스
		List<Node> neighbors; //인접노드들
		boolean visited;
		
		//클래스 생성자
		Node(int data) {
			this.data=data;
			this.neighbors = new ArrayList<>();
		}
		
		public void addneighbors(Node neighborNode) { //인접노드추가
			this.neighbors.add(neighborNode);
		}
		
		public List<Node> getNeighbors() { //인접노드반환 (반환값 리스트로)
			return neighbors;
		}
		
		public void setNeighbors(List<Node> neighbors) { //인접노드set
			this.neighbors=neighbors;
		}
	}
	

	public void dfs(Node node) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(node); // stack에 v추가
		node.visited=true; // 방문 표시

		while(!stack.isEmpty()) {//stack에 정점 있으면
			Node v = stack.pop(); //
			System.out.print(v.data+" ");
			
			//이웃들 리스트
			List<Node> neighbors = v.getNeighbors();
			for(int i=0; i < neighbors.size(); i++) { //이웃수만큼
				Node w = neighbors.get(i);
				if(w!=null && !w.visited) {
					stack.add(w);
					w.visited=true;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		//노드 지정
		Node A = new Node(0);
		Node B = new Node(1);
		Node C = new Node(2);
		Node D = new Node(3);
		Node E = new Node(4);
		Node F = new Node(5);
		Node G = new Node(6);
 
		//이웃 지정
		A.addneighbors(B);
		A.addneighbors(C);
		B.addneighbors(D);
		B.addneighbors(E);
		D.addneighbors(F);
		E.addneighbors(F);
		F.addneighbors(G);
 
		DFS dfsExample = new DFS();
		dfsExample.dfs(A);
	}
	

}
