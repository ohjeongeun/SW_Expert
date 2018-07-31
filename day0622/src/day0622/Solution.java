package day0622;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		
		int arr[] = {4,1,3};
		
		System.out.println(solution(arr));
		
	}
	
    public static boolean solution(int[] arr) {
        boolean answer = true;
        int n = arr.length;
        
        Arrays.sort(arr);
        
        for(int i=0; i<n; i++) {
        	if(arr[i]==i+1) {
        		answer=true;
        	}else {
        		answer=false;
        		break;
        	}
        }
        

        return answer;
    }

}
