package day0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BabyGin {
	/*
	run : ���ӵ� ���� 3��
	triplet : ������ ���� 3��
	baby-gin : run, triplet���� ������ ���ڿ�
	*/
	static int counts[];//0~9������ ������ �󵵼� ���� 
						//�����Ҹ� üũ�ϸ� run, triplet, baby-gin ���� �Ǵ�
	
	static boolean tri;
	static boolean r;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		counts = new int[10]; //0,1,2,3, .. ~ 9
		
		for(int i=0; i<s.length(); i++) {
			int index = s.charAt(i)-'0';
			counts[index]++;
		}
		
		tri=false;
		r=false;
		triplet(counts);
		run(counts);
		
		if(tri==true && r==true) {
			System.out.println("Baby-Gin");
			
		}else if(tri==true && r==false){
			System.out.println("triplet, but No Baby-Gin");
			
		}else if(tri==false && r==true){
			System.out.println("run, but No Baby-Gin");
		}
		
	}
	
	public static void triplet(int counts[]) {
		for(int i=0; i<counts.length; i++) {
			//counts[i] 3�̻��ΰ� ã����
			if(counts[i]>=3) {
				//3�������ְ�
				counts[i] -= 3;
				//triplet ǥ��
				tri = true;
			}
		}
	}
	
	public static void run(int counts[]) {
		for(int i=0; i<counts.length ;i++) {
			//counts[i] 1�̻��ΰ� ã����
			if(counts[i]>=1) {
				boolean flag=false;
				
				//counts[i], counts[i+1], counts[i+2] 1�̻����� ����
				for(int j=0; j<3; j++) {
					//�߰��� 1�̸��ΰ� �߰ߵǸ� break
					if(counts[i+j]<1) {
						flag=false;
						break;
					}
					
					flag=true;
				}
				
				//counts[i], counts[i+1], counts[i+2] ��� 1�̻��̸�
				if(flag==true) {
					//1�� �������ְ�, runǥ��
					for(int k=0;k<3; k++) {
						counts[i+k]-=1;
						r=true;
					}
				}
			}
		}
	}

}
