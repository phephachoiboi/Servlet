package servlet.data;

import java.util.Vector;

public class DataBase {
	
	private static Vector<Entry> entries = new Vector<Entry>();
	
	
	public static void addEntry(Entry entry) {
		entries.add(entry);
	}
	
	
	public static String searchByUsername(String username) {
		
		StringBuilder results = new StringBuilder();
		
		for(Entry entry : entries) {
			
			results.append(entry.SearchByUsername(username));
		}
		
		
		return results.toString();
		
		
	}
	
	
	
public static String getAll() {
		
		StringBuilder results = new StringBuilder();
		
		for(Entry entry : entries) {
			
			results.append(entry.toString() + System.lineSeparator());
		}
		
		
		return results.toString();
		
		
	}


	
	
	//Define SearchByDate()
	//Define SearchByMessage()
	
	
	

}
