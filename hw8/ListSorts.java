/* ListSorts.java */

import list.*;

public class ListSorts {

  private final static int SORTSIZE = 1000;

  /**
   *  makeQueueOfQueues() makes a queue of queues, each containing one item
   *  of q.  Upon completion of this method, q is empty.
   *  @param q is a LinkedQueue of objects.
   *  @return a LinkedQueue containing LinkedQueue objects, each of which
   *    contains one object from q.
   **/
  public static LinkedQueue makeQueueOfQueues(LinkedQueue q) {
    // Replace the following line with your solution.
    LinkedQueue p= new LinkedQueue();
    try{
      while (q.size()>0){
        LinkedQueue  p1=new LinkedQueue();
        Object o = q.dequeue();
        p1.enqueue(o);
        p.enqueue((LinkedQueue)p1);
      }
    }catch(QueueEmptyException e){
      System.out.println(e);
    }

    return p;
  }

  public static void testMakeQueueOfQueues(){
    //6 4 4 7 7 3 9 2 1 4
    LinkedQueue q =new LinkedQueue();
    q.enqueue(new Integer(6));
    q.enqueue(new Integer(4));
    q.enqueue(new Integer(4));
    q.enqueue(new Integer(7));
    q.enqueue(new Integer(7));
    q.enqueue(new Integer(3));
    q.enqueue(new Integer(9));
    q.enqueue(new Integer(2));
    q.enqueue(new Integer(1));
    q.enqueue(new Integer(4));
    System.out.println(q.toString());
    LinkedQueue p=makeQueueOfQueues(q);
    //System.out.println("[ 1 2 3 4 4 4 6 7 7 9 ]");
    System.out.println(p.toString());


  }

  /**
   *  mergeSortedQueues() merges two sorted queues into a third.  On completion
   *  of this method, q1 and q2 are empty, and their items have been merged
   *  into the returned queue.
   *  @param q1 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @param q2 is LinkedQueue of Comparable objects, sorted from smallest 
   *    to largest.
   *  @return a LinkedQueue containing all the Comparable objects from q1 
   *   and q2 (and nothing else), sorted from smallest to largest.
   **/
  public static LinkedQueue mergeSortedQueues(LinkedQueue q1, LinkedQueue q2) {
    // Replace the following line with your solution.
    LinkedQueue q =new LinkedQueue();
    Comparable o1;
    Comparable o2;
    try{
      while(q1.size()>0 && q2.size()>0){
        o1=(Comparable)q1.front(); //
        o2=(Comparable)q2.front();
        if(o1.compareTo(o2)<0){
          q.enqueue( (Object) o1);
          q1.dequeue();
        }
        else if(o1.compareTo(o2)>0){
          q.enqueue((Object) o2);
          q2.dequeue();
        }
        else {
          q.enqueue((Object) o1);
          q.enqueue((Object) o2);
          q1.dequeue();
          q2.dequeue();
        }

      }

      if(q1.size()>0){
        q.append(q1);
        for(int i=0;i<q1.size();i++){
          q1.dequeue();
        }
      }
      if(q2.size()>0){
        q.append(q2);
        for(int i=0;i<q2.size();i++){
          q2.dequeue();
        }
      }

    } catch(QueueEmptyException e){
      System.out.println(e);
    }

    return q;
  }

  /**
   *  partition() partitions qIn using the pivot item.  On completion of
   *  this method, qIn is empty, and its items have been moved to qSmall,
   *  qEquals, and qLarge, according to their relationship to the pivot.
   *  @param qIn is a LinkedQueue of Comparable objects.
   *  @param pivot is a Comparable item used for partitioning.
   *  @param qSmall is a LinkedQueue, in which all items less than pivot
   *    will be enqueued.
   *  @param qEquals is a LinkedQueue, in which all items equal to the pivot
   *    will be enqueued.
   *  @param qLarge is a LinkedQueue, in which all items greater than pivot
   *    will be enqueued.  
   **/   
  public static void partition(LinkedQueue qIn, Comparable pivot, 
                               LinkedQueue qSmall, LinkedQueue qEquals, 
                               LinkedQueue qLarge) {
    // Your solution here.
    try{
      while(qIn.size()>0){  //>1 wrong
        Comparable item=(Comparable)qIn.dequeue();
        if(item.compareTo(pivot)<0){
          qSmall.enqueue((Object)item);
        }
        else if(item.compareTo(pivot)==0){
          qEquals.enqueue((Object)item);
        }
        else{
          qLarge.enqueue((Object)item);
        }
      }

    }catch(QueueEmptyException e){
      System.out.println(e);
    }

  }

  /**
   *  mergeSort() sorts q from smallest to largest using mergesort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void mergeSort(LinkedQueue q) {
    // Your solution here.
    LinkedQueue p=makeQueueOfQueues(q);
 //   System.out.println("p.toString()"+p.toString());
 //   System.out.println("q.toString()"+q.toString());
    try{
      while(p.size()>1){
        LinkedQueue p1= (LinkedQueue) p.dequeue();
        LinkedQueue p2= (LinkedQueue) p.dequeue();
        p.enqueue(mergeSortedQueues(p1, p2));
      }

      if(p.size()==1){
        q.append((LinkedQueue)p);
      }
    } catch(QueueEmptyException e){
      System.out.println(e);
    }

   // return p;
  }

  /**
   *  quickSort() sorts q from smallest to largest using quicksort.
   *  @param q is a LinkedQueue of Comparable objects.
   **/
  public static void quickSort(LinkedQueue q) {
    // Your solution here.
    if(q.size()<=1){  //==1 wrong
      return;
    }
    else{
 //     System.out.println("q.size()= "+q.size());
      //System.out.println("pivot= "+pivot);

      LinkedQueue qSmall=new LinkedQueue();
      LinkedQueue qEquals=new LinkedQueue();
      LinkedQueue qLarge=new LinkedQueue();
      int position=(int)(q.size()*Math.random())+1;
      Comparable pivot =(Comparable) q.nth(position);
//      System.out.println("q.size()= "+q.size());
 //     System.out.println("pivot= "+pivot);

      partition(q, pivot, qSmall,  qEquals, qLarge);
      quickSort(qSmall);
      quickSort(qLarge);
      q.append(qSmall);
      q.append(qEquals);
      q.append(qLarge);
    }

  }

  /**
   *  makeRandom() builds a LinkedQueue of the indicated size containing
   *  Integer items.  The items are randomly chosen between 0 and size - 1.
   *  @param size is the size of the resulting LinkedQueue.
   **/
  public static LinkedQueue makeRandom(int size) {
    LinkedQueue q = new LinkedQueue();
    for (int i = 0; i < size; i++) {
      q.enqueue(new Integer((int) (size * Math.random())));
    }
    return q;
  }

  public static void testMergeSort(){
    //6 4 4 7 7 3 9 2 1 4
    LinkedQueue q =new LinkedQueue();
    q.enqueue(new Integer(6));
    q.enqueue(new Integer(4));
    q.enqueue(new Integer(4));
    q.enqueue(new Integer(7));
    q.enqueue(new Integer(7));
    q.enqueue(new Integer(3));
    q.enqueue(new Integer(9));
    q.enqueue(new Integer(2));
    q.enqueue(new Integer(1));
    q.enqueue(new Integer(4));
    System.out.println(q.toString());
    mergeSort(q);
    System.out.println("exact solution: [ 1 2 3 4 4 4 6 7 7 9 ]");
    System.out.println(q.toString());


  }

  public static void testQuickSort(){
    //6 4 4 7 7 3 9 2 1 4
    LinkedQueue q =new LinkedQueue();
    q.enqueue(new Integer(6));
    q.enqueue(new Integer(4));
    q.enqueue(new Integer(4));
    q.enqueue(new Integer(7));
    q.enqueue(new Integer(7));
    q.enqueue(new Integer(3));
    q.enqueue(new Integer(9));
    q.enqueue(new Integer(2));
    q.enqueue(new Integer(1));
    q.enqueue(new Integer(4));
    System.out.println(q.toString());
    quickSort(q);
    System.out.println("exact solution should be: ");
    System.out.println("[ 1 2 3 4 4 4 6 7 7 9 ]");
    System.out.println(q.toString());
  }
  /**
   *  main() performs some tests on mergesort and quicksort.  Feel free to add
   *  more tests of your own to make sure your algorithms works on boundary
   *  cases.  Your test code will not be graded.
   **/
  public static void main(String [] args) {

   // testMakeQueueOfQueues();
   // testMergeSort();
   // System.exit(0);

//    testQuickSort();
//    System.exit(0);

    LinkedQueue q = makeRandom(10);
    System.out.println(q.toString());
    mergeSort(q);
    System.out.println(q.toString());

    q = makeRandom(10);
    System.out.println(q.toString());
    quickSort(q);
    System.out.println(q.toString());
 //   System.exit(0);

    /* Remove these comments for Part III. */
    for(int i=100; i<10000000;i=i*10){
      int size=i;
      Timer stopWatch = new Timer();
      q = makeRandom(size);
      stopWatch.start();
      mergeSort(q);
      stopWatch.stop();
      System.out.println("Mergesort time, " + size + " Integers:  " +
              stopWatch.elapsed() + " msec.");

      stopWatch.reset();
      q = makeRandom(size);
      stopWatch.start();
      quickSort(q);
      stopWatch.stop();
      System.out.println("Quicksort time, " + size + " Integers:  " +
              stopWatch.elapsed() + " msec.");

    }


  }

}
