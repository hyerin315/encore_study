package array.primitive.test;

class ArrayExam{//�񱳸� ���� ���� Ŭ����
	String type="�迭";
	public String type() {
		return "�迭";
	}
}
public class BasicArrayTest1 {
	public static void main(String[] args) {
		//1. intŸ���� �迭�� ����...3ĭ¥��
		int[] arr = new int[3];
		System.out.println("�迭�� �ּҰ� ��� : "+arr);
		
		ArrayExam exam = new ArrayExam();
		System.out.println("ArrayExam�� �ּҰ� ��� : "+exam);
		
		//2. �迭�ȿ� �ִ� �⺻�� ���
		for(int i=0; i<arr.length; i++) //����� �����ϴ� �迭�� �ʵ� --> length
			System.out.println(arr[i]+"  ");//+"  "�� �ϸ� ������ ��, ���� 0
		//������Ʈ��Ʈ�� �ϳ��϶��� {} �̰� �Ƚᵵ ��
		
		//3. �ʱ�ȭ
		arr[0] = 11; arr[1] = 22; arr[2] = 33;
		
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]+"  ");//11,22,33
	}
}
/*
 * �迭�� �ּҰ� ��� : [I@7852e922 
 * ArrayExam�� �ּҰ� ��� : array.primitive.test.ArrayExam@4e25154f
 * --> �ּҰ� ��� ���°� �ٸ� (��ü��� �� ������ �迭�� Ŭ������ ���� ����)
 *     = "�迭�� Ŭ������ �������� �ʴ� ��ü�̴�." = ����� api�� ���ؼ� Ȯ���� �� ���� --> Ư���� ����
 */
