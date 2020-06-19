/* Set.java */

import list.*;

/**
 *  A Set is a collection of Comparable elements stored in sorted order.
 *  Duplicate elements are not permitted in a Set.
 **/
public class Set {
  /* Fill in the data fields here. */
  List setList;

  /**
   * Set ADT invariants:
   *  1)  The Set's elements must be precisely the elements of the List.
   *  2)  The List must always contain Comparable elements, and those elements 
   *      must always be sorted in ascending order.
   *  3)  No two elements in the List may be equal according to compareTo().
   **/

  /**
   *  Constructs an empty Set. 
   *
   *  Performance:  runs in O(1) time.
   **/
  public Set() { 
    // Your solution here.
    setList= new DList();
  }

  /**
   *  cardinality() returns the number of elements in this Set.
   *
   *  Performance:  runs in O(1) time.
   **/
  public int cardinality() {
    // Replace the following line with your solution.
    return setList.length();
    // return setList.length();
  }

  /**
   *  insert() inserts a Comparable element into this Set.
   *
   *  Sets are maintained in sorted order.  The ordering is specified by the
   *  compareTo() method of the java.lang.Comparable interface.
   *
   *  Performance:  runs in O(this.cardinality()) time.
   **/
  public void insert(Comparable c) {
    // Your solution here.
    if(setList.isEmpty()){
      setList.insertFront(c);
//      try {
//        System.out.println("size should =1?"+(setList.length()==1));
//        System.out.println("first item = "+(setList.front().item()));
//      } catch(InvalidNodeException e){
//        System.out.println("insert failed"+e);
//      }
    }
    else{
      try {
        ListNode cur = setList.front();
        while (cur != setList.back() && ((Comparable) cur.item()).compareTo(c) < 0) {
          cur = cur.next();
        }
 //       System.out.println("*****"+((Comparable) cur.item()).compareTo(c)+cur.next());
        if (((Comparable) cur.item()).compareTo(c) > 0) {
          cur.insertBefore(c);
        } else if (((Comparable) cur.item()).compareTo(c) < 0 && cur == setList.back()) {
          cur.insertAfter(c);
        }
      } catch(InvalidNodeException e){
        System.out.println("insert failed"+e);
      }

    }

  }

  /**
   *  union() modifies this Set so that it contains all the elements it
   *  started with, plus all the elements of s.  The Set s is NOT modified.
   *  Make sure that duplicate elements are not created.
   *
   *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
   *
   *  Your implementation should NOT copy elements of s or "this", though it
   *  will copy _references_ to the elements of s.  Your implementation will
   *  create new _nodes_ for the elements of s that are added to "this", but
   *  you should reuse the nodes that are already part of "this".
   *
   *  DO NOT MODIFY THE SET s.
   *  DO NOT ATTEMPT TO COPY ELEMENTS; just copy _references_ to them.
   **/
  public void union(Set s) {
    // Your solution here.
    ListNode cNode = setList.front();
    ListNode sNode = s.setList.front();
    try {
      while (cNode.isValidNode() && sNode.isValidNode()) {
        Comparable cItem = (Comparable) cNode.item();
        Comparable sItem = (Comparable) sNode.item();
 //       System.out.println("test if while is over "+cNode.item()+" "+sNode.item());

        if (sItem.compareTo(cItem) == 0) {
          cNode = cNode.next();
          sNode = sNode.next();
        } else if (sItem.compareTo(cItem) < 0) {
          cNode.insertBefore(sNode.item());
          sNode = sNode.next();
        } else {
          cNode = cNode.next();
        }
      }

      while(sNode.isValidNode()){
 //       cNode.prev().insertAfter(sNode.item());
        setList.insertBack(sNode.item());
        sNode=sNode.next();
      }

    }catch(InvalidNodeException e){
      System.out.println("union error "+e);
    }


//      ListNode curNode = setList.front();
//      ListNode sNode = s.setList.front();
//   //   Comparable curItem, sItem;
//      try{
//
//        while(curNode.isValidNode() && sNode.isValidNode()){
//          Comparable curItem = (Comparable)curNode.item();
//          Comparable sItem = (Comparable)sNode.item();
//          if(curItem.compareTo(sItem) == 0){
//            curNode = curNode.next();
//            sNode = sNode.next();
//          }else if(curItem.compareTo(sItem) < 0){
//            curNode = curNode.next();
//          }else{
//            curNode.insertBefore(sItem);
//            sNode = sNode.next();
//          }
//        }
//
//        while(sNode.isValidNode()){
//          sItem = (Comparable)sNode.item();
//          setList.insertBack(sItem);
//          sNode = sNode.next();
//        }
//
//      }catch(InvalidNodeException e){
//        System.err.println("union() failed");
//      }

  }

  /**
   *  intersect() modifies this Set so that it contains the intersection of
   *  its own elements and the elements of s.  The Set s is NOT modified.
   *
   *  Performance:  Must run in O(this.cardinality() + s.cardinality()) time.
   *
   *  Do not construct any new ListNodes during the execution of intersect.
   *  Reuse the nodes of "this" that will be in the intersection.
   *
   *  DO NOT MODIFY THE SET s.
   *  DO NOT CONSTRUCT ANY NEW NODES.
   *  DO NOT ATTEMPT TO COPY ELEMENTS.
   **/
  public void intersect(Set s) {
    // Your solution here.
    ListNode cNode = setList.front();
    ListNode sNode = s.setList.front();
    try {
      while (cNode.isValidNode() && sNode.isValidNode()) {
        Comparable cItem = (Comparable) cNode.item();
        Comparable sItem = (Comparable) sNode.item();
      //  System.out.println("test if while is over "+cNode.item()+" "+sNode.item());

        if (sItem.compareTo(cItem) == 0) {
          cNode = cNode.next();
          sNode = sNode.next();
        } else if (sItem.compareTo(cItem) < 0) {
         // cNode.insertBefore(sNode.item());
          sNode = sNode.next();
        } else {
//          System.out.println(cNode.item());
          if(cNode!=setList.back()){
            cNode = cNode.next();
            cNode.prev().remove();
          }
          else{
            cNode.remove();
          }

//          cNode.prev()=cNode.prev().prev();
//          cNode.prev().next()=cNode;
        }
      }

//      while(sNode.isValidNode()){
//        //       cNode.prev().insertAfter(sNode.item());
//        setList.insertBack(sNode.item());
//        sNode=sNode.next();
//      }

    }catch(InvalidNodeException e){
      System.out.println("intersect "+e);
    }
  }

  /**
   *  toString() returns a String representation of this Set.  The String must
   *  have the following format:
   *    {  } for an empty Set.  No spaces before "{" or after "}"; two spaces
   *            between them.
   *    {  1  2  3  } for a Set of three Integer elements.  No spaces before
   *            "{" or after "}"; two spaces before and after each element.
   *            Elements are printed with their own toString method, whatever
   *            that may be.  The elements must appear in sorted order, from
   *            lowest to highest according to the compareTo() method.
   *
   *  WARNING:  THE AUTOGRADER EXPECTS YOU TO PRINT SETS IN _EXACTLY_ THIS
   *            FORMAT, RIGHT UP TO THE TWO SPACES BETWEEN ELEMENTS.  ANY
   *            DEVIATIONS WILL LOSE POINTS.
   **/
  public String toString() {
    // Replace the following line with your solution.
    String p="{ ";
    try {
      for (ListNode cur = setList.front(); cur.isValidNode(); cur = cur.next()) {
        p = p + cur.item() + " ";
      }
    }catch (InvalidNodeException e){
      System.out.println("set toString failed: "+ e);
    }
    p=p+" }";
    return p;
  }

  public static void main(String[] argv) {
    Set s = new Set();
//    System.out.println(" cardinality of s=0? "+(s.cardinality()==0));

    s.insert(new Integer(3));
//    System.out.println("Set s = " + s);
//    System.out.println("cardinality of s= "+s.cardinality());

    s.insert(new Integer(4));
    s.insert(new Integer(3));
    System.out.println("Set s =[3 4] " + s);


    Set s2 = new Set();
    s2.insert(new Integer(4));
    s2.insert(new Integer(5));
    s2.insert(new Integer(5));
    s2.insert(new Integer(6));
    System.out.println("Set s2 = {4 5 6}" + s2);

    Set s3 = new Set();
    s3.insert(new Integer(5));
    s3.insert(new Integer(3));
    s3.insert(new Integer(8));
    System.out.println("Set s3 = " + s3);


    s.union(s2);
    System.out.println("After s.union(s2), s ={3 4 5 6} " + s);

//    Set s4 = new Set();
//    s4.insert(new Integer(1));
//    s4.insert(new Integer(2));
//    try{
//      System.out.println(s4.setList.front().item()+" "+s4.setList.front().next().item()+" "+s4.setList.front().next().next().next().item());
//    } catch (InvalidNodeException e){
//      System.out.println("test failed: "+ e);
//    }

    s.intersect(s3);
    System.out.println("After s.intersect(s3), s = " + s);

    System.out.println("s.cardinality() = " + s.cardinality());
    // You may want to add more (ungraded) test code here.



  }
}
