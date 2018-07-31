package day0709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

//그룹 1 예시 경우만
public class SW_1242_1 {
	static String codenum[] = {"0001101", "0011001", "0000011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N=0; //세로 100
			int M=0; //가로 26
			while(st.hasMoreTokens()) {
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
			}
			
			String allzero=br.readLine();
			
			boolean flag=false;
			//code가 있는 col 찾기
			StringBuffer code = new StringBuffer();
			StringBuffer code2 = new StringBuffer(); //중복code 비교 위한 버퍼
			for(int i=1; i<N; i++) {
				String s = br.readLine();
				if(s.equals(code2.toString())) {
					continue;
				}
				if(!s.equals(allzero)) {
					code.append(s);
					code2.append(s);
					code.reverse();
					
					//뒤에 0제거
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
						
						//start기준으로 뒤에 6개 문자(총 문자 7개 다 차면) 코드인지 비교
						for(int k=0; k<10; k++) {
							if(cnt==8) {
								flag=false;
								break;
							}
							if(start.equals(codenum[k])) {//7개문자열이 코드면
								//System.out.println(start+" "+k);
								ans.add(k);
								cnt++; //cnt=7일때까지 찾음
								
								p+=6;//코드 비교해줬으니 뒤의 start기준 6만큼 ++시켜줌
								break; //찾았으니까 break
							}
						}
					}
				}
				
			}
			
			
			
			
			
			System.out.println("#"+t+" ");
		}
	}

}
