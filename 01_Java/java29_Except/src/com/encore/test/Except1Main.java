package com.encore.test;
//����ó�� ����
public class Except1Main {
	public int test;

	public static void main(String[] args) {
		System.out.println("���� �߻� ��");
		//int x = 3 / 0; ����� 0���� ������ �ȵ�, 0���� ������ �ٿ��
		int x;
		int[] arr = {1,2,3};
		Except1Main em = null;
		try {
			System.out.println("try ��� 1");
			//x = 3 / 0;
			//arr[3] =  4;
			em.test = 10;
			System.out.println("try ��� 2");//���� �ȵ�. ������ ���� �߻��� catch������� �б�
		} catch (ArithmeticException e) {
			System.out.println("���ܹ߻�: "+e);
		} catch (ArrayIndexOutOfBoundsException e) {//�ε����� ����� ����ó������ �߻��ϸ�, ĳġ���� ���ָ� ��
			System.out.println("���ܹ߻�: "+e);
		} catch (NullPointerException e) {//�ε����� ����� ����ó������ �߻��ϸ�, ĳġ���� ���ָ� ��
			System.out.println("���ܹ߻�: "+e);
		} catch (Exception e) {//(==if�� else�� ����): ���� ������ ���� ��ü�� �ƴϸ� ���⼭ �ɷ��� (����ġ ���� ���ܰ� �� ���� ��)
		//Exception�� �������� ���� ����
			System.out.println("���ܹ߻�: "+e);
		} finally {//�ʿ��� ��� (�� ������Ѿ��ϴ� ���) �ۼ�
			System.out.println("�� ����");
		}
		  System.out.println("���� �߻� ��");
	}
}
