public class testLock{
    public static void main(String[] args){
        LockDList sl1=new LockDList();


        sl1.insertFront(new Integer(5));

        sl1.insertFront(new Integer(4));
        sl1.insertFront(new Integer(3));
        sl1.insertFront(new Integer(2));
        sl1.insertFront(new Integer(1));

        sl1.insertBack(new Integer(6));
     //   System.out.println(sl1.head.next.isLock);
        System.out.println("sl1=[1,2,3,4,5,6]? "+(sl1.toString()));
        System.out.println(sl1.head);
        System.out.println(sl1.head.next.item);

  //      LockDListNode node=sl1.front();
    //    sl1.lockNode(node);
        DListNode temp= (DListNode)sl1.front();
        sl1.lockNode(temp);
        sl1.remove(temp);
       System.out.println("try to remove the front(locked) "+(sl1.toString()));

       sl1.remove((DListNode)sl1.back());
       System.out.println("remove the last: "+sl1.toString());

//       temp= (DListNode)sl1.head.next;
        temp= (DListNode)sl1.back();


        System.out.println(temp.item);
//        sl1.unLockNode(temp);
//        sl1.remove(temp);
//        System.out.println("sl1=[2,3,4,5]? "+(sl1.toString()));

        System.out.println(((DList)sl1).head.next.item);
        System.out.println(((DList)sl1).head.item);
        System.out.println(((DList)sl1).head);

    }
}