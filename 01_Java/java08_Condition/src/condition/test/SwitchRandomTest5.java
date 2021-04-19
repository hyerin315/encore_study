package condition.test;

public class SwitchRandomTest5 {
	public static void main(String[] args) {
		//dice 1~6사이의 정수가 나오도록 코드를 수정
		int dice = (int)(Math.random()*6)+1;//0이 포함되어 있기 때문에 +1을 해줘야함
		System.out.println(dice);
		/*
		 * switch문을 사용해서 각각의 값이 나올 때 dice 1
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
