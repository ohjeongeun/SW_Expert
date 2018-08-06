import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class transMat {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int mat1[][] = new int[3][3];
		
		for(int i=0 ;i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				mat1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0 ;j<3; j++) {
				if(i<j) {
					int tmp=0;
					tmp = mat1[i][j];
					mat1[i][j] = mat1[j][i];
					mat1[j][i] = tmp;
				}
			}
		}
		
		for(int i=0 ;i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(mat1[i][j]+" ");
			}
			System.out.println();
		}

	}

}
