public class ListNode {

//    public ListNode head;
    public ListNode next;
    public Object item;



    public  ListNode(Object item, ListNode next){
        this.item=item;
        this.next=next;
    }

    public void insertFront(Object item){

    }

    public String toString(){
        String p="[ ";
        ListNode cur=this;
        while (cur!=null){
            p=p+cur.item+" ";
            cur=cur.next;
        }
        p=p+" ]";
        return p;
    }


    public static void main(String[] args) {

        ListNode a=new ListNode((Integer)2, null);
        a=new ListNode((Integer) 3, a);
        a=new ListNode((Integer) 4, a);

        ListNode head=a;
        System.out.println(head);
        System.out.println(a);

        head.next=head.next.next;
        //head=head.next;
        System.out.println(head);
        System.out.println(a);

        head=null;
        System.out.println(head);
        System.out.println(a);
    }
}

