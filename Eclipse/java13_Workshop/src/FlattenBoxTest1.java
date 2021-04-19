import java.util.Arrays;//알고리즘이어서 패키지 안달아둠
import java.util.Scanner;

public class FlattenBoxTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int boxLen = 100;
		for(int tcn = 1; tcn<=tc; tcn++) {
			int dump = sc.nextInt();
			int[ ] boxes = new int[boxLen];
			for(int i=0; i<boxes.length; i++) {
				boxes[i] = sc.nextInt();
			}//초기화 완료...
			
			int heighDiff=flatten(boxes,dump );
			System.out.printf("#%d %d%n",tcn, heighDiff);//printf는 포맷을 맞춰서 출력하는 것
		}
	}

	static int flatten(int[] boxes, int dump) {
		for(int i=0; i<dump; i++) {
			Arrays.sort(boxes);//최고-최저가 정렬이 되어 재배치
			int diff = boxes[boxes.length-1]-boxes[0];//맨 끝에서 맨 앞을 뺀 것
			if(diff<=1) {
				return diff;
				}
			boxes[0]++;
			boxes[boxes.length-1]--;
		}
		//이 부분을 반드시 추가해야한다
        Arrays.sort(boxes);
		return boxes[boxes.length-1]-boxes[0];
	}	
}













