import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Answer1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader data = null;
		FileWriter fw = null;
		
		try {
			
			data = new BufferedReader(new FileReader("c:/ecount/data/첨부_02.데이터 파일.txt"));
			fw = new FileWriter("c:/ecount/결과파일/ans1.txt");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); //시작 라인
			int end = Integer.parseInt(st.nextToken()); //끝 라인
			
			//input data 저장 배열
			String table[][] = new String[end-start+1][11];
			
			//배열 공백 초기화
			for(int p=0; p<end-start+1; p++) {
				for(int q=0; q<11; q++) {
					table[p][q]="";
				}
			}
			
			int k=1; //시작라인~끝라인 사이의 데이터 가져오기 위한 변수
			int index=0;
			while(true) {
				String line = data.readLine();
				if(line==null) break;
				
				//시작라인 ~ 끝라인 의 데이터면 table에 데이터 저장
				if(start<=k&&k<=end) {

					String tmp[] = new String[29]; //line 공백 포함해서 받을 배열
					
					for(int i=0; i<29; i++) { //k번째 line 29개로 쪼개줌
						tmp[i] = Character.toString(line.charAt(i));
					}

					for(int i=0; i<=5; i++) {//거래처 코드(6)
						table[index][0] += tmp[i];
					}

					for(int i=6; i<=9; i++) {//담당이메일(3)
						table[index][1] += tmp[i];
					}
					
					table[index][2] += tmp[10];//직위(1)
					
					for(int i=11; i<=13; i++) {//단가(3)
						table[index][3] += tmp[i];
					}
					
					for(int i=14; i<=16; i++) {//수량(3)
						table[index][4] += tmp[i];
					}
					
					table[index][5] += tmp[17];//구분(1)
					
					table[index][6] += tmp[18];//배송코드(1)
					
					for(int i=19; i<=21; i++) {//거래등급(3)
						table[index][7] += tmp[i];
					}
					
					table[index][8] += tmp[22];//거래처레벨(1)
					
					for(int i=23; i<=25; i++) {//배송거리(3)
						table[index][9] += tmp[i];
					}
					
					for(int i=26; i<=28; i++) {//거래점수(3)
						table[index][10] += tmp[i];
					}
					
					index++;
				}
				
				k++;
			}
			
			//단가가 50이상인 {거래처코드, 거래등급+거래점수}
			int temp[][] = new int[end-start+1][2];
			for(int i=0; i<end-start+1; i++) {
				
				//단가 50 이상이면
				if(Integer.parseInt(table[i][3].trim())>=50) { //공백제거하여 형변환
					temp[i][0] = Integer.parseInt(table[i][0].trim()); //거래처코드
					temp[i][1] = Integer.parseInt(table[i][7].trim()) + Integer.parseInt(table[i][10].trim());//합
				}
			}
			
			
			Arrays.sort(temp, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) { //{거래등급+거래점수}이 기준
					return o2[1]-o1[1]; 
				}
			
			});
			
			//해답
			String result=Integer.toString(start)+" "+Integer.toString(end)+" ";
			for(int i=0; i<end-start+1; i++) {
				if(i==4) {
					result += Integer.toString(temp[4][1]);
					break;
				}
			}
			
			fw.write(result);
			
		}catch (Exception e) {

		}finally {
			
			fw.close();
			data.close();
		}
		
		
		
		
	}

}

