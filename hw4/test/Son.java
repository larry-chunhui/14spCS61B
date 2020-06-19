public class Son extends Father {
//    public int a;
//    public int b;
    public Son(int x, int y){
        super(x, y);
    }

    public int minus(){
//        return super.a-super.b;
        return this.a-this.b;
    }


    public static void main(String[] args){
        Son chunhui =new Son(20, 5);
        Father bryant= (Father) chunhui;
        System.out.println(chunhui.minus());

        System.out.println(chunhui.a+chunhui.b);
        System.out.println(chunhui.add());

        System.out.println(bryant.add());
        System.out.println(bryant.minus());
    }

}