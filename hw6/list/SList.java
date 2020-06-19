/* SList.java */
package list;

/**
 *  The SList class is a singly-linked implementation of the linked list
 *  abstraction.  SLists are mutable data structures, which can grow at either
 *  end.
 *
 *  @author Kathy Yelick and Jonathan Shewchuk
 **/

public class SList {

  private SListNode head;
  private int size;

  /**
   *  SList() constructs an empty list.
   **/

  public SList() {
    size = 0;
    head = null;
  }

  /**
   *  isEmpty() indicates whether the list is empty.
   *  @return true if the list is empty, false otherwise.
   **/

  public boolean isEmpty() {
    return size == 0;
  }

  /**
   *  length() returns the length of this list.
   *  @return the length of this list.
   **/

  public int length() {
    return size;
  }

  /**
   *  insertFront() inserts item "obj" at the beginning of this list.
   *  @param obj the item to be inserted.
   **/

  public void insertFront(Object obj) {
    head = new SListNode(obj, head);
    size++;
  }

  /**
   *  insertEnd() inserts item "obj" at the end of this list.
   *  @param obj the item to be inserted.
   **/

  public void insertEnd(Object obj) {
    if (head == null) {
      head = new SListNode(obj);
    } else {
      SListNode node = head;
      while (node.next != null) {
        node = node.next;
      }
      node.next = new SListNode(obj);
    }
    size++;
  }
  
  public void remove(int position){
	  if(position <= size){
		  SListNode node = head;
		  if(position == 1){
			  head = head.next;
		  }else if(position == 2){
			  node.next = node.next.next;
		  }else{
			  for(int i=1; i<= position-2; i++){
				  node = node.next;
			  }
			  node.next = node.next.next;
		  }
		  size--;
		  
	  }
  }
  
  public Object front(){
	  if(size == 0) return null;
	  return head;
  }


  /**
   *  toString() converts the list to a String.
   *  @return a String representation of the list.
   **/

  public String toString() {
//    int i;
    Object obj;
    String result = "[  ";

    SListNode cur = head;

    while (cur != null) {
      obj = cur.item;
      result = result + obj.toString() + "  ";
      cur = cur.next;
    }
    result = result + "]";
    return result;
  }

    public static void main(String[] args){
        SList sl1=new SList();
        sl1.insertEnd(new Integer(6));
//        sl1.insertEnd(new Integer(9));
//        sl1.insertEnd(new Integer(12));
//        sl1.insertEnd(new String("chunhui"));
        System.out.println("Here is a list after insertBack 6, 9, 12, chunhui : "
                + sl1.toString());
//        sl1.remove(2);
//        sl1.remove(2);
//        sl1.remove(2);
        sl1.remove(1);
        // sl1.insertEnd(new double((double) 12.5));
        System.out.println("Here is a list after insertBack 6, 9, 12: "
                + sl1.toString());
        //   System.out.println(sl1.head.item);
    }

}
