import java.io.*;
class Nuke2{
	public static void main(String[] args) throws Exception{
		System.out.println("type a string");
		BufferedReader keybd= new BufferedReader(new InputStreamReader(System.in));
		String c=keybd.readLine();
		// String d=c.substring(0,1)+c.substring(2, c.length());
		String d = c.charAt(0)+c.substring(2);
		// String e=;
		System.out.println(d);
		
	}
}
