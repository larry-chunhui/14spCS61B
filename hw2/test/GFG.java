public class GFG { 
    public static void main(String args[]) 
    { 
        String str = "geekss@for@geekss@kobe@bryant"; 
        String[] arrOfStr = str.split("@",-1); 
  
        for (String a : arrOfStr) 
            System.out.println(a); 
	// System.out.println(arrOfStr[0]);
    } 
} 
