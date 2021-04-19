package array.test.self;

public class ArrayTest {
	public static int[] list= {34,23,64,25,12,75,22,88,53,37};

	public static void main(String[] args) {
		print();
		total();
		average();
		minimum();
		selectionSort();
	}
	
	static int total=0, minimum = list[0];
	static double average = 0;
	
	//1. ����Ʈ
	public static void print() {
		for(int i : list) 
		System.out.print(i+" ");	
	}
	//2. �迭�� ��
	private static void total() {
		for(int i=0; i<list.length; i++) 
		total += list[i];
		System.out.println("\n�迭�� �� :"+total);
	}
	//3. ���
	private static void average() {
		average = total / list.length;
		System.out.println("�迭�� ��� : "+average);
	}
	//4. �ּҰ� 
	private static void minimum() {
		for(int i=0; i<list.length; i++)
			if(list[i]<minimum) minimum = list[i];
		System.out.println("�迭�� �ּҰ� : "+minimum);
		System.out.println("===selection sort (Ascending Order)===");
	}
	//5. sort
	private static void selectionSort() {
		for(int i : list)
			System.out.print(i+" ");
	}
}
