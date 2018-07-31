package day0622;

public class Solution1 {

	static String str[];
	
	public static void main(String[] args) {
		String s = "abacde";
		
		System.out.println(solution(s));
		
	}
	
    public static int solution(String s)
    {
        int max=0;
        for(int i=0; i<s.length(); i++) { //À§Ä¡

            StringBuffer sb = new StringBuffer();

            for(int j=i; j<s.length(); j++) {
                sb.append(Character.toString(s.charAt(j)));
                String str = sb.toString();
                String reverse = sb.reverse().toString();
                sb.reverse();

                if(str.equals(reverse)) {
                    if(max<str.length()) {
                        max = str.length();
                    }
                }

            }

        }

        return max;

    
    }

}
