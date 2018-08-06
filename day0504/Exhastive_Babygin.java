package day0504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exhastive_Babygin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[6];
		int i=0;
		while(st.hasMoreTokens()) {
			arr[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		int run=0;
		int triple=0;
		for(int i0=0; i0<6; i0++) {
			for(int i1=0; i1<6; i1++) {
				if(i1!=i0) {
					for(int i2=0; i2<6; i2++) {
						if(i2!=i1 && i2!=i0) {
							for(int i3=0; i3<6; i3++) {
								if(i3!=i2 && i3!=i1 && i3!=i0) {
									for(int i4=0; i4<6; i4++) {
										if(i4!=i3 && i4!=i2 && i4!=i1 && i4!=i0) {
											for(int i5=0; i5<6; i5++) {
												if(i5!=i4 && i5!=i3 && i5!=i2 && i5!=i1 && i5!=i0) {
													//System.out.println(arr[i0]+" "+arr[i1]+" "+arr[i2]+" "+arr[i3]+" "+arr[i4]+" "+arr[i5]);	
													
													if(arr[i2]==arr[i0]+2 && arr[i1]==arr[i0]+1) {
														run = 1;
													}else if(arr[i5]==arr[i3] && arr[i4]==arr[i3]) {
														triple=1;
													}
													
													if(arr[i2]==arr[i0] && arr[i1]==arr[i0]) {
														triple=1;
													}else if(arr[i5]==arr[i3]+2 && arr[i4]==arr[i3]+1) {
														run = 1;
													}
													
													
												}	
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		if(run+triple==2) {
			System.out.println("Baby-gin");
			
		}else {
			System.out.println("no");
		}
		
		
	}

}
