public class LockDListNode extends DListNode{
public boolean isLock;
    LockDListNode(Object i, DListNode p, DListNode n) {
        super(i, p, n);
        isLock=false;
    }
}