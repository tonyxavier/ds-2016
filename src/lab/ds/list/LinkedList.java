package lab.ds.list;

public class LinkedList
{

private Node head=null;
private int size=0;




private class Node
{
	
	private int data;
	
	private Node next;
	
	
	private void visit()
	{
		
		System.out.println(data);
		
	}
	
	
	
}
	

public void addToEnd(Object data)
{
	if(head==null)
	{
		
	}
	
	
}


public void insert(int i,Object data)  //insert at a new node as ith element
{
	
	
	
}



public Object get(int i)
{
	
	return new Object();
}


public boolean remove(int data)
{
		
	if(head==null)
	{
		return false;
	}
	
	if(head.data==data)
	{
		head=head.next;
		size--;
		return true;
		
	}
	
	Node current=head.next;
	Node prev=head;
	while(current!=null)
	{		    
	if(current.data==data)
	{
		prev.next=current.next;		
		size--;
		return true;
		
	}
	prev=current;
	current=current.next;
	}
	
	return false;
	
}


public void add(int data) //insert an element at the beginning of the linked list
{
	
	if(head==null)
	{
		head=new Node();
		head.data=data;
		size++;
	}
	else
	{
	  Node newnode=new Node();
	  newnode.data=data;
	  newnode.next=head;
	  head=newnode;
	  size++;
	  
	}
	
}



public void traverse()
{
	
	Node temp=head;
	
	if (temp==null)
	{
		System.out.println("Empty List");
		return; 
	}
	while(temp.next!=null)
	{
		temp.visit();
		temp=temp.next;
		
	}
	temp.visit();
	
}


public void reverse()
{
	
	Node left=null,current=head,right=null;
	
	while(current!=null)
	{
	   right=current.next;
	   current.next=left;
	   left=current;
	   current=right;	  
	}
	
	
	this.head=left;
   
	
}


public int size()
{
	
	return size;
	
}

public int nthFromLast(int n)
{
	
	if(n>size || n<1 || head==null)
		return Integer.MIN_VALUE;
		
	
	
	Node p1=head,p2=head;
	
	
	int m=0;
	boolean started=false;
	
	while(p1!=null)
	{
		m++;
		
	   if(m==n+1)
	   {
		   started=true;
	   }
		   
	   if(started)
		   p2=p2.next;
		
		
		p1=p1.next;
		
	}
	
	return p2.data;
	
	
	
}

	
public static void main(String args[])
{
	
	
	LinkedList tester=new LinkedList();
	
	tester.add(1);
	tester.add(2);
	tester.add(3);
	tester.add(4);
	
	tester.traverse();	
	
	
	System.out.println("");	
	
	
	
	tester.reverse();	
	System.out.println("");	
	tester.traverse();
	System.out.println("");	
	tester.reverse();	
	tester.traverse();

	
	
	//tester.remove("Third");
	//tester.traverse();
	
		
	
}
	
	

}
