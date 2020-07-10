public class test{
    public int solve(String s, int a, int b){
        if(s=="add"){return a+b;}
        else {return a*b;}
    }

    public static void main(String [] args){
        int a=3;
        int b=4;
        test kobe=new test();
        int c=kobe.solve("add", a,b);
        System.out.println("c= "+c);

    }
}