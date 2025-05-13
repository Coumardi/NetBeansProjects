import java.util.Iterator; 
import java.util.LinkedList; 
import java.util.List; 


public class Iteriator { 
    
    public void myIterator(){
	 
		// create a list 
		List<String> list = new LinkedList<>(); 
		list.add("Welcome"); 
		list.add("to"); 
		list.add("GFG"); 

		System.out.println("The list is given as : "
						+ list); 
			
		// get the iterator on the list 
		Iterator<String> itr = list.iterator(); 

		// Returns true if there are more number of 
		// elements. 
		while (itr.hasNext()) { 
			// Returns the next element. 
			System.out.println(itr.next()); 
		} 

		// Removes the last element. 
		itr.remove(); 
		System.out.println( 
			"After the remove() method is called : "
			+ list); 
	} 
}
