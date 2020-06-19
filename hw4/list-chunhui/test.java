public class test{
    public int item;

    public test(int item){
        this.item=item;
    }

    public boolean compare(){
        if(item>=0){
            return true;
        }
        else return false;
    }

    public static void main(String[] args){
        int i=100;
        for (i=-10; i<=10;i++) {
            test Test = new test(i);
            System.out.println("i= " + i + ">= 0 is " + Test.compare());
        }
    }
}