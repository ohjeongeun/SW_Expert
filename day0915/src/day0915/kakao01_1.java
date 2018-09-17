package day0915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class kakao01_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), ",");
		String record[] = new String[token.countTokens()];
		
		int j=0;
		while(token.hasMoreTokens()) {
			record[j] = token.nextToken();
			j++;
		}
		
		
		String answer[] = solution(record);
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]);
		}
		
	}
	
	public static String[] solution(String[] record) {
		String[] answer = {};
		LinkedList<String> ans = new LinkedList<>();
		HashMap<String, String> user =  new HashMap<>();
		
		String uid;
		String uname;
		for(int i=0; i<record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			st.nextToken();
			uid = st.nextToken();
			if(st.hasMoreTokens()) {
				uname = st.nextToken();
				user.put(uid , uname);
			}
			
		}
		
		String command;
		String id;
		String name;
		for(int i=0; i<record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			command = st.nextToken();
			id = st.nextToken();
			
			if(command.equals("Enter")) {
				name = user.get(id);
				ans.add(name+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
				
			}else if(command.equals("Leave")) {
				name = user.get(id);
				ans.add(name+"´ÔÀÌ ³ª°¬½À´Ï´Ù.");
				
			}
		}

		return ans.toArray(answer);
	}
}
