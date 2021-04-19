package array.primitive.test;


public class BasicArrayMaxAndMinTest3 {
	public static void main(String[] args) {
		int[ ] score = {79,88,91,44,100,55,96};
		//score값 중에서 최고점수와 최저점수를 콘솔창에 출력하는 로직을 작성
		//max, min 값을 추려내는 알고리즘
		
		// int min = 100; --> 보통 제일 큰 값으로 잡아둠 --> 그런데 이렇게 잡으면 안됨, 음수나 더 큰수가 들어갈 수 있으므로
		// int max = 0; 
		int min = score[0];//79 배열의 첫번째 값으로 초기화
		int max = score[0];
		
		for(int i=0; i<score.length; i++) {
			if(score[i]<min) min = score[i];
			if(score[i]>max) max = score[i];
		}		
		
		System.out.println("최소값 : "+min);
		System.out.println("최대값 : "+max);
	}

}