public class HelloWorldApp 
{ 	
	public static void main(String[] args) { 
		int month;
		int day;
		int year;
		//String CSV = "Google,Apple,Microsoft"; 
		String CSV="10/20/1990";
		String[] values = CSV.split("/",0); 
		for(String a : values)
			System.out.println(a); 
		month=Integer.parseInt(values[0]);
		day=Integer.parseInt(values[1]);
		year=Integer.parseInt(values[2]);

		System.out.println(month+"/"+day+"/"+year);
	} 
}


