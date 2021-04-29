package prob02;

public class Book {
	private int bookNo;
	private int stateCode;
	private String title;
	private String author;

	public Book(int bookNo, String title, String author) {
		this.bookNo = bookNo;
		this.author = author;
		this.title = title;
		this.stateCode = 1;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
