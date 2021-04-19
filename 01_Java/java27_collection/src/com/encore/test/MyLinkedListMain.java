package com.encore.test;

class Node{
	private int data;
	private Node next;//���� ��尪�� ���� �������� ����
	
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
		if(head == null) {//bmp�� ù��° ����?
			head = bmp;//���� ����� ù��° ���� �Ҵ���� (tail�� �ݴ�)
		} else {
			tail.setNext(bmp);
		}
		tail = bmp;
	}
	
	public void printNode() {//ù ������ ���������� �湮�ϸ鼭 data �� ���
		Node cur = head;//head�� �����̸� �ȵ� --> �׷��� �� ��ſ� ������ �ָ� �Ҵ�
		while(cur!=null) {
			System.out.println(cur.getData());
			cur = cur.getNext();	
		}
	}
	
	//��Ʈ Ž��
	public Node[] searchNode(int num) {
		//���� ��ũ�� ����Ʈ�� �հ� �ڷ� �̵� ����������, �̰� �ȱ׷��ϱ� ���� ĭ ��带 ��ȯ�� �� �ֵ��� ����
		Node prev = null, cur = head;
		Node[] d = new Node[2];
		while(cur!=null) {
			if(cur.getData()==num) {
				d[0] = prev;
				d[1] = cur;
				return d;
			}
			prev = cur;
			cur = cur.getNext();//�� ĭ�� ������ �̵�
		}
		return null;
	}
	
	//����
	public void editNode(int old_num, int new_num) {
		Node[] node = searchNode(old_num);
		if(node==null) {
			System.out.println("���� ��");
		} else {
			node[1].getNext().setData(new_num);
		}
	}

	//����
	public void delNode(int num) {
		Node[] node = searchNode(num);
		if(node==null) {
			System.out.println("���� ��");
		} else {
			if(node[0]==null) {//ù��° ��� ������
				head=node[1].getNext();
			}else if(node[1].getNext()==null) {//������ ��� ������
				tail = node[0];
				tail.setNext(null);
			}else {//�߰����
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
