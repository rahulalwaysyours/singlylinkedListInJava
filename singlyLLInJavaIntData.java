//singlyLLInJavaIntData.java

/*

In C,

typedef struct node{
	int data;
	struct node *next;
}node; //self-referential structure

node n1, n2, n3; //static implementation
node *p = (node*)malloc(sizeof(node));
//dynamic
*/

import java.util.*;
class Node{
	//data members
	private int data;
	private Node next;

	//constructor
	Node(int data){
		this.data = data;
	}

	//method definition
	//member function
	int getData(){
		return this.data;
	}

	Node getNext(){
		return this.next;
	}

	void setData(int data){
		this.data = data;
	}

	void setNext(Node ref){
		this.next = ref;
	}
}

class SinglyLinkedList{
	private Node head;
	private Node tail;
	private int nodeCount;


	public void mergeSortedList(SinglyLinkedList list1, SinglyLinkedList list2){

		System.out.println("Work In Progress!");

		Node list1Pointer = list1.head;
		Node list2Pointer = list2.head;

		while(list1Pointer!=null && list2Pointer!=null){
			if(list1Pointer.getData() < list2Pointer.getData())
			{
				insertAtLast(list1Pointer.getData());
				list1Pointer = list1Pointer.getNext();
			}
			else if(list1Pointer.getData() > list2Pointer.getData()){
				insertAtLast(list2Pointer.getData());
				list2Pointer = list2Pointer.getNext();
			}
			else{
				insertAtLast(list2Pointer.getData());
				list1Pointer = list1Pointer.getNext();
				list2Pointer = list2Pointer.getNext();
			}
		}

		Node temp;
		if(list1Pointer != null) temp = list1Pointer;
		else temp = list2Pointer;

		while(temp != null){
			insertAtLast(temp.getData());
			temp = temp.getNext();
		}
		
	}

	public int getNumberOfNodes(){
		return nodeCount;
	}


	public int searchKey(int key)
	{
		Node node = head;
		
		int position = -1;

		while(node != null)
		{
			position++;

			if(node.getData() == key)
			{
				return position;
			}

			node = node.getNext();
		}

		//if while loop condition gets false, and key not found in the list
		return -1;
	}

	//insertAtDeseriedPosition
	public Boolean insertAtDesired(int data, int position){
		//System.out.println("node count = " + nodeCount + "\n");

		if(position == 1){
			insertAtFirst(data);
			return true;
		}
		else if(position < nodeCount){
			//creating new node
			Node newNode = new Node(data);

			Node t = head;

			int count = 1;
			while(count < position-1 && t!=null){
				t = t.getNext();
				count++;
			}

			newNode.setNext(t.getNext());
			t.setNext(newNode);
			return true;
		}
		else{
			System.out.println("We have received invalid position");
			return false;
		}

	}

	//insertAtFirst Definition
	public Boolean insertAtFirst(int data){
		//creating new node
		Node newNode = new Node(data);

		if(head == null){
			head = newNode;
			tail = newNode;
			nodeCount++;
			return true;
		}
		else{
			newNode.setNext(head);
			head = newNode;
			nodeCount++;
			return true;
		}
	}


	//insertionAtLast Definition
	public Boolean insertAtLast(int data){
		//node creation
		Node node = new Node(data);

		if(head == null){
			head = node;
			tail = node;
			//head = tail = node;
			nodeCount++;
			return true;
		}
		else{
			tail.setNext(node);
			//in c, tail.next = node;
			tail = node;
			//tail = tail.getNext();
			nodeCount++;
			return true;
		}
	}//insertAtLast() ends here

	public Boolean deleteAtFirst(){
		if(head == null){
			System.out.println("There is no linked list, which exists");
			return false;
		}
		else{
			head = head.getNext();
			nodeCount--;
			return true;
		}
	}

	public Boolean deleteAtLast(){
		Node t = head;
		int count = 1;
		if(head == null){
			System.out.println("No LinkedList exits");
			return false;
		}
		else{
			System.out.println("Node Count: " + nodeCount);
			while(count < nodeCount-1){
				t = t.getNext();
				count++;
				//System.out.println("Count: " + count);
			}

			
			Node deletedNode = t.getNext();
			System.out.println("We have deleted " + deletedNode.getData());
			t.setNext(null);
			
			return true;
		}
	}

	//insertAtDeseriedPosition
	public Boolean deleteAtDesired(int position){
		//System.out.println("node count = " + nodeCount + "\n");

		if(head == null){
			System.out.println("No node exists");
			return false;
		}
		else if(position == 1){
			deleteAtFirst();
			return true;
		}
		else if(position < nodeCount){
			Node t = head;

			int count = 1;
			while(count < position-1 && t!=null){
				t = t.getNext();
				count++;
			}
			Node nextNode = t.getNext();
			t.setNext(nextNode.getNext());
			
			return true;
		}
		else{
			System.out.println("We have received invalid position");
			return false;
		}

	}

	public Boolean traverse(){
		Node t = head;

		if(head != null){
			System.out.print("HEAD -> ");
			while(t!=null){
				System.out.print(t.getData() + "-> ");
				t = t.getNext();
			}
			System.out.println(" NULL");
			return true;
		}
		else{
			System.out.println("No node exists!");
			return false;
		}
	}
}

class SinglyImplementation{

	public static void printLine(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}

	public static void main(String[] args){
		SinglyLinkedList l1 = new SinglyLinkedList();
		SinglyLinkedList l2 = new SinglyLinkedList();
		SinglyLinkedList l3 = new SinglyLinkedList();

		//passing values to this linkedList
		l1.insertAtLast(5);
		l1.insertAtLast(10);
		l1.insertAtLast(12);
		l1.insertAtLast(13);
		l1.insertAtLast(20);
		l1.insertAtLast(30);
		l1.insertAtLast(32);
		l1.insertAtLast(35);
		l1.insertAtLast(42);

		l2.insertAtLast(2);
		l2.insertAtLast(6);
		l2.insertAtLast(10);
		l2.insertAtLast(11);
		l2.insertAtLast(19);
		l2.insertAtLast(22);
		l2.insertAtLast(30);

		System.out.println("After inserting initial values inn (l1): ");
		l1.traverse();
		System.out.println("Number of Nodes in l1: " + l1.getNumberOfNodes());
		printLine();

		System.out.println("After inserting initial values in (l2): ");
		l2.traverse();
		System.out.println("Number of Nodes in l2: " + l2.getNumberOfNodes());
		printLine();

		l1.insertAtDesired(1, 1);

		System.out.println("After inserting 1 in 1 position in (l1): ");
		l1.traverse();
		System.out.println("Number of Nodes in l1: " + l1.getNumberOfNodes());
		printLine();

		l1.deleteAtFirst();

		System.out.println("After deleting at first in (l1): ");
		l1.traverse();
		System.out.println("Number of Nodes in l1: " + l1.getNumberOfNodes());
		printLine();

		l1.deleteAtLast();

		System.out.println("After deleting at last in (l1): ");
		l1.traverse();
		System.out.println("Number of Nodes in l1: " + l1.getNumberOfNodes());
		printLine();

		l1.deleteAtDesired(3);

		System.out.println("After deleting at 3rd position in (l1): ");
		l1.traverse();
		System.out.println("Number of Nodes in l1: " + l1.getNumberOfNodes());
		printLine();

		//suppose, we have l1 and l2 list which are in sorted order

		l3.mergeSortedList(l1, l2);

		System.out.println("After merging two list l1 and l2, now, traversing l3: ");
		l3.traverse();
		System.out.println("Number of Nodes in l3: " + l3.getNumberOfNodes());
		printLine();

		//testing searchKey() method using l3
		System.out.println("testing searchKey() method using l3");

		int result = l3.searchKey(110);
		if(result < 0)
			System.out.println("Key 110 not found in l3 list");
		else
			System.out.println("Key 110 found at " + result + " index in l3 list");


		System.out.println("testing searchKey() method using l3");

		result = l3.searchKey(19);
		if(result < 0)
			System.out.println("Key 19 not found in l3 list");
		else
			System.out.println("Key 19 found at " + result + " index in l3 list");


	}
}



/*
EXPLANATION:

//Node class object
		Node myNode; //reference variable
		myNode = new Node("myData1"); //it is memory allocation of type Node 

		//we are directly accessing the data and next which are member of Node class
		//now it is restricted as they are private
		//System.out.println(myNode.data);
		//System.out.println(myNode.next);

		//now we can access the private members using the method()
		System.out.println(myNode.getData()); //null
		System.out.println(myNode.getNext()); //null

*/