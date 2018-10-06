package day1001;

import java.util.Scanner;

public class Solution {
 
    static int N;
    static int[][] adj;
    static int[][] dist;
 
    public static void main(String[] args) {
 
        Scanner scn = new Scanner(System.in);
 
        int T = scn.nextInt();
        scn.nextLine();
        for (int testCase = 1; testCase <= T; testCase++) {
            N = scn.nextInt();
            adj = new int[N][N];
            dist = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    
                	adj[i][j] = scn.nextInt();
                    
                	//바로 인접한 점
                	if(adj[i][j] == 1){
                        dist[i][j] = adj[i][j];
                    
                    //인접하지 않은 점
                	}else{//가장 큰수 입력
                        dist[i][j] = Short.MAX_VALUE - 1;
                    }
                }
            
            }
 
            // Floyd
            for(int k=0; k<N; k++){
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(dist[i][j] > dist[i][k] + dist[k][j]){
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
 
            int min = Integer.MAX_VALUE - 1;
            for(int i=0; i<N; i++){
                int sum = 0;
                for(int j=0; j<N; j++){
                    if(i != j){
                        sum += dist[i][j];
                    }
                }
                if(sum < min)
                    min = sum;
            }
 
            System.out.println(String.format("#%d %d", testCase, min));
 
 
        }
 
    }
 
}