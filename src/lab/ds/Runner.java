package lab.ds;

import lab.ds.hashing.HashTable;

public class Runner {


public static void main(String args[])
{

	
	HashTable<String,String> myhash=new HashTable<String,String>();
	
	
	myhash.put("Tony", "Test");
	
	myhash.put("Tina", "Test2");
	
	
	System.out.println(myhash.get("Tony"));
	
	
	
	myhash.remove("Tony");
	
	System.out.println(myhash.get("Tony"));
	System.out.println(myhash.get("Tina"));

	
	
	
	
}

}
