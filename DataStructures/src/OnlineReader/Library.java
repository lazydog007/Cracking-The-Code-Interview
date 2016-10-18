package OnlineReader;

import java.util.HashMap;

public class Library {
	private HashMap<Integer, Book> books;
	
	public Book addBook(int id, String details){
		if(books.containsKey(id)){
			return null;
		}
		
		Book book = new Book(id, details);
		books.put(id, book); // puts element in the has map
		return book;
	}
	
	public boolean removeBook(Book b){
		int id = b.getID();
		
		if(!books.containsKey(id)){
			return false;
		}
		books.remove(id);
		return true;
	}
	
	// finds the book
	public Book find(int id){
		return books.get(id);
	}
}
