/**
  Represent a list, implemented in a chain of Nodes
 */

public class List_inChainOfNodes{
    private Node headReference;

    public List_inChainOfNodes(){
	headReference = new Node(null);
    }
     

    /**
      @return the number of elements in this list
     */
     public int size() {
		 Node next = headReference;
		 int size = 0;
		 while (next.getReferenceToNextNode() != null){
			 size++;
			 next = next.getReferenceToNextNode();
		 }
		 return size;

     }

    
     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,] 
      */
     public String toString() {
		 Node next = headReference;
		 String ans = "[";
		 while (next.getReferenceToNextNode() != null){
			 next = next.getReferenceToNextNode();
			 ans += next.getCargo() + ",";
		 }
		 ans += "]";
		 return ans;
     }
    
    
    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean addAsHead( Object val) {
        headReference.setReferenceToNextNode(new Node(val, headReference.getReferenceToNextNode()));
		return true;
     }
}
