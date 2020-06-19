public abstract class Employee
//public  class Employee
{
//    private String name;
//    private String address;
//    private int number;

        protected String name;
    protected String address;
    protected int number;

    public Employee(String name, String address, int number)
    {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }
    public double computePay()
    {
        System.out.println("Inside Employee computePay");
        return 0.0;
    }
    public void mailCheck()
    {
        System.out.println("Within mailCheck of Employee class ");
        System.out.println("Mailing a check to " + this.name + " " + this.address);
    }
    public String toString()
    {
        return name + " " + address + " " + number;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String newAddress)
    {
        address = newAddress;
    }
    public int getNumber()
    {
        return number;
    }

//    public static void main(String [] args)
//    {
//        /* 以下是不允许的，会引发错误 */
//        Employee e = new Employee("George W.", "Houston, TX", 43);
//
//        System.out.println("\n Call mailCheck using Employee reference--");
//        e.mailCheck();
//    }
}