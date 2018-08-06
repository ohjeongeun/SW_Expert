package day0709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

//�׷� 1 ���� ��츸
public class SW_1242_1 {
	static String codenum[] = {"0001101", "0011001", "0000011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N=0; //���� 100
			int M=0; //���� 26
			while(st.hasMoreTokens()) {
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
			}
			
			String allzero=br.readLine();
			
			boolean flag=false;
			//code�� �ִ� col ã��
			StringBuffer code = new StringBuffer();
			StringBuffer code2 = new StringBuffer(); //�ߺ�code �� ���� ����
			for(int i=1; i<N; i++) {
				String s = br.readLine();
				if(s.equals(code2.toString())) {
					continue;
				}
				if(!s.equals(allzero)) {
					code.append(s);
					code2.append(s);
					code.reverse();
					
					//�ڿ� 0����
					int index=0;
					while(true) {
						if(code.charAt(index)-'0'==0) {
							code.deleteCharAt(index);
						}else {
							break;
						}
						
					}
					code.reverse();
					
					//hex->dec
					BigInteger dec = new BigInteger(code.toString(), 16);
					
					//dec->bi
					String bi = dec.toString(2);
					int n = 64-bi.length();
					while(true) {
						if(n<0) {
							break;
						}
						bi = "0"+bi;
						n--;
					}
					System.out.println(bi);
					
					int cnt=0;
					ArrayList<Integer> ans = new ArrayList<>();
					for(int p=0; p<bi.length()-7; p++) {
						String start = Character.toString(bi.charAt(p));
						for(int q=1; q<7; q++) {
							start += Character.toString(bi.charAt(q));
						}
						System.out.println(start);
						
						//start�������� �ڿ� 6�� ����(�� ���� 7�� �� ����) �ڵ����� ��
						for(int k=0; k<10; k++) {
							if(cnt==8) {
								flag=false;
								break;
							}
							if(start.equals(codenum[k])) {//7�����ڿ��� �ڵ��
								//System.out.println(start+" "+k);
								ans.add(k);
								cnt++; //cnt=7�϶����� ã��
								
								p+=6;//�ڵ� ���������� ���� start���� 6��ŭ ++������
								break; //ã�����ϱ� break
							}
						}
					}
				}
				
			}
			
			
			
			
			
			System.out.println("#"+t+" ");
		}
	}

}