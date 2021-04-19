package warehouse;

//배열의 추가, 수정, 삭제...작업 수행 
//--> 나중에 수정하기 편하라고 인터페이스 생성

public class DaoImpl implements Dao {
	
	private Product[] datas;//저장소
	private int cnt;//배열에 저장된 데이터 개수
	
	public DaoImpl() {
		datas = new Product[30];
		//배열의 단점 : 생성시 크기 걱정, 크기 고정, 배열의 크기와 저장된 데이터의 개수가 다름
		//data.length : 방의 개수만 나타내지 데이터의 개수를 나타내지 않는다, 데이터 추가 삭제시 데이터의 개수를 따로 관리
	}
	
	//1.상품등록
	@Override
	public void insert(Product p) {
		if(cnt>=datas.length - 1) {
			System.out.println("배열 창. 등록 취소");
			return;
		}
		datas[cnt] = p;
		cnt++;
	}
	
	//2.번호 검색
	@Override
	public Product selectByNum(int num) {
		for(int i = 0; i < cnt; i++) {
			if(datas[i].getNum() == num) {
				return datas[i];
			}
		} 
		return null;//not found
	}
	
	//3.이름으로 검색
	@Override
	public Product[] selectByName(String name) {
		Product[] temp = new Product[cnt];//이름이 동일한 제품을 담을 배열 (개수를 모르기 때문에 최대 개수인 cnt개수만큼 생성
		Product[] temp2 = null;//실제 반환할 배열 - 여기서는 선언만
		int c = 0;//이름이 동일한 제춤 수를 나타내는 변수
		
		for(int i = 0; i < cnt; i++) {
			if(datas[i].getName().equals(name)) {
				temp[c++] = datas[i];//똑같은 제품이 찾아질때마다 temp에 넣음
			}
		}
		if(c != 0) {
			temp2 = new Product[c];//하나라도 찾아졌다면 배열에 넣음
			System.arraycopy(temp, 0, temp2, 0, c);
		}
		temp = null;//G.C에게 정보를 주기위해 null을 넣어줌(쓰지 않는 것을 다 반환) --> 메모리 해제를 위해(메모리를 효율적으로 사용하기 위해)
		return temp2;
	}
	
	//4.가격수정 
	@Override
	public void update(int num, int price) {
		Product p = selectByNum(num);//번호를 찾아서 객체를 할당
		if(p != null) {
			p.setPrice(price);
		}else {
			System.out.println("없는 제품번호입니다");
		}
	}

	//5.제품삭제
	@Override
	public void delete(int num) {
		Product p = selectByNum(num);//번호를 찾아서 객체를 할당
		int i = 0;
		if(p != null) {
			for(i = 0; i < cnt; i++) {
				if(datas[i] == p) {
					break;
				}
			}
			for(int j = i; j < cnt-1; j++) {//삭제할 위치가 "i"
				datas[j] = datas[j+1];
			}
			cnt--;
		}else {
			System.out.println("없는 제품번호입니다");
		}
	}
	
	//6.전체제품 출력 
	@Override
	public Product[] selectAll() {
		Product[] temp = new Product[cnt];
		System.arraycopy(datas, 0, temp, 0, cnt);
		return temp;
	}

	//7.입고 & 8.출고
	@Override
	public boolean in_out(int num, int a) {//a:수량, 입고:양수, 출고:음수
		boolean flag = false;
		Product p = selectByNum(num);//번호를 찾아서 객체를 할당
		if(p != null) {
			int sum = p.getAmount() + a;
			if(sum < 0) {//출고시 제품 수량이 부족한 상황
				System.out.println("제품 수량이 부족하여 출고할 수 없습니다.");
			} else
				p.setAmount(sum);//입출고 처리 완료
			    flag = true;
		}else {
			System.out.println("없는 제품번호입니다");
		}
		return flag;
	}
}