public class LockDList extends DList{
   protected LockDListNode head;
    protected LockDListNode newNode(Object item, LockDListNode prev, LockDListNode next) {
        return  new LockDListNode(item, prev, next);
    }

    public LockDList() {
        //  Your solution here.
        head=newNode(null, null, null);
        head.next=head;
        head.prev=head;
        size=0;
    }

    public LockDListNode front() {
        return (LockDListNode) super.front();
    }

    public LockDListNode back() {
        return (LockDListNode) super.back();
    }

    public LockDListNode next(LockDListNode node) {
        return (LockDListNode) super.next((DListNode)node);
    }

    public LockDListNode prev(DListNode node) {
        return (LockDListNode) super.prev(node);
    }

    public void lockNode(DListNode node){
        ((LockDListNode)node).isLock=true;
    }

    public void unLockNode(DListNode node){
        ((LockDListNode)node).isLock=false;
    }

    public void remove(DListNode node) {
        if(  ((LockDListNode)node).isLock!=true){
            super.remove(node);
        }
    }

}