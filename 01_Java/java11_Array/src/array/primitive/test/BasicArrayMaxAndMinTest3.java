package array.primitive.test;


public class BasicArrayMaxAndMinTest3 {
	public static void main(String[] args) {
		int[ ] score = {79,88,91,44,100,55,96};
		//score�� �߿��� �ְ������� ���������� �ܼ�â�� ����ϴ� ������ �ۼ�
		//max, min ���� �߷����� �˰���
		
		// int min = 100; --> ���� ���� ū ������ ��Ƶ� --> �׷��� �̷��� ������ �ȵ�, ������ �� ū���� �� �� �����Ƿ�
		// int max = 0; 
		int min = score[0];//79 �迭�� ù��° ������ �ʱ�ȭ
		int max = score[0];
		
		for(int i=0; i<score.length; i++) {
			if(score[i]<min) min = score[i];
			if(score[i]>max) max = score[i];
		}		
		
		System.out.println("�ּҰ� : "+min);
		System.out.println("�ִ밪 : "+max);
	}

}