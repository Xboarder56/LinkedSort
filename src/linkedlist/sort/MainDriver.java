package linkedlist.sort;

public class MainDriver
{

	public static void main(String[] args)
	{
		LinkedList data = new LinkedList();
		data.add("Washington");
		data.add("New York");
		data.add("Texas");
		data.add("Idaho");
		data.add("Nevada");
    	data.printList();

    	System.out.println();
		System.out.println("Sorting Section:");
    	data.sort();
    	data.printList();
	}

}
