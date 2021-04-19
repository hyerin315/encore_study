package com.encore.inter;
import com.encore.vo.Product;

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

	@Override
	public void insert(Product p) {
		if(cnt>=datas.length - 1) {
			System.out.println("배열 창. 등록 취소");
			return;
		}
		datas[cnt] = p;
		cnt++;
	}
	//동관님 : 
	@Override
	public Product selectByNum(int num) {
		Product temp = new Product();
		for(Product p : datas) {
			if(p.getNum() == num) {
				temp = p;
			System.out.println(p.toString());
			}else
				break;
		}
		return temp;
	}
	
	//동관님 :
	@Override
	public Product[] selectByName(String name) {
		Product[]temp = new Product[cnt];
		for(Product p: datas) {
			if(p.getName().equals(name)) {
				return temp;
			}
		}
		return null;
	}
	
	//승연님 : 
	@Override
	public Product[] selectAll() {
		Product[] all = new Product[datas.length];
		int idx = 0;
		for(Product p: datas) all[idx++]=p;
		return all;
	}
	
	//승연님 : 가격수정
	@Override
	public void update(int num, int price) {
		Product product = null;
		for (Product p : datas) {
			if(p.getNum()==num) p.setPrice(price);
		}
	}

	//소정님 : 삭제 
	@Override
	public void delete(int num) {
		int lastIndex=cnt-1;
		for(int i=0; i<=lastIndex; i++) {
			if(i+1==num) {
				for (int j=i+1; j<=lastIndex;j++) {
					datas[j]=datas[j+1];
				}
				datas[lastIndex]=null;
				cnt--;
			}
		}
	}

	//소정
	@Override
	public void in_out(int num, int a) {
		int new_amount=0;
		int lastIndex=cnt-1;
		for(int i=0; i<=lastIndex; i++) {
			if(i+1==num) {
				new_amount=datas[i].getAmount()+a;
				if(new_amount<0) {
					datas[i].setAmount(0);
					continue;
				}
				datas[i].setAmount(new_amount);
				}
			}
		}
}