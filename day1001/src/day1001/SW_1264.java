package day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SW_1264 {
	static int T;
	static int size;
	static String x[];
	static String y[];

	static int vx[];
	static int vy[];
	
	static LinkedList<String> subX;
	static LinkedList<String> subY;
	static ArrayList<String> listX;
	static ArrayList<String> listY;
	static ArrayList<String> result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			size = Integer.parseInt(br.readLine());
			x = new String[size];
			y = new String[size];
			
			vx = new int[size];
			vy = new int[size];
			String strx = br.readLine();
			String stry = br.readLine();
			for(int i=0; i<size; i++) {
				x[i] = Character.toString(strx.charAt(i));
				y[i] = Character.toString(stry.charAt(i));
			}
			
			listX = new ArrayList<>();
			listY = new ArrayList<>();
			for(int i=0; i<size; i++) {
				subX = new LinkedList<>();
				Arrays.fill(vx, 0);
				dfsX(i);

				subY = new LinkedList<>();
				Arrays.fill(vy, 0);
				dfsY(i);
				
				
			}
			/*subX = new LinkedList<>();
			subY = new LinkedList<>();
			dfsX(0);
			dfsY(0);*/
			
			System.out.println(listX);
			System.out.println(listY);
			
			result = new ArrayList<>(listX);
			result.retainAll(listY);
			
			Collections.sort(result, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					int result=0;
					
					if(o1.length()>o2.length()) {
						result=-1;
					}else {
						result=1;
					}
					
					return result;
				}
				
			});
			
			System.out.println(result);
			System.out.println("#"+t+" ");
		}
	}
	
	public static void dfsX(int v) {
		vx[v]=1;
		subX.addLast(x[v]);
		
		String tmp = subX.toString().replaceAll(", ", "").replace("[", "").replace("]", "");
		if(!listX.contains(tmp)) {
			listX.add(tmp);
		}
		
		for(int i=v; i<size; i++) {
			if(vx[i]==1) continue;
			dfsX(i);
			vx[i]=0;
			subX.removeLast();
		}
		
	}
	
	public static void dfsY(int v) {
		vy[v]=1;
		subY.addLast(y[v]);
		
		String tmp = subY.toString().replaceAll(", ", "").replace("[", "").replace("]", "");
		if(!listY.contains(tmp)) {
			listY.add(tmp);
		}
		
		for(int i=v; i<size; i++) {
			if(vy[i]==1) continue;
			dfsY(i);
			vy[i]=0;
			subY.removeLast();
		}
		
	}
	
	

}
