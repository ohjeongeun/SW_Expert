import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Answer4 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader data = null;
		FileWriter fw = null;
		
		try {
			
			data = new BufferedReader(new FileReader("c:/ecount/data/÷��_02.������ ����.txt"));
			fw = new FileWriter("c:/ecount/�������/ans4.txt");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); //���� ����
			int end = Integer.parseInt(st.nextToken()); //�� ����
			
			//input data ���� �迭
			String table[][] = new String[end-start+1][11];
			
			//�迭 ���� �ʱ�ȭ
			for(int p=0; p<end-start+1; p++) {
				for(int q=0; q<11; q++) {
					table[p][q]="";
				}
			}
			
			int k=1; //���۶���~������ ������ ������ �������� ���� ����
			int index=0;
			while(true) {
				String line = data.readLine();
				if(line==null) break;
				
				//���۶��� ~ ������ �� �����͸� table�� ������ ����
				if(start<=k&&k<=end) {

					String tmp[] = new String[29]; //line ���� �����ؼ� ���� �迭
					
					for(int i=0; i<29; i++) { //k��° line 29���� �ɰ���
						tmp[i] = Character.toString(line.charAt(i));
					}

					for(int i=0; i<=5; i++) {//�ŷ�ó �ڵ�(6)
						table[index][0] += tmp[i];
					}

					for(int i=6; i<=9; i++) {//����̸���(3)
						table[index][1] += tmp[i];
					}
					
					table[index][2] += tmp[10];//����(1)
					
					for(int i=11; i<=13; i++) {//�ܰ�(3)
						table[index][3] += tmp[i];
					}
					
					for(int i=14; i<=16; i++) {//����(3)
						table[index][4] += tmp[i];
					}
					
					table[index][5] += tmp[17];//����(1)
					
					table[index][6] += tmp[18];//����ڵ�(1)
					
					for(int i=19; i<=21; i++) {//�ŷ����(3)
						table[index][7] += tmp[i];
					}
					
					table[index][8] += tmp[22];//�ŷ�ó����(1)
					
					for(int i=23; i<=25; i++) {//��۰Ÿ�(3)
						table[index][9] += tmp[i];
					}
					
					for(int i=26; i<=28; i++) {//�ŷ�����(3)
						table[index][10] += tmp[i];
					}
					
					index++;
				}
				
				k++;
			}
			
			int sum=0;
			//�ŷ�ó������ B�� {�ŷ�ó�ڵ�, �ܰ�*��������Ʈ}
			int temp[][] = new int[end-start+1][2];
			for(int i=0; i<end-start+1; i++) {
				
				
				//�ŷ�ó������ B�ΰ� �� (�ܰ�*��������Ʈ)�� ���
				if(table[i][8].equals("B")) {
					temp[i][0] = Integer.parseInt(table[i][0].trim()); //�ŷ�ó�ڵ�
					
					//���к� �߰� ����Ʈ
					int discount = 0;
					if(table[i][6].equals("A")) {
						discount = 5;
					}else if(table[i][6].equals("B")) {
						discount = 15;
					}else if(table[i][6].equals("C")) {
						discount = 20;
					}
					
					temp[i][1] = Integer.parseInt(table[i][3].trim()) * discount; //�ܰ�*��������Ʈ
					sum += temp[i][1];
				}
			}
			
			
			//�ش�
			String result=Integer.toString(start)+" "+Integer.toString(end)+" "+Integer.toString(sum);
			
			fw.write(result);
			
		}catch (Exception e) {

		}finally {
			
			fw.close();
			data.close();
		}
		
	}

}

