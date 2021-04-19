package com.encore.dao.implement;
import java.util.ArrayList;
import com.encore.dao.define.BookedTicketDaoDefine;
import com.encore.vo.BookedTicket;
public class BookedTicketDaoImplement implements BookedTicketDaoDefine{
	
	private ArrayList<BookedTicket> bookedTicket;
	
	public BookedTicketDaoImplement() {
		bookedTicket = new ArrayList<BookedTicket>();
	}
	
	
	@Override
	public ArrayList<BookedTicket> getAllBookedTicket() {
		return bookedTicket;
	}
	
	
	@Override
	public void addBooking(BookedTicket bt) {
		//System.out.println(BookedTicket.getSeatCnt());
		//System.out.println(bt.getBookingSeat());
		if((BookedTicket.getSeatCnt())-bt.getBookingSeat()>=0 && !bookedTicket.contains(bt))
		bookedTicket.add(bt);
	 else
		System.out.println("남은 좌석이 없습니다.");
	}
		
	public ArrayList<BookedTicket> addBooking(String ticketNum) {
		// TODO Auto-generated method stub
		return bookedTicket;
	}
	public BookedTicket getBooking(String ticketNum) {
		// TODO Auto-generated method stub
		BookedTicket tk = null;
		for(BookedTicket bk : bookedTicket) {
			if(bk.getTicketNum().equals(ticketNum)) {
				tk=bk;
			}
		}
		return tk;
	}	
			
		/*System.out.println(bk);
		BookedTicket bt = new BookedTicket();
		bt.setTicketNum(ticketNum);
		
		int idx = bookedTicket.indexOf(bt);
		System.out.println(idx);
		System.out.println(bookedTicket.get(idx));
		if(idx<0) {
			return null;
		}else {
			return bookedTicket.get(idx);
		}*/
		
		/*for(BookedTicket bk : bookedTicket) {
			if(bk.getTicketNum().equals(ticketNum)) {
				System.out.println(bk);
				return bk;
			}
		}
		return null; */
	
	
	@Override
	public void deleteBooking(String ticketNum) {
		// TODO Auto-generated method stub
		//BookedTicket t = new BookedTicket();
		//t.setTicketNum(ticketNum);
		boolean deleted;
		for(BookedTicket bk : bookedTicket) {
			if(bk.getTicketNum().equals(ticketNum)) {
				deleted = bookedTicket.remove(bk);
				System.out.println("취소완료");
				break;
			}
		}
		/*if(flag) {
			System.out.println("취소완료");
		}else {
			System.out.println("없는 예약 번호. 취소 불가");	
		}*/
	}


	/*@Override
	public BookedTicket getBooking(String ticketNum) {
		// TODO Auto-generated method stub
		return null;
	}*/

}