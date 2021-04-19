package com.encore.lang;
class Person{
	int num;
	String name;
	public Person(int num, String name) {
		this.num = num;
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Person) {
			Person p = (Person)obj;
			if(num==p.num && name.equals(p.name)) {
				return true;
			}
		}
		return false;
	}
	public String hashcode(Person p5) {
		// TODO Auto-generated method stub
		return null;
	}
}
//Object 클래스는 equals()를 무조건 참조값 비교한 결과 반환
public class EqualsTestMain {
	public static void main(String[] args) {
		Person p1 = new Person(1, "aaa");
		Person p2 = new Person(2, "aaa");
		Person p3 = new Person(1, "bbb");
		Person p4 = p1;//주소값 비교, 얕은 복사
		Person p5 = new Person(1, "aaa");

		System.out.println("p1==p2: " + (p1 == p2));
		System.out.println("p1==p3: " + (p1 == p3));
		System.out.println("p1==p4: " + (p1 == p4));
		System.out.println("p1==p5: " + (p1 == p5));

		System.out.println("p1.equals(p2): " + p1.equals(p2));
		System.out.println("p1.equals(p3): " + p1.equals(p3));
		System.out.println("p1.equals(p4): " + p1.equals(p4));
		System.out.println("p1.equals(p5): " + p1.equals(p5));

		System.out.println("p1.hashCode(): " + p1.hashCode());
		System.out.println("p2.hashCode(): " + p2.hashCode());
		System.out.println("p3.hashCode(): " + p3.hashCode());
		System.out.println("p4.hashCode(): " + p4.hashCode());
		System.out.println("p5.hashCode(): " + p5.hashCode());
	}

}
