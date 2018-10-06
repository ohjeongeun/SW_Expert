package day1001;

import java.util.Scanner;

public class Solution1 {
     
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            int N = scan.nextInt();
            char[] X = scan.next().toCharArray();
            char[] Y = scan.next().toCharArray();
            int[][] arr = new int[N+1][N+1];
             
            for(int i = 0; i<=N; i++) {
                for(int j = 0; j<=N; j++) {
                    
                	if(i == 0 || j == 0) {
                        arr[i][j] = 0;
                        continue;
                    }
                     
                    if(X[i-1]==Y[j-1]) {
                        arr[i][j] = arr[i-1][j-1] + 1;
                    
                    }else {
                        arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                    }
                }
            }
            
            for(int i = 0; i<=N; i++) {
                for(int j = 0; j<=N; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
             
            System.out.println("#" + tc + " " + String.format("%.2f", (double) (arr[N][N]) / N * 100));
        }
        scan.close();
    }
 
}
