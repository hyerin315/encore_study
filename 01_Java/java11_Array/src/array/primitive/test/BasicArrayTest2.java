package array.primitive.test;
/*
 * �迭�� ����, ����, �ʱ�ȭ ���ÿ�...
 * 
 */

public class BasicArrayTest2 {
	public static void main(String[] args) {
		// ���� 6����� ���� ����� 6�̶� �Ͱ� ������ ǥ���̴� 
		int[ ] target = {1,2,3,4,5,6};//����,����,�ʱ�ȭ ���ÿ� �� �� --> �迭�� ������ ������ �ݵ�� ����!!
		int[ ] source = {10,9,8,7,6,5,4,3,2,1};
		//target = {1,2,3,4,5,6,7,8,9,10}; 
		//--> ����� 6ĭ ¥�� �迭�� ������µ� 7,8,9,10�� �ֱ����� ����� �÷��� ���� ��
		//���� --> ���� ó���� ���� ����� �� �� �ִ�
		
		//�迭�� �� �� ������ ����� ������ �� ����...����� �ø��� �ʹٸ� ���?
		//--> 10ĭ¥�� �迭�� ���� ����, ���Ŀ��� ��� ����� �ø��� ������ ���� �����ؾ��ϹǷ� ó������ �˳��ϰ� �����ϴ� ���� ����
		//�׷��� ����� �ٸ� �迭�� ��Ҹ� copy�� �� ���� �ִ� --> System.arraycopy(ī���� ��, ��𼭺��� ī���� ����, ī���� ��, ���°���� ������ ������, ��� �� ������)

		//target �迭�� ����� ���������� ���������� ��Ҵ� source�� ������ ī���ؿð��̴�
		//SystemŬ������ arraycopy()�� ����ؼ� 8,7,6,5,4,3���� ��µǵ��� �ۼ�
		System.arraycopy(source, 2, target, 0, target.length);//�������� 6���� �ص� ������ ������...
		
		
		/*for(int i=0; i<target.length; i++)
			System.out.println(target[i]+" "); --> �̷��� �ᵵ �ǰ� �Ʒ��� ���� ǥ�� (�˰����򿡼��� ���� for���� ���� */
			
		//���� for��...(���� �� ȿ������ ����)...forEach�� --> �˰����� ���� ���α׷������� �� for���� ����
		//���� ��𿡼� ���ư��°�? �� ���
		for(int i : target) System.out.print(i+" ");//target�� �ִ� �ϳ��ϳ��� ���� i�� ���� �ְ� �ְ� �̰� �����
		//print�� ������ ���, println�� �Ʒ��� ���
		
	}

}