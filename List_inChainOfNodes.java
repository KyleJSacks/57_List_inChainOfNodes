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
	 
	 public boolean set(int index, Object val){
		 Node next = headReference;
		 while (index > 1){
			 next = next.getReferenceToNextNode();
			 index--;
		 }
		 next.setReferenceToNextNode(new Node(val, (next.getReferenceToNextNode()).getReferenceToNextNode()));
		 return true;
	 }
	 
	 public Node get(int index){
		 Node next = headReference;
		 while (index > 1){
			 next = next.getReferenceToNextNode();
			 index--;
		 }
		 return next.getReferenceToNextNode();
	 }
	 
	 public boolean add(int index, Object val){
		 Node start = this.get(index - 1);
		 start.setReferenceToNextNode(new Node(val, (start.getReferenceToNextNode())));
		 return true;
	 }
			 
	 public boolean remove(int index){
		 Node start = this.get(index - 1);
		 start.setReferenceToNextNode(start.getReferenceToNextNode().getReferenceToNextNode());
		 return true;
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
