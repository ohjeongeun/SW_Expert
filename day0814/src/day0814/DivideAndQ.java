package day0814;

import java.util.LinkedList;

public class DivideAndQ {

	public static void main(String[] args) {
		LinkedList<Integer> result = new LinkedList<>();

		result.add(69);
		result.add(10);
		result.add(30);
		result.add(2);
		result.add(16);
		result.add(8);
		result.add(31);
		result.add(22);
		
		System.out.println(merge_sort(result));
		
	}
	
	public static LinkedList<Integer> merge_sort(LinkedList<Integer> list) {
		//���� ����
		//����Ʈ ���̰� 1�̸� ���� ����
		if(list.size()==1) return list;
		
		LinkedList<Integer> left = new LinkedList<>();
		LinkedList<Integer> right = new LinkedList<>();
		LinkedList<Integer> result = new LinkedList<>();

		int middle = list.size()/2;

		// ��ȯ�� ����Ʈ���� ���ĵ� ����
		for(int x=0; x<middle; x++) {
			left.add(list.get(x));
		}
		for(int x=middle; x<list.size(); x++) {
			right.add(list.get(x));
		}
		
		//merge �Լ��� ���� �ϳ��� ����Ʈ�� �����Ͽ� ��ȯ
		left = merge_sort(left);
		right = merge_sort(right);
		return merge(result, left, right);
		
	}
	
	public static LinkedList<Integer> merge(LinkedList<Integer> result, LinkedList<Integer> left, LinkedList<Integer> right) {
		
		//���� ����(����Ʈ�� ���ĵ� ���¿��� ��)
		while(left.size()>0 || right.size()>0) {
			if(left.size()>0 && right.size()>0) {
				if(left.getFirst() <= right.getFirst()) {
					result.add(left.removeFirst());
				}else {
					result.add(right.removeFirst());
				}
			
			}else if(left.size()>0) {
				result.add(left.removeFirst());
			
			}else if(right.size()>0) {
				result.add(right.removeFirst());
			}
			
		}
		return result;
		
	}

}
