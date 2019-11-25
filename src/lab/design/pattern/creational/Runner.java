package lab.design.pattern.creational;

public class Runner {

	public Runner() {
		
	}
	
	
	public static void main(String args[])
	{
		
	Singleton one=Singleton.getInstance();
	
	System.out.println(one);
	
	Singleton two=Singleton.getInstance();
	
	System.out.println(two);
	
		
		
		
	}

}
