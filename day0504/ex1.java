package day0504;

public class ex1 {

	public static void main(String[] args) {
		for(int i1=1; i1<=3; i1++) {
			for(int i2=1; i2<=3; i2++) {
				if(i2!=i1) {
					for(int i3=1; i3<=3; i3++) {
						if(i3!=i1 && i3!=i2) {
							System.out.println("{"+i1+","+ i2+","+ i3+"}");
						}
					}
				}
			}
		}
	}

}
