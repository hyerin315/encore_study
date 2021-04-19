package pocketmon;

public class Gobook extends PocketMon {
	public Gobook() {
		System.out.println("꼬북이를 생성합니다...");
		this.name = "Gobook";
		hp = 10;
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		hp += 15;
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		hp += 20;
	}

	@Override
	public boolean play() {
		// TODO Auto-generated method stub
		hp -= 20;
		exp += 15;
		levelupCheck();
		return hp > 0;
	}

	@Override
	public boolean exc() {
		// TODO Auto-generated method stub
		hp -= 30;
		exp += 25;
		levelupCheck();
		return hp > 0;
	}

	@Override
	public void levelupCheck() {
		// TODO Auto-generated method stub
		if (exp >= 40) {
			level++;
			exp -= 40;
			System.out.println(name + ", 레벨업!!!");
		}
	}
	
	public void gAttack() {
		System.out.println("물대포 공격~~");
	}

}
