//https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("https://www.baidu.com/");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String[] inputLine=new String[5];

	for (int i=0; i<5; i++){
		inputLine[i]=in.readLine();	
	}

	for (int i=4; i>=0; i--){
		System.out.println(inputLine[i]);	
	}
	
//        while ((inputLine = in.readLine()) != null)
//            System.out.println(inputLine);
//        in.close();
    }
}
