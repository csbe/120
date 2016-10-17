package ch.csbe.serialize.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ch.csbe.serialize.model.Exam;

/**
 * this class is useful for write an object into a file and reads from it
 * @version 1.0
 * @author ebuchs
 */
public class SerializeIO {
	
	/**
	 * The save method saves an exam object into a file
	 * @param Exam is an object from Type Exam
	 */
	public static void save(Exam e){
		try {
			FileOutputStream file = new FileOutputStream(e.getName()+".ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(e);
			out.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	/**
	 * Load a serialized object from file
	 * @param name String is the filename for load
	 * @return Exam the concrete exam object
	 */
	public static Exam load(String name){
		try {
			FileInputStream file = new FileInputStream(name + ".ser");
			ObjectInputStream in = new ObjectInputStream(file);
			return (Exam) in.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
