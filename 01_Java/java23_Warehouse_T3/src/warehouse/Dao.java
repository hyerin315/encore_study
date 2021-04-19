package warehouse;

public interface Dao {
	void insert(Product p);//제품등록
	Product selectByNum(int num);//번호로 검색해서 Product 반환
	Product[] selectByName(String name);
	Product[] selectAll();
	void update(int num, int price);
	void delete(int num);
	boolean in_out(int num, int a);//a:입출고 수량
}


