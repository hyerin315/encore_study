package com.encore.parent;
/*
 * Overloading
 * ::
 * �̸��� ������(������ ����̴�)
 * ó���ϴ� �����͸� �޸��ϴ� ���
 * ::
 * 1) ������ �����ε�
 *    --> ������ �̸��� ������ ó���ϴ� �����Ͱ� �ٸ���
 *        �ּ����� �⺻������ �ϴ� ��ü ������ �����ϰ� �ϴ� ���
 *        ������ ������ ���Ŀ� �ٽ� �Ҵ�Ǿ��� �� �ִ�
 * 2) �޼ҵ� �����ε� 
 * ::
 * this ����
 * 1) ������ �տ� this - �ʵ�� ���ú����� �̸��� ������ �� 2���� �����ϱ� ���ؼ� �ʵ�� �տ� �����Ѵ�
 * 2) this() ������ ���� this �뵵 - �ϳ��� Ŭ���� �ȿ��� �� �ٸ� �����ڸ� ȣ���ϴ� ���
 */

import com.encore.util.MyDate;

public class Employee {
	//��������� �⺻ salary���� �ϳ� ����
	public static final double BASE_SALARY = 100.0;
	private String name;
	private MyDate birthDate;
	private double salary;
	
	//������ �����ε��� �� ����ϴ°�?
	/*�����ڴ� �������� ���ڰ��� ������ ���ڰ��� ��������µ� 
	� Employee�� salary�� ���� ���ڰ��� ���� ���, �׷��� ��ü ������ �ǵ��� ��������
	*/
	public Employee() {}//�̰� ������ �ڽ� super();���� ������
	public Employee(String name, MyDate birthDate, double salary) {
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
	}//this Ű���� : �ʵ���̶� ���ú��� �̸��� �Ȱ��� �� ������ ���� �ʵ�� �տ� this�� ���δ�(�ش��ϴ� ��ü�� �������� �ǹ�)

    public Employee(String name) {//�̸��� ������ ��ü�� �������ϴ� ���
		this(name, new MyDate(2000, 1, 1), BASE_SALARY);//this�� ������ �� Ŭ���� �ȿ��� �� �ٸ� ������ ȣ�� -> 28�������� �� (��? ���ڰ��� 3���̹Ƿ�) / �����̶� ������ �⺻������ �־��� ��
	}//�̶� this�� ������ 
	
	public Employee(String name, MyDate birthDate) {
	   this(name, birthDate, BASE_SALARY);//28�������� �� (�������� ���� �� --> �ʿ��� ���� �⺻������ �־���) --> �̶� ������� �� Ȱ���������
	}

/*	public String getDetails() {
		return name+", "+birthDate+", "+salary;
	} */
	
	public String toString() {
		return name+", "+birthDate+", "+salary;
	}

}
