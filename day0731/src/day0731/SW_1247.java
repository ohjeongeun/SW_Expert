package day0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1247 {
	static int T;
	static int N;
	static int com[][];
	static int home[][];
	static int clients[][];
	static int cnt;
	static int sum;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			com = new int[1][2];
			home = new int[1][2];
			clients = new int[N][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			//회사
			for(int i=0; i<2; i++) {
				com[0][i] = Integer.parseInt(st.nextToken());
			}
			
			//집
			for(int i=0; i<2; i++) {
				home[0][i] = Integer.parseInt(st.nextToken());
			}
			
			//고객들
			for(int i=0; i<N; i++) {
				for(int j=0; j<2; j++) {
					clients[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min= Integer.MAX_VALUE;

			perm(clients, 0);
			System.out.println("#"+t+" "+min);

		}
		
	}
	
	public static void perm(int clients[][], int pivot) {
		if(pivot == N) {
			sum=0;
			//배열차 구하기
			for(int i=0; i<N-1; i++) {
				//절댓값 처리
				sum += Math.abs(clients[i][0]-clients[i+1][0]);
				sum += Math.abs(clients[i][1]-clients[i+1][1]);
			}
			sum += Math.abs(com[0][0] - clients[0][0]);
			sum += Math.abs(com[0][1] - clients[0][1]);
			
			sum += Math.abs(home[0][0] - clients[N-1][0]);
			sum += Math.abs(home[0][1] - clients[N-1][1]);
			
			//min값 갱신
			if(min>sum) {
				min=sum;
			}
			return;
		}
		
		for(int p=pivot; p<N; p++) {
			swap(clients, p, pivot);
			perm(clients, pivot+1);
			swap(clients, p, pivot);
		}
		
	}
	
	public static void swap(int clients[][], int i, int j) {
		int tmp0 = clients[i][0];
		clients[i][0] = clients[j][0];
		clients[j][0] = tmp0;
		
		int tmp1 = clients[i][1];
		clients[i][1] = clients[j][1];
		clients[j][1] = tmp1;
	}

}
