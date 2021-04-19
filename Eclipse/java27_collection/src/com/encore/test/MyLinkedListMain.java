package com.encore.test;

class Node{
	private int data;
	private Node next;//다음 노드값을 담을 참조변수 생성
	
	public Node() {
	}
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
}

class MyLinkedList{
	private Node head;
	private Node tail;
	
	public void addNode(int num) {
		Node bmp = new Node(num, null);
		if(head == null) {//bmp가 첫번째 노드냐?
			head = bmp;//헤드는 노드의 첫번째 값을 할당받음 (tail은 반대)
		} else {
			tail.setNext(bmp);
		}
		tail = bmp;
	}
	
	public void printNode() {//첫 노드부터 마지막까지 방문하면서 data 값 출력
		Node cur = head;//head는 움직이면 안됨 --> 그래서 얘 대신에 움직일 애를 할당
		while(cur!=null) {
			System.out.println(cur.getData());
			cur = cur.getNext();	
		}
	}
	
	//노트 탐색
	public Node[] searchNode(int num) {
		//이중 링크드 리스트는 앞과 뒤로 이동 가능하지만, 이건 안그러니까 앞의 칸 노드를 반환할 수 있도록 생성
		Node prev = null, cur = head;
		Node[] d = new Node[2];
		while(cur!=null) {
			if(cur.getData()==num) {
				d[0] = prev;
				d[1] = cur;
				return d;
			}
			prev = cur;
			cur = cur.getNext();//한 칸씩 앞으로 이동
		}
		return null;
	}
	
	//수정
	public void editNode(int old_num, int new_num) {
		Node[] node = searchNode(old_num);
		if(node==null) {
			System.out.println("없는 값");
		} else {
			node[1].getNext().setData(new_num);
		}
	}

	//삭제
	public void delNode(int num) {
		Node[] node = searchNode(num);
		if(node==null) {
			System.out.println("없는 값");
		} else {
			if(node[0]==null) {//첫번째 노드 삭제시
				head=node[1].getNext();
			}else if(node[1].getNext()==null) {//마지막 노드 삭제시
				tail = node[0];
				tail.setNext(null);
			}else {//중간노드
			node[0].setNext(node[1].getNext());
			}
		}
	}
}

public class MyLinkedListMain {
	public static void main(String[] args) {
		MyLinkedList id = new MyLinkedList();
           for(int i=1; i<10; i++) {
        	   id.addNode(i);
           }
           
        	id.printNode();
        	id.editNode(3, 30);
        	id.printNode();
        	id.delNode(5);
        	id.printNode();
        	id.delNode(1);
        	id.printNode();
        	id.delNode(9);
        	id.printNode();
	}
}
