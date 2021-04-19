package pocketmon;

public abstract class PocketMon {// 상속을 목적으로 만듬. 객체 생성 안함
	protected String name;
	protected int hp;
	protected int exp;
	protected int level;

	abstract public void eat();

	abstract public void sleep();

	abstract public boolean play();

	abstract public boolean exc();

	abstract public void levelupCheck();

	public void printInfo() {
		System.out.println(name + " 상태 확인");
		System.out.println("hp:" + hp);
		System.out.println("exp:" + exp);
		System.out.println("level:" + level);
	}
}
