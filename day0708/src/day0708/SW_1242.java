package day0708;

import java.math.BigInteger;
import java.util.ArrayList;

public class SW_1242 {

	public static void main(String[] args) {
		
		String hex = "328D1AF6E4C9BB";
		System.out.println(hex.length());
		
		//큰 사이즈 실수 형변환 BigInteger
		
		//hex->dec
		BigInteger dec = new BigInteger(hex, 16);
		System.out.println(dec);
	
		//dec->bi
		String bi = dec.toString(2);
		System.out.println(bi);
		
		
		
		System.out.println(bi.length());
		
	
/*		long dec = Long.parseLong(hex, 16);
		String bi = Long.toBinaryString(dec); 
		System.out.println(bi);
		
		int startindex = 64-bi.length();
		System.out.println(startindex);
		
		ArrayList<Integer> code = new ArrayList<>()*/;

		
		
/*		
		long a = 14228895786387900L;
		System.out.println(Long.toBinaryString(a));
		int r = Long.numberOfLeadingZeros(a);
		System.out.println(64-r);
*/		
	}

}
