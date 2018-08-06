import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_1213B {

	static int T;
	static String pattern;
	static String string;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<10; t++) {
			T = Integer.parseInt(br.readLine());
			pattern = br.readLine();
			string = br.readLine();
			String p[] = new String[pattern.length()];
			String s[] = new String[string.length()];
			
			for(int i=0; i<p.length; i++) {
				p[i] = Character.toString(pattern.charAt(i));
			}
			for(int i=0; i<s.length; i++) {
				s[i] = Character.toString(string.charAt(i));
			}
			
			cnt=0;
			boolean flag;
			for(int i=0; i<s.length-p.length+1; i++) {
				flag=false;
				if(s[i].equals(p[0])) { //패턴의 첫글자 찾으면
					flag=true;
					for(int j=1; j<p.length; j++) { //2글자부터 찾기 시작함
						i++;
				
						if(s[i].equals(p[j])) {
							flag=true;		
						}else {
							i--;
							flag=false;
							break;
						}				
					}
					if(flag==true) {
						cnt++;
					}				
				}
			}			
			System.out.println("#"+T+" "+cnt);
		}
	}
}
