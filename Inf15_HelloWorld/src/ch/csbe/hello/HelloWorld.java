/**
 * 
 */
package ch.csbe.hello;

import java.util.ArrayList;
import java.util.List;

import ch.csbe.hello.expl.*;


/**
 * @author ebuchs
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int zahl = 567;
		char c = 'a';
		float f = 45.4f;
		double d = 45.4;
		boolean b = true;
		short s = 45;
		byte by = 4;
		
		String str = "Hallo Welt";
		String str1 = new String("Hallo Welt");
		Integer i = zahl;
		
		int zahlen[] = new int[5];
		zahlen[0] = 45;
		zahlen[1] = 34;
		
		System.out.println(zahlen[0]);
 		
		
		List<Integer> liste = new ArrayList<Integer>();
		liste.add(45);
		liste.add(656);
		
		for(int j = 0; j < liste.size(); j++){
			System.out.println(liste.get(j));
		}
		
		for(Integer j : liste){
			System.out.println(j);
		}
		
		final int pr = 45;
		
		switch(liste.get(0)){
		case pr: System.out.println("juhuu"); break;
		default: System.out.println("default"); break;
		}
		
		
		HelloInf.sayHello();
		HelloInf hello = new HelloInf();
		hello.sayHelloInst();
		
		HelloInfExpl hie = new HelloInfExpl();
		
		
		System.out.println("Hello World");

	}

}
