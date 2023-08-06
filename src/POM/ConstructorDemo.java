package POM;

import net.bytebuddy.asm.Advice.This;

public class ConstructorDemo
{
	public ConstructorDemo()
	{
		System.out.println("ConstructorDemo");
	}
	int a;
	public ConstructorDemo(int a)
	{
		this.a=a;
		System.out.println(this.a);
	}
	
	public static void main(String[] args) 
	{
		ConstructorDemo c=new ConstructorDemo();
		ConstructorDemo c1=new ConstructorDemo(5);
		
	}

}
