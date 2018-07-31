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
				n = Integer.parseInt(st.nextToken()); //세로
				m = Integer.parseInt(st.nextToken()); //가로
			}
			boolean flag=true;
			cnt=0;
			ans = new ArrayList<>();
			for(int i=0; i<n; i++) { //세로줄 만큼
				String s = br.readLine();
				
				for(int j=0; j<m-7; j++) {//m-7 까지 문자열 하나씩 잘라셔 start(기준) 생성
					String start = Character.toString(s.charAt(j));
					
					for(int k=1; k<7; k++) {//start이후로 6개문자++
						String add = Character.toString(s.charAt(j+k));
						start+=add;
					}
					//System.out.println(start);
					
					boolean find=false;
					
					//start기준으로 뒤에 6개 문자(총 문자 7개 다 차면) 코드인지 비교
					for(int k=0; k<10; k++) {
						if(cnt==8) {
							flag=false;
							break;
						}
						if(start.equals(code[k])) {//7개문자열이 코드면
							//System.out.println(start+" "+k);
							find=true;
							ans.add(k);
							cnt++; //cnt=7일때까지 찾음
							
							j+=6;//코드 비교해줬으니 뒤의 start기준 6만큼 ++시켜줌
							break; //찾았으니까 break
						}
					}
					
					//case7 때문에 추가함
					//첫스타트 끊었는데 그다음 문자열이 코드가 아닐경우
					if(cnt==1 && find==false) {
						//System.out.println("*");
						j-=6; //스타트 전으로 돌려줌
						cnt=0; //코든줄알고 저장했던 변수, 리스트 초기화
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
