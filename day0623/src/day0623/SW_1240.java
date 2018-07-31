package day0623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_1240 {
	static int T;
	                		
	static String code[] = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
	static ArrayList<Integer> ans;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n=0;
			int m=0;
			while(st.hasMoreTokens()) {
				n = Integer.parseInt(st.nextToken()); //����
				m = Integer.parseInt(st.nextToken()); //����
			}
			boolean flag=true;
			cnt=0;
			ans = new ArrayList<>();
			for(int i=0; i<n; i++) { //������ ��ŭ
				String s = br.readLine();
				
				for(int j=0; j<m-7; j++) {//m-7 ���� ���ڿ� �ϳ��� �߶�� start(����) ����
					String start = Character.toString(s.charAt(j));
					
					for(int k=1; k<7; k++) {//start���ķ� 6������++
						String add = Character.toString(s.charAt(j+k));
						start+=add;
					}
					//System.out.println(start);
					
					boolean find=false;
					
					//start�������� �ڿ� 6�� ����(�� ���� 7�� �� ����) �ڵ����� ��
					for(int k=0; k<10; k++) {
						if(cnt==8) {
							flag=false;
							break;
						}
						if(start.equals(code[k])) {//7�����ڿ��� �ڵ��
							//System.out.println(start+" "+k);
							find=true;
							ans.add(k);
							cnt++; //cnt=7�϶����� ã��
							
							j+=6;//�ڵ� ���������� ���� start���� 6��ŭ ++������
							break; //ã�����ϱ� break
						}
					}
					
					//case7 ������ �߰���
					//ù��ŸƮ �����µ� �״��� ���ڿ��� �ڵ尡 �ƴҰ��
					if(cnt==1 && find==false) {
						//System.out.println("*");
						j-=6; //��ŸƮ ������ ������
						cnt=0; //�ڵ��پ˰� �����ߴ� ����, ����Ʈ �ʱ�ȭ
						ans.clear();
					}

					if(flag==false) {
						break;
					}
					
				}
				
				
			}
			//System.out.println(ans);
			int sum=0;
			for(int i=0; i<8; i++) {
				if(i%2==0) {
					sum += ans.get(i)*3;
				}else {
					sum += ans.get(i);
				}
				
			}

			int r = sum%10;
			
			int result=0;
			for(int i=0; i<ans.size(); i++) {
				result+=ans.get(i);
			}
			System.out.print("#"+t+" ");
			//System.out.println(sum);
			if(r == 0) {
				System.out.println(result);
			}else {
				System.out.println(0);
			}
		}

	}

}
