public class testDListChunhui{
    public static void main(String[] args){
        DList sl1=new DList();
        System.out.println("sl1 is empty? " +(sl1.isEmpty()==true));
        System.out.println("sl1 's size equals 0? "+(sl1.length()==0));
        System.out.println("sl1's head.item equals null? "+(sl1.head.item==null));
        System.out.println("sl1's head ? "+sl1.head);

        System.out.println("sl1's is a empty cycling double linked list? "+(sl1.head.next==sl1.head && sl1.head.prev==sl1.head));

        sl1.insertFront(new Integer(5));
        System.out.println("sl1 ="+sl1.toString());
//        System.out.println("sl1 = [  5  ]? "+(sl1.toString()=="[  5  ]"));
        System.out.println("sl1 = [  5  ]? "+(sl1.toString().equals("[  5  ]")));

        sl1.insertFront(new Integer(4));
        sl1.insertFront(new Integer(3));
        sl1.insertFront(new Integer(2));
        sl1.insertFront(new Integer(1));
        sl1.insertBack(new Integer(6));
        System.out.println("sl1=[1,2,3,4,5,6]? "+(sl1.toString()));

        System.out.println("sl1 's size equals 6? "+(sl1.length()==6));
        System.out.println("sl1's first node equals 1? "+(sl1.head.next.item==(new Integer(1))));
        System.out.println("sl1's first node equals 1? "+(sl1.head.next.item.equals(new Integer(1))));
        System.out.println("sl1's first node equals 1? "+(sl1.front().item));
        System.out.println("sl1's last node equals 6? "+(sl1.back().item));

        Integer c=0;
        int d=0;
        c= (Integer) sl1.front().item;
        d=(int) sl1.front().item;
        System.out.println("c= "+c);
        System.out.println("d= "+d);

        System.out.println("sl1 sum= "+ sl1.toSum());
        sl1.equalTest();


    }
}