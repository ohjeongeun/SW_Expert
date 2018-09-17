package day0915;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class kakao02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
	    int stages[] = {2, 1, 2, 6, 2, 4, 3, 3};
	    
	    int ans[] = solution(N, stages);
	    
	    for(int i=0; i<ans.length; i++) {
	    	System.out.print(ans[i]);
	    	
		}
	}
	
	public static int[] solution(int N, int[] stages) {
		
		
		//1, 2, 3, 4, .. N+1
		int game[] = new int[N+2];
		
		for(int i=1; i<stages.length; i++) {
			game[stages[i]]++;
			
		}

		for(int i=1; i<game.length; i++) {
			System.out.print(game[i]);
			
		}
		System.out.println();
		HashMap<Integer, Double> hm = new HashMap<>();
		Double failRate = 0.0;
		for(int i=1; i<game.length; i++) {
			double bj = game[i];
			double bm = 0;
			for(int j=i; j<game.length; j++) {
				bm += game[j];
			}

			failRate = bj/bm;
			if(i<=N) {
				hm.put(i, failRate);
			}
			
		}
		
		List<Map.Entry<Integer, Double>> list = new ArrayList<>(hm.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
			public int compare(Map.Entry<Integer, Double> e1, Map.Entry<Integer, Double> e2) {
				if(e1.getValue() == e2.getValue())
					return e1.getKey().compareTo(e2.getKey());
				else
					return e2.getValue().compareTo(e1.getValue());
			}
		});
		
		int[] answer = new int[list.size()];
		
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i).toString().charAt(0)-'0';
		
		}
        return answer;
    }
	

}
