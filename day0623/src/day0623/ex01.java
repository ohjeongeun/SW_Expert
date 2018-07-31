package day0623;

import java.util.Arrays;

import javax.xml.transform.Result;

public class ex01 {

	public static void main(String[] args) {
		int[] grade = {3, 2, 1, 2};

		solution(grade);
		
	}
	
	public static int[] solution(int[] grade) {
		int[] answer = new int[grade.length];
		int len = grade.length;
		
		for (int i=0; i<len; i++) {
			int rank = 1;
			
			for (int j=0; j<len; j++) {
				if (i==j)
					continue;

				if (grade[i]<grade[j])
					rank += 1;
			}
			
			answer[i] = rank;
		}

		return answer;
    }

}
