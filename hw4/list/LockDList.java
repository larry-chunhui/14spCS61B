public class LockDList extends DList{
//    protected LockDListNode head;
    protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
        return  new LockDListNode(item, prev, next);
    }

    public LockDListNode front() {
        return (LockDListNode) super.front();
    }

    public LockDListNode back() {
        return (LockDListNode) super.back();
    }

    public LockDListNode next(DListNode node) {
        return (LockDListNode) super.next(node);
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