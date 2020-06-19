//https://www.cnblogs.com/chenssy/p/3372798.html
public class Test{
    public static void main(String[] args){
        Wine a= new JNC();
        a.fun1();
  //      a.fun2();
 //       a.fun3();

 //       JNC b= new Wine();
        JNC b= (JNC) a;
        b.fun3();

 //       Wine c= new Wine();
 //       JNC d=(JNC) c;
    }
}

class Wine{
    public void fun1(){
        System.out.println("Wine 's fun1");
        fun2();
    }
    public void fun2(){
        System.out.println("Wine 's fun2");
    }
}

class JNC extends Wine{
    public void fun1(){ //String a
        System.out.println("JNC's fun1");
        fun2();
    }
    public void fun2(){
        System.out.println("JNC's fun2");
    }
    public void fun3(){
        System.out.println("JNC's fun3");
    }
}