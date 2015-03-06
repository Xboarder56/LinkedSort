package linkedlist.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Linkedlist class to store data from the nodes
 * we made before, lets the user
 * remove, add, clear, sort, size, empty
 * and insert.
 */
public class LinkedList
{
	//store a reference (pointer) to the first node in our list
	private static Node head;
	private int counter =0;
	
	public LinkedList()
	{
		// do nothing
	}
	
	public void add(Object newElement)
	{
		//case 1: our list is empty(head is null)
		if(head == null)
		{
			
			//"point"  head to a new node
			head = new Node(newElement, null);
			counter++;
		}
		else
		{
			// case 2: our list is not empty, so we need to find
			// the sat element in our list. 
			Node current = head;
			
			//the last node has a next field that is null,
			//so continue until we find that
			while(current.next != null)
			{
				//move current to our next node
				current = current.next;
				
				
				
			}
			
			//add my new node to the end of the list
			current.next = new Node(newElement, null);
			counter++;
		}
	}
	
	public int size()
	{
		System.out.println(counter);
		return counter;
	}
	
	public void isEmpty()
	{
		if(head == null)
		{
			//we could not successfully remove the searchValue
			System.out.println("The list is empty");
		}
		else
		{
			System.out.println("The list has objects in it.");
		}
	}
	
	public Object get(int index)
	{
		
		//make sure we have a valid index
		if(index < counter)
		{
			//remap the head to a node called current
			Node current = head;
			
			//loop the index for 4
			for(int i=0; i<=index; i++)
			{
				// if the index = the last loop through
				if(index == i)
				{
					// print the current data in the node.
					//System.out.println(current.data);
					return current.data;
				}
				else
				{
					//Keep passing the current to the next
					// over and over and over.
					current = current.next;
				}
			}
			return null;
		}
		else
		{
			System.out.println("The index was not found!");
			
			return null;
		}
	}
	
	public void insertAt(int index, Object newElement)
	{
		Node current = head;
		
		for(int i=0; i < index - 1; i++)
		{
			current = current.next;
		}
		
		//add my new node to the end of the list
		current.next = new Node(newElement, current.next);
	}
	
	public void printList()
	{
		//print out the data in each node of the list
		Node current = head;
		
		//continue as long aswe have a node(its's not null)
		while(current != null)
		{
			//print out the data of the current node
			System.out.println(current.data);
			
			//move to our next node!
			current = current.next;
		}
	}
	
	/**
	 *Clears the list so the user can start fresh
	 *Its also used inside the sort method when
	 *we remake the new list.
	 */
	public void clearList()
	{
		head = null;
	}
	
	/**
	 * Sorts the data by converting the linked list
	 * into a array list then loop over the nodes 
	 * added the data to the arraylist. The data is 
	 * sorted using collections.sort
	 * We clear the old linkedlist and then add it
	 *  into a linked list using the add method
	 */
	public void sort()
	{
		ArrayList<String> data = new ArrayList<String>();
		
		//print out the data in each node of the list
		Node current = head;
		
		//continue as long aswe have a node(its's not null)
		while(current != null)
		{
			data.add((String) current.data);
			
			//move to our next node!
			current = current.next;
		}
		
		 Collections.sort(data);
		 clearList();
			
		 for(int i=0; i<data.size(); i++)
		 {
			 add(data.get(i));
		 }
	}
	
	public boolean remove(Object searchValue)
	{
		//NOTICE: my return type is boolean (true - success, flase - failure)
		
		//case 1: empty list
		if(head == null)
		{
			//we could not successfully remove the searchValue
			return false;
		}
		else if(head.data.equals(searchValue))
		{
			//move head to our second node, and the first 
			// will be lost to the java machine!?!?!??!?!?
			head = head.next;
			counter--;
			return true;
		}
		else
		{
			Node current = head;
			
			
			//loop until we reach the end of our list (the seachVlaue is not found
			//pr we find the node right before the one we're removing
			while(current.next !=null && 
					!current.next.data.equals(searchValue))
			{
				current = current.next;
				
				
			}
			
			//have we found our searchValue now?
			
			// did we not found our value?
			if(current.next == null)
			{
				///we didn't find it
				return false;
			}
			else
			{
				//current is at the node before the one we're removing
				current.next = current.next.next;
				counter--;
				return true;
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	private static class Node implements Comparable
	{
		private Object data;
		private Node next; //pointer to the next node in my list
		
		public Node(Object data, Node next)
		{
			this.data = data;
			this.next = next;
		}

		@SuppressWarnings("unused")
		public Object getData()
		{
			return data;
		}

		@SuppressWarnings("unused")
		public void setData(Object data)
		{
			this.data = data;
		}

		@SuppressWarnings("unused")
		public Node getNext()
		{
			return next;
		}

		@SuppressWarnings("unused")
		public void setNext(Node next)
		{
			this.next = next;
		}
		
		@Override
		public String toString()
		{
			return "Node [data=" + data + ", next=" + next + "]";
		}
		
		/**
		 * Override section to compare nodes to other nodes
		 * taken from the comparable class.
		 */
		@Override
		public int compareTo(Object other)
		{
			Node otherNode = (Node)other;
			
			return ((Node) this.data).compareTo(otherNode);
		}
	}

}
