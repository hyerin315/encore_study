package pocketmon;

public class Lee extends PocketMon {
	
	public Lee() {
		System.out.println("�̻��ؾ��� �����մϴ�...");
		this.name = "Lee";
		hp = 20;
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		hp += 3;
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		hp += 5;
	}

	@Override
	public boolean play() {
		// TODO Auto-generated method stub
		hp -= 8;
		exp += 5;
		levelupCheck();
		return hp > 0;
	}

	@Override
	public boolean exc() {
		// TODO Auto-generated method stub
		hp -= 12;
		exp += 8;
		levelupCheck();
		return hp > 0;
	}

	@Override
	public void levelupCheck() {
		// TODO Auto-generated method stub
		if (exp >= 20) {
			level++;
			exp -= 20;
			System.out.println(name + ", ������!!!");
		}
	}
	
	public void lAttack() {
		System.out.println("���� ����~~!!!!");
	}
}
