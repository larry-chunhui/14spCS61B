class Person {
    private String name;
    private int birth;

    public void setBirth(int birth) {
        this.birth = birth;
    }

	public void setName(String name){
		this.name=name;	
	}

    public int getAge() {
        return calcAge(2019); // 调用private方法
    }

    // private方法:
    private int calcAge(int currentYear) {
        return currentYear - this.birth;
    }

    public static void main(String[] args) {
        Person ming = new Person();
        ming.setBirth(2008);
	ming.setName("xiao ming");
        System.out.println(ming.getAge());
	System.out.println(ming.calcAge(2029));

	System.out.println("ming.name= "+ming.name);
	System.out.println("ming.birth= "+ming.birth);

	ming.name="kobe";
	System.out.println("ming.name= "+ming.name);
	
    }
}

