package warehouse;

import java.util.ArrayList;

//배열에 추가, 수정, 삭제 ... 작업 수행
public class DaoImpl implements Dao {

	private ArrayList<Product> datas;//배열에 저장된 데이터 개수 자동 생성

	public DaoImpl() {
		datas = new Product[30];// 단점=배열 생성시 크기 결정. 크기 고정. 배열의 크기와 데이터의 개수가 다름
		// datas.length: 방의 개수만 나타내지 데이터의 개수를 나타내지 않는다. 데이터가 추가 삭제시 데이터의 개수를 따로 관리.
	}

	@Override
	public void insert(Product p) {
		if (cnt >= datas.length - 1) {
			System.out.println("배열 참. 등록 취소");
			return;
		}
		datas[cnt] = p;
		cnt++;
	}

	@Override
	public Product selectByNum(int num) {
		for (int i = 0; i < cnt; i++) {
			if (datas[i].getNum() == num) {
				return datas[i];
			}
		}
		return null;// not found
	}

	@Override
	public Product[] selectByName(String name) {
		Product[] d = new Product[cnt];//이름이 동일한 제품을 담을 배열. 개수를 모르기 때문에 cnt개수 만큼 생성
		Product[] d2 = null;//실제 반환할 배열 선언.
		int c = 0;//이름이 동일한 제품 수

		for (int i = 0; i < cnt; i++) {
			if (datas[i].getName().equals(name)) {
				d[c++] = datas[i];
			}
		}
		if (c != 0) {
			d2 = new Product[c];
			System.arraycopy(d, 0, d2, 0, c);
		}
		d = null;
		return d2;
	}

	@Override
	public Product[] selectAll() {
		Product[] d = new Product[cnt];
		System.arraycopy(datas, 0, d, 0, cnt);
		return d;
	}

	@Override
	public void update(int num, int price) {
		Product p = selectByNum(num);
		if (p != null) {
			p.setPrice(price);
		} else {
			System.out.println("없는 제품 번호");
		}
	}

	@Override
	public void delete(int num) {
		Product p = selectByNum(num);
		int i = 0;
		if (p != null) {
			for (i = 0; i < cnt; i++) {
				if (datas[i] == p) {
					break;
				}
			}
			for (int j = i; j < cnt - 1; j++) {// 삭제할 위치 i.cnt:5 [0:4]
				datas[j] = datas[j + 1];
			}
			cnt--;
		} else {
			System.out.println("없는 제품 번호");
		}
	}

	@Override
	public boolean in_out(int num, int a) {//a:수량. 입고:양수, 출고:음수
		// TODO Auto-generated method stub
		boolean flag = false;
		Product p = selectByNum(num);

		if (p != null) {
			int sum = p.getAmount() + a;
			if (sum < 0) {//출고시 제품 수량 부족인 상황
				System.out.println("수량이 부족하여 출고 취소");
			} else {
				p.setAmount(sum);//입출고 처리 완료
				flag = true;
			}
		} else {
			System.out.println("없는 제품 번호");
		}
		return flag;
	}

}
