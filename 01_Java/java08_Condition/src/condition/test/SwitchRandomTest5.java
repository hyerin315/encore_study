package condition.test;

public class SwitchRandomTest5 {
	public static void main(String[] args) {
		//dice 1~6������ ������ �������� �ڵ带 ����
		int dice = (int)(Math.random()*6)+1;//0�� ���ԵǾ� �ֱ� ������ +1�� �������
		System.out.println(dice);
		/*
		 * switch���� ����ؼ� ������ ���� ���� �� dice 1
		 */
		String message = "Dice...";
		switch(dice) {
		    case 1 :
		           message = "dice 1";
		           break;
		    case 2 :
			       message = "dice 2";
			       break;		       		       
		    case 3 :
			       message = "dice 3";
			       break;
		    case 4 :
			       message = "dice 4";
			       break;
		    case 5 :
			       message = "dice 5";
			       break;
		    case 6 :
			       message = "dice 6";
			       break;
		      
		}
		System.out.println(message);
	}

}
