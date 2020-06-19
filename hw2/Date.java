/* Date.java */

import java.io.*;

class Date {

  /* Put your private data fields here. */
	private int month;
	private int day;
	private int year;

  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
	if(isValidDate(month, day, year)){
		this.month=month;
		this.day=day;
		this.year=year;
	}
	else{
		System.out.println(month+"/"+day+"/"+year+" is not a valid date");
		System.exit(0);
	}

  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
	String[] field= s.split("/");
//Converting String into int using Integer.parseInt()  
	this.month=Integer.parseInt(field[0]);
	this.day=Integer.parseInt(field[1]);
	this.year=Integer.parseInt(field[2]);
  }
//	private static void test_DateString(){
//		Date db1=new Date("1/2/2001");
//		System.out.print("month= "+month+"day= "+day+"year "+year);
//		System.out.println("1/2/2001"+db1.isLeapYear(db1.year));	
//	}

  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
    return (year%400==0 || (year%4==0 && year%100!=0));           // replace this line with your solution
  }

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
	if(month==2){
		if(isLeapYear(year)){
			return 29;
		}
		else {
			return 28;	
		}		
	}
	else if(month==4||month==6||month==9||month==11){
		return 30;
	}
	else {
		return 31;	
	}
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {
    return (year>0 && 1<=month && month<=12 && 1<=day && day<=daysInMonth(month, year));                        // replace this line with your solution
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are expressed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
    return Integer.toString(this.month)+"/"+Integer.toString(this.day)+"/"+Integer.toString(this.year);                     // replace this line with your solution
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d. 
   */
  public boolean isBefore(Date d) {
	return (this.difference(d)<0);
//    return !this.isAfter(d);                        // replace this line with your solution
  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d. 
   */
  public boolean isAfter(Date d) {
	return (this.difference(d)>0);
/*
	if (this.difference(d)>0){
    		return true;
	}                        // replace this line with your solution
	else{
		return false;
	}
*/
  }

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is used only for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
	int Sum=0;
	if(this.month==1){
		return this.day;
	}
	else{
		for (int i=1; i<this.month; i++){
			Sum=Sum+daysInMonth(i, this.year);	
		}
    		return Sum+this.day;          // replace this line with your solution
	}

  }
	private int dayInAll(){
		int n_leap=0;
		// int sum=0;
		if(this.year==1){
			return this.dayInYear();		
		}
		else {
			for(int i=1; i<this.year;i++){
				if(isLeapYear(i)){
					n_leap=n_leap+1;
				}
			}
			// System.out.println(this.dayInYear()+"  "+n_leap+"  "+365*(this.year-1));
			return this.dayInYear()+n_leap+365*(this.year-1);
		}
		
	}
  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {
    return this.dayInAll()-d.dayInAll();                           // replace this line with your solution
  }

	private static void test_isLeapYear(){
		System.out.println("**************************");
		System.out.println("test leap year");
		Date db1=new Date(1,1,2001);
		System.out.println("2001 "+db1.isLeapYear(db1.year));
		Date db2=new Date(1,1,2000);
		System.out.println("2000 "+db2.isLeapYear(db2.year));
		Date db3=new Date(1,1,200);
		System.out.println("200 "+db3.isLeapYear(db3.year));
		Date db4=new Date(1,1,1800);
		System.out.println("1800 " +db4.isLeapYear(db4.year));
		Date db5=new Date(1,1,1900);
		System.out.println("1900 "+db5.isLeapYear(db5.year));
		Date db6=new Date(1,1,200);
		System.out.println("200 "+db6.isLeapYear(db6.year));
		Date db7=new Date(1,1,1600);
		System.out.println("1600 "+db7.isLeapYear(db7.year));
		System.out.println("**************************");
	}

  public static void main(String[] argv) {
	// test_isLeapYear();
	//test_DateString();

	//Date d0=new Date(10,2,-2018);
	//System.out.println("Date should be 1/1/1: " + d0);

	Date d0=new Date(2,10,2018);
	System.out.println("2,10,2018 day in year should be: " + d0.dayInYear());
	System.out.println("2,10,2018 days from 0 AD should be: " + d0.dayInAll());
    System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    /* I recommend you write code to test the isLeapYear function! */

    System.out.println("\nTesting before and after.");
    System.out.println(d2 + " after " + d1 + " should be true: " + 
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " + 
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " + 
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " + 
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " + 
                       d2.isAfter(d3));

    System.out.println(d1 + " before " + d2 + " should be true: " + 
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " + 
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " + 
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " + 
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " + 
                       d3.isBefore(d2));

    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));

  }
}
