package board.member;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
//		MemService service = new MemServiceImpl();
//		service.addMember(new Scanner(System.in));
		MemberService service = new MemberService();
		service.addMember(new Member("ccc", "111", "namec", "ccc@email.com"));
		ArrayList<Member> list = service.getMembers();
		System.out.println(list);
	}
}
