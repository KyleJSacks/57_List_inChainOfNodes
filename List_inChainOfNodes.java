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
	 
	 public Node set(int index, Object val){
		 Node next = headReference;
		 while (index > 1){
			 next = next.getReferenceToNextNode();
			 index--;
		 }
		 Node ret = next.getReferenceToNextNode();
		 next.setReferenceToNextNode(new Node(val, (next.getReferenceToNextNode()).getReferenceToNextNode()));
		 return ret;
	 }
	 
	 public Node getNode(int index){
		 Node next = headReference;
		 while (index > 1){
			 next = next.getReferenceToNextNode();
			 index--;
		 }
		 return next.getReferenceToNextNode();
		 /*For loop code:
		 Node next = headReference;
		 int ind = 0;
		 for(ind, next;
			 ind < index;
			 index++, next = next.getReferenceToNextNode();
			)
		 return next;
		 */
	 }

	 public Object get(int index){
		 return this.getNode(index).getReferenceToNextNode().getCargo();
	 }
	 
	 public boolean add(int index, Object val){
		 if(index == 0) addAsHead(val);
		 else{
		 Node start = this.getNode(index);
		 start.setReferenceToNextNode(new Node(val, (start.getReferenceToNextNode())));
  		 }
		 return true;
	 }
			 
	 public Node remove(int index){
		 Node ret = null;
		 if(index == 0) {
			ret = headReference.getReferenceToNextNode();
			headReference.setReferenceToNextNode(this.getNode(2));
			return ret;
		 }
		 else{
		 Node start = this.getNode(index);
		 ret = start.getReferenceToNextNode();
		 start.setReferenceToNextNode(start.getReferenceToNextNode().getReferenceToNextNode());
		 }
		 return ret;
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
