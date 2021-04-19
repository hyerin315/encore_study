package warehouse;

public interface Dao {
	void insert(Product p);//제품 등록
	Product selectByNum(int num);//번호로 검색 (번호는 중복되지 않음) -> Product로 변환
	Product[] selectByName(String name);
	Product[] selectAll();
	void update(int num, int price);
	void delete(int num);
	void in_out(int num, int a);//a:입출고 수량
	
}
