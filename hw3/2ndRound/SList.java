/* SList.java */

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
    if(head==null){
      head= new SListNode(obj, null);
    }
    else{
      SListNode insert= new SListNode(obj, head);
      head = insert;
    }
    size++;

  }

  /**
   *  insertEnd() inserts item "obj" at the end of this list.
   *  @param obj the item to be inserted.
   **/

  public void insertEnd(Object obj) {
 //   if(head==null){
    if(size==0){
      head= new SListNode(obj, null);
    }
    else {
      SListNode tail=head;
      while(tail.next!=null){
        tail=tail.next;
      }
      tail.next=new SListNode(obj, null);
    }

    size++;

  }

  /**
   *  nth() returns the item at the specified position.  If position < 1 or
   *  position > this.length(), null is returned.  Otherwise, the item at
   *  position "position" is returned.  The list does not change.
   *  @param position the desired position, from 1 to length(), in the list.
   *  @return the item at the given position in the list.
   **/

  public Object nth(int position) {
    if(position<1 || position > this.length()){
      return null;
    }
    else{
      SListNode cur=head;
      int i=1;
      while(i<position){
        cur=cur.next;
        i++;
      }
      return cur.item;

    }

  }

  /**
   *  squish() takes this list and, wherever two or more consecutive items are
   *  equals(), it removes duplicate nodes so that only one consecutive copy
   *  remains.  Hence, no two consecutive items in this list are equals() upon
   *  completion of the procedure.
   *
   *  After squish() executes, the list may well be shorter than when squish()
   *  began.  No extra items are added to make up for those removed.
   *
   *  For example, if the input list is [ 0 0 0 0 1 1 0 0 0 3 3 3 1 1 0 ], the
   *  output list is [ 0 1 0 3 1 0 ].
   *
   *  IMPORTANT:  Be sure you use the equals() method, and not the "=="
   *  operator, to compare items.
   **/

  public void squish() {

    // Fill in your solution here.  (Ours is eleven lines long.)
    for(SListNode cur=head; cur!=null; cur=cur.next){
      while(cur.next!=null && cur.next.item.equals(cur.item)){
        cur.next=cur.next.next;
      }
    }
  }

  /**
   *  twin() takes this list and doubles its length by replacing each node
   *  with two consecutive nodes referencing the same item.
   *
   *  For example, if the input list is [ 3 7 4 2 2 ], the
   *  output list is [ 3 3 7 7 4 4 2 2 2 2 ].
   *
   *  IMPORTANT:  Do not try to make new copies of the items themselves.
   *  Make new SListNodes, but just copy the references to the items.
   **/

  public void twin() {
    // Fill in your solution here.  (Ours is seven lines long.)
    for(SListNode cur=head; cur!=null;cur=cur.next.next){
      SListNode insert=new SListNode(cur.item, cur.next);
      cur.next=insert;
    }
  }

  /**
   *  toString() converts the list to a String.
   *  @return a String representation of the list.
   **/

  public String toString() {
    String temp="[";
    for(SListNode cur=head; cur!=null; cur=cur.next) {
      temp=temp+cur.item+" ";
    }
    temp=temp+"]";
    return temp;
  }


  /**
   *  main() runs test cases on the SList class.  Prints summary
   *  information on basic operations and halts with an error (and a stack
   *  trace) if any of the tests fail.
   **/

  public static void main (String[] args) {
    testInsertFront();
    testToString();
    testInsertEnd();
    testSquish();
    testTwin();
    testNth();
//    testEmpty();
//    testAfterInsertFront();
 //   testAfterInsertEnd();
  }

  private static void testInsertFront(){
    SList lst1=new SList();
    lst1.insertFront(new Integer(1));
    lst1.insertFront(new Integer(2));
    System.out.println(lst1.head+" "+" "+lst1.head.next);
    System.out.println(lst1.head.item+" "+" "+lst1.head.next.item);
  }

  private static void testToString(){
    SList lst1=new SList();
    for (int i=4; i>=0; i--){
      lst1.insertFront(new Integer(i));
    }
    System.out.println("lst1= "+ lst1.toString());
    System.out.println("test toString() correct? "+(lst1.toString().equals("[0 1 2 3 4 ]")));
  }

  private static void testInsertEnd(){
    SList lst1=new SList();
    for (int i=0; i<=4; i++){
      lst1.insertEnd(new Integer(i));
    }
    System.out.println("lst1= "+ lst1.toString());
    System.out.println("test toString() correct? "+(lst1.toString().equals("[0 1 2 3 4 ]")));


  }

  private static void testSquish(){
    SList lst1=new SList();
    for (int i=0; i<=4; i++){
      lst1.insertEnd(new Integer(i));
      lst1.insertEnd(new Integer(i));
    }
    lst1.insertEnd(new Integer(5));
    System.out.println("lst1= "+ lst1.toString());
    lst1.squish();
    System.out.println("lst1= "+ lst1.toString());
    System.out.println("test toString() correct? "+(lst1.toString().equals("[0 1 2 3 4 5 ]")));
  }

  private static void testTwin(){
    SList lst1=new SList();
    for (int i=0; i<=4; i++){
      lst1.insertEnd(new Integer(i));
      lst1.insertEnd(new Integer(i));
    }
    lst1.insertEnd(new Integer(5));
    System.out.println("lst1= "+ lst1.toString());
    lst1.squish();
    System.out.println("lst1= "+ lst1.toString());
    lst1.twin();
    System.out.println("test toString() correct? "+(lst1.toString().equals("[0 0 1 1 2 2 3 3 4 4 5 5 ]")));

  }

  private static void testNth(){
    SList lst1=new SList();
    SList lst2=new SList();

    for (int i=0; i<=4; i++){
      lst1.insertEnd(new Integer(i));
      lst2.insertEnd(lst1.nth(i+1));
    }
    System.out.println("lst2= "+lst2.toString());
    System.out.println("test toString() correct? "+(lst2.toString().equals("[0 1 2 3 4 ]")));
    System.out.println("lst1==lst2? "+(lst1.toString().equals(lst2.toString())));
  }

  /**
   *  testEmpty() tests toString(), isEmpty(), length(), insertFront(), and
   *  insertEnd() on an empty list.  Prints summary information of the tests
   *  and halts the program if errors are detected.
   **/

  private static void testEmpty() {
    SList lst1 = new SList();
    SList lst2 = new SList();
    System.out.println();
    System.out.println("Here is a list after construction: "
		       + lst1.toString());
    TestHelper.verify(lst1.toString().equals("[  ]"),
		      "toString on newly constructed list failed");

    System.out.println("isEmpty() should be true. It is: " +
		       lst1.isEmpty());
    TestHelper.verify(lst1.isEmpty() == true,
		      "isEmpty() on newly constructed list failed");    

    System.out.println("length() should be 0. It is: " +
		       lst1.length());
    TestHelper.verify(lst1.length() == 0, 
		      "length on newly constructed list failed");    
    lst1.insertFront(new Integer(3));
    System.out.println("Here is a list after insertFront(3) to an empty list: "
		       + lst1.toString());
    TestHelper.verify(lst1.toString().equals("[  3  ]"),
		      "InsertFront on empty list failed");
    lst2.insertEnd(new Integer(5));
    System.out.println("Here is a list after insertEnd(5) on an empty list: "
		       + lst2.toString());
    TestHelper.verify(lst2.toString().equals("[  5  ]"),
		      "insertEnd on empty list failed");
  }

  /**
   *  testAfterInsertFront() tests toString(), isEmpty(), length(),
   *  insertFront(), and insertEnd() after insertFront().  Prints summary
   *  information of the tests and halts the program if errors are detected.
   **/

  private static void testAfterInsertFront() {
    SList lst1 = new SList();
    lst1.insertFront(new Integer(3));
    lst1.insertFront(new Integer(2));
    lst1.insertFront(new Integer(1));
    System.out.println();
    System.out.println("Here is a list after insertFront 3, 2, 1: "
		       + lst1.toString());
    TestHelper.verify(lst1.toString().equals("[  1  2  3  ]"),
		      "InsertFronts on non-empty list failed");
    System.out.println("isEmpty() should be false. It is: " +
		       lst1.isEmpty());
    TestHelper.verify(lst1.isEmpty() == false,
		      "isEmpty() after insertFront failed");    
    System.out.println("length() should be 3. It is: " +
		       lst1.length());
    TestHelper.verify(lst1.length() == 3, 
		      "length() after insertFront failed");
    lst1.insertEnd(new Integer(4));
    System.out.println("Here is the same list after insertEnd(4): "
		       + lst1.toString());
    TestHelper.verify(lst1.toString().equals("[  1  2  3  4  ]"),
		      "insertEnd on non-empty list failed");
  }
    
  /**
   *  testAfterInsertEnd() tests toString(), isEmpty(), length(),
   *  insertFront(), and insertEnd() after insertEnd().  Prints summary
   *  information of the tests and halts the program if errors are detected.
   **/

  private static void testAfterInsertEnd() {
    SList lst1 = new SList();
    lst1.insertEnd(new Integer(6));
    lst1.insertEnd(new Integer(7));
    System.out.println();
    System.out.println("Here is a list after insertEnd 6, 7: "
		       + lst1.toString());
    System.out.println("isEmpty() should be false. It is: " +
		       lst1.isEmpty());
    TestHelper.verify(lst1.isEmpty() == false,
		      "isEmpty() after insertEnd failed");    
    System.out.println("length() should be 2. It is: " +
		       lst1.length());
    TestHelper.verify(lst1.length() == 2, 
		      "length() after insertEndfailed");
    lst1.insertFront(new Integer(5));
    System.out.println("Here is the same list after insertFront(5): "
		       + lst1.toString());
    TestHelper.verify(lst1.toString().equals("[  5  6  7  ]"),
		      "insertFront after insertEnd failed");
  }
}
