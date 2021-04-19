package pocketmon;

public class Picachu extends PocketMon {
	public Picachu() {
		System.out.println("피카츄를 생성합니다...");
		this.name = "picachu";
		hp = 30;
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		hp += 5;
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		hp += 10;
	}

	@Override
	public boolean play() {
		// TODO Auto-generated method stub
		hp -= 10;
		exp += 10;
		levelupCheck();
		return hp > 0;
	}

	@Override
	public boolean exc() {
		// TODO Auto-generated method stub
		hp -= 15;
		exp += 15;
		levelupCheck();
		return hp > 0;
	}

	@Override
	public void levelupCheck() {
		// TODO Auto-generated method stub
		if (exp >= 30) {
			level++;
			exp -= 30;
			System.out.println(name + ", 레벨업!!!");
		}
	}

	public void pAttack() {
		System.out.println("백만볼트 공격~~!!");
	}

}
